package org.launchcode.techjobs.console;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Created by LaunchCode
 */
public class JobData {

    private static final String DATA_FILE = "resources/job_data.csv";
    private static Boolean isDataLoaded = false;

    private static ArrayList<Position> allJobs;

    /**
     * Fetch list of all values from loaded data,
     * without duplicates, for a given column.
     *
     * @param field The column to retrieve values from
     * @return List of all of the values of the given field
     */
    public static ArrayList<String> findAll(String field) {
        // load data, if not already loaded
        loadData();

        ArrayList<String> values = new ArrayList<>();

        for(var job: allJobs) {
            String valueToAdd = "";
            if(field == "core competency") {
                valueToAdd = job.getCoreCompetency();
            }
            if(field == "employer") {
                valueToAdd = job.getEmployer();
            }
            if(field == "location") {
                valueToAdd = job.getLocation();
            }
            if(field == "position type") {
                valueToAdd = job.getPositionType();
            }
            if(!valueToAdd.equals("") && !values.contains(valueToAdd)) {
                values.add(valueToAdd);
            }
        }
        return values;
    }

    public static ArrayList<Position> findAll() {

        // load data, if not already loaded
        loadData();

        return allJobs;
    }

    public static ArrayList<Position> findByValue(String term) {
        loadData();

        ArrayList<Position> foundJobs = new ArrayList<>();

        for(var job: allJobs) {
            if(job.anyFieldsContainSearchTerm(term) && !foundJobs.contains(job)) {
                foundJobs.add(job);
            }
        }

        return foundJobs;
    }

    /**
     * Returns results of search the jobs data by key/value, using
     * inclusion of the search term.
     *
     * For example, searching for employer "Enterprise" will include results
     * with "Enterprise Holdings, Inc".
     *
     * @param column   Column that should be searched.
     * @param value Value of teh field to search for
     * @return List of all jobs matching the criteria
     */
    public static ArrayList<Position> findByColumnAndValue(String column, String value) {

        // load data, if not already loaded
        loadData();

        ArrayList<Position> jobs = new ArrayList<>();

        for (var job : allJobs) {
            if(job.doesFieldContainSearchTerm(column, value) && !jobs.contains(job)) {
                jobs.add(job);
            }
        }

        return jobs;
    }

    /**
     * Read in data from a CSV file and store it in a list
     */
    private static void loadData() {

        // Only load data once
        if (isDataLoaded) {
            return;
        }

        try {

            // Open the CSV file and set up pull out column header info and records
            Reader in = new FileReader(DATA_FILE);
            CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            List<CSVRecord> records = parser.getRecords();
            Integer numberOfColumns = records.get(0).size();
            String[] headers = parser.getHeaderMap().keySet().toArray(new String[numberOfColumns]);

            allJobs = new ArrayList<>();

            // Put the records into a more friendly format
            for (CSVRecord record : records) {
                String coreCompetency = record.get("core competency");
                String employer = record.get("employer");
                String location = record.get("location");
                String positionType = record.get("position type");
                String name = record.get("name");

                var position = new Position(name,
                        employer,
                        location,
                        positionType,
                        coreCompetency);

                allJobs.add(position);
            }

            // flag the data as loaded, so we don't do it twice
            isDataLoaded = true;

        } catch (IOException e) {
            System.out.println("Failed to load job data");
            e.printStackTrace();
        }
    }

}
