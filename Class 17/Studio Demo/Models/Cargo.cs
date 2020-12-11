using System;
using System.Collections.Generic;
using System.Text;

namespace Studio_Demo.Models
{
    public class Cargo: Payload
    {
        public string Material { get; set; }

        public Cargo(double massKg, string material)
        {
            this.MassKg = massKg;
            this.Material = material;
        }
    }
}
