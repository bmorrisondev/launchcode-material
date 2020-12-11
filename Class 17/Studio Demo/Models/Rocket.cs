using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Studio_Demo.Models
{
    public class Rocket
    {
        public string Name { get; set; }
        public int TotalCapacityKg { get; set; }
        public List<Cargo> CargoItems { get; set; }
        public List<Astronaut> Astronauts { get; set; }

        public Rocket(string name, int totalCapacityKg)
        {
            this.Name = name;
            this.TotalCapacityKg = totalCapacityKg;
            this.CargoItems = new List<Cargo>();
            this.Astronauts = new List<Astronaut>();
        }

        public double SumMass(List<Payload> items)
        {
            double sum = 0;
            if(items.Count > 0)
            {
                sum = items.Sum(i => i.MassKg);
            }
            return sum;
        }

        public double CurrentMassKg()
        {
            var cargoList = CargoItems.ToList<Payload>();
            var astronautList = Astronauts.ToList<Payload>();
            return SumMass(cargoList) + SumMass(astronautList);
        }

        public bool CanAdd(Payload item)
        {
            return CurrentMassKg() + item.MassKg <= this.TotalCapacityKg;
        }

        public bool AddCargo(Cargo cargo)
        {
            if(CanAdd(cargo))
            {
                CargoItems.Add(cargo);
                return true;
            }
            return false;
        }

        public bool AddAstronaut(Astronaut astronaut)
        {
            if(CanAdd(astronaut))
            {
                Astronauts.Add(astronaut);
                return true;
            }
            return false;
        }
    }
}
