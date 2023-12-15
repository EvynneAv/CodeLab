"use strict";
// Tipos básicos
let age = 5;
const firstName = 'Evynne';
const inValid = true;
let idk = 0;
idk = 'hi';
idk = 22;
const ids = [2, 3, 4, 6, 5];
const booleans = [true, false];
// Tupla
const person = [2, '1'];
// Lista de tuplas
const people = [
    [1, 'Evynne'],
    [2, 'Pedro'],
];
// Intersections
const productId = 1;
//Enum
var Direction;
(function (Direction) {
    Direction[Direction["up"] = 1] = "up";
    Direction[Direction["down"] = 2] = "down";
})(Direction || (Direction = {}));
const direction = Direction.up;
// console.log(direction);
// type assertions
const productName = 'boné';
// let itemId: string;
// itemId = productName as string;
let itemId = productName;
