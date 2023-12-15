interface MathFunc {
  (x: number, y: number): number;
}
const sub: MathFunc = (x:number, y:number){
  return x-y;
}
const sum = (x: number, y: number) => {
  return x + y;
};
const value = sum(2, 3);
console.log(sum(2, 3));

const log = (message: string) => {
  console.log(message);
};

log('alguma mensagem');
