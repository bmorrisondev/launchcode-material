package org.launchcode.techjobs_oo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JobTests {
    @Test
    public void testToString() {
        var job = new Job("test");
        assertEquals("", job.toString());
    }

    @Test
    public void testForBlankJobBeforeInfo() {
        var job = new Job("test");

        var actual = job.toString();

        assertTrue(actual.startsWith("\n"));
    }

    @Test
    public void testToString_NameIsEmpty_isDataNotAvailable() {
        var job = new Job("");

        var actual = job.toString();

        assertTrue(actual.contains("Name: Data not available"));
    }

    @Test
    public void testToString_NameIsPopulated_ShouldReturnName() {
        var job = new Job("Test Engineer");

        var actual = job.toString();

        assertTrue(actual.contains("Name: Test Engineer"));
    }

    @Test
    public void testToString_EmployerIsEmpty_ShouldReturnDataNotAvailable() {
        var employer = new Employer("");
        var job = new Job("Test Engineer", employer);
        
        var actual = job.toString();
        
        assertTrue(actual.contains("Employer: Data not available"));
    }
}
