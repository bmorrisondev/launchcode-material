import { Astronaut } from './Astronaut';
import { Cargo } from './Cargo'
import { Payload } from './Payload'

export class Rocket {
  name: string;
  totalCapacityKg: number;
  cargoItems: Cargo[] = [];
  astronauts: Astronaut[] = [];

  constructor(name, totalCapacityKg) {
    this.name = name;
    this.totalCapacityKg = totalCapacityKg;
  }

  sumMass(items: Payload[]): number {
    let totalMass = 0;
    items.forEach(i => {
      totalMass += i.massKg
    })
    return totalMass;
  }

  currentMassKg(): number {
    let totalAstronautMass = this.sumMass(this.astronauts);
    let totalCargoMass = this.sumMass(this.cargoItems);
    return totalAstronautMass + totalCargoMass;
  }

  canAdd(item: Payload): boolean {
    let massKg = this.currentMassKg();
    massKg += item.massKg;

    if(massKg <= this.totalCapacityKg) {
      return true
    } else {
      return false
    }
  }

  addCargo(cargo: Cargo): boolean {
    if(this.canAdd(cargo)) {
      this.cargoItems.push(cargo)
      return true;
    } else {
      return false;
    }
  }

  addAstronaut(astronaut: Astronaut): boolean {
    if(this.canAdd(astronaut)) {
      this.astronauts.push(astronaut)
      return true;
    } else {
      return false;
    }
  }
}