const returnValue = <T>(value: T): T => value;

const message = returnValue<String>('Hello world');

const count = returnValue<number>(5);

function getFirstValueArray<Type>(array: Type[]) {
  return array[0];
}

const firstValueFromStringArray = getFirstValueArray<string>(['1', '2', '3']);
const firstValueFromNumberArray = getFirstValueArray<number>([20, 200]);

// Promise
const returnPromise = async (): Promise<number> => {
  return 5;
};

//Classes
class GenericNumber<T> {
  zeroValue: any;
  sum: (x: T, y: T) => T;

  constructor(zeroValue: T, sum: (x: T, y: T) => T) {
    this.zeroValue = zeroValue;
    this.sum = sum;
  }
}

const myGeericNumber = new GenericNumber<number>(0, (x: number, y: number) => {
  return x + y;
});
