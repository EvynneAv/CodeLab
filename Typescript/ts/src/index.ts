//Rodar o código
//tsc
//node (arquivo compilado js)

// Tipos básicos
let age: number = 5;
const firstName: String = 'Evynne';
const inValid: boolean = true;
let idk: any = 0;
idk = 'hi';
idk = 22;

const ids: number[] = [2, 3, 4, 6, 5];
const booleans: boolean[] = [true, false];

// Tupla
const person: [number, string] = [2, '1'];

// Lista de tuplas
const people: [number, string][] = [
  [1, 'Evynne'],
  [2, 'Pedro'],
];

// Intersections
const productId: string | number = 1;

//Enum
enum Direction {
  up = 1,
  down = 2,
}

const direction = Direction.up;

// console.log(direction);

// type assertions
const productName: any = 'boné';

// let itemId: string;

// itemId = productName as string;
let itemId = <string>productName;
