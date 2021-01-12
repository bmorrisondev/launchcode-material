using Studio_Demo.Models;
using System;
using System.Collections.Generic;
using System.Runtime.InteropServices.ComTypes;

namespace Studio_Demo
{
    class Program
    {
        static void Main(string[] args)
        {
            var falcon9 = new Rocket("Falcon 9", 7500);

            var astronauts = new List<Astronaut>()
            {
                new Astronaut(75, "Mae"),
                new Astronaut(81, "Sally"),
                new Astronaut(99, "Charles")
            };

            foreach(var astronaut in astronauts)
            {
                var status = "";
                if (falcon9.AddAstronaut(astronaut))
                {
                    status = "On board";
                }
                else
                {
                    status = "Not on board";
                }
                Console.WriteLine($"{astronaut.Name}: {status}");
            }

            var cargo = new List<Cargo>()
            {
                new Cargo(3107.39, "Satellite"),
                new Cargo(1000.39, "Space Probe"),
                new Cargo(753, "Water"),
                new Cargo(541, "Food"),
                new Cargo(2107.39, "Tesla Roadster"),
            };

            foreach(var c in cargo)
            {
                var loaded = "";
                if (falcon9.AddCargo(c))
                {
                    loaded = "Loaded";
                }
                else
                {
                    loaded = "Not loaded";
                }
                Console.WriteLine($"{c.Material}: {loaded}");
            }

            Console.WriteLine($"Final cargo and astronaut mass: {falcon9.CurrentMassKg()} kg.");
        }
    }
}
