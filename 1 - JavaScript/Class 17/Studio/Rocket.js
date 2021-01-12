"use strict";
exports.__esModule = true;
exports.Rocket = void 0;
var Rocket = /** @class */ (function () {
    function Rocket(name, totalCapacityKg) {
        this.cargoItems = [];
        this.astronauts = [];
        this.name = name;
        this.totalCapacityKg = totalCapacityKg;
    }
    Rocket.prototype.sumMass = function (items) {
        var totalMass = 0;
        items.forEach(function (i) {
            totalMass += i.massKg;
        });
        return totalMass;
    };
    Rocket.prototype.currentMassKg = function () {
        var totalAstronautMass = this.sumMass(this.astronauts);
        var totalCargoMass = this.sumMass(this.cargoItems);
        return totalAstronautMass + totalCargoMass;
    };
    Rocket.prototype.canAdd = function (item) {
        var massKg = this.currentMassKg();
        massKg += item.massKg;
        if (massKg <= this.totalCapacityKg) {
            return true;
        }
        else {
            return false;
        }
    };
    Rocket.prototype.addCargo = function (cargo) {
        if (this.canAdd(cargo)) {
            this.cargoItems.push(cargo);
            return true;
        }
        else {
            return false;
        }
    };
    Rocket.prototype.addAstronaut = function (astronaut) {
        if (this.canAdd(astronaut)) {
            this.astronauts.push(astronaut);
            return true;
        }
        else {
            return false;
        }
    };
    return Rocket;
}());
exports.Rocket = Rocket;
