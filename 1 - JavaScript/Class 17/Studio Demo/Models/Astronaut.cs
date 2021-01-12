using System;
using System.Collections.Generic;
using System.Text;

namespace Studio_Demo.Models
{
    public class Astronaut: Payload
    {
        public string Name { get; set; }

        public Astronaut(int massKg, string name)
        {
            this.MassKg = massKg;
            this.Name = name;
        }
    }
}
