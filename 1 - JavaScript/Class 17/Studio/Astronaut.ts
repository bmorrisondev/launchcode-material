import { Payload } from "./Payload";

export class Astronaut implements Payload {
  massKg: number = 0;
  name: string = "";

  constructor(massKg: number, name: string) {
    this.massKg = massKg;
    this.name = name;
  }
}