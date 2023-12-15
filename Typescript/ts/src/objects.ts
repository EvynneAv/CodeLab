// type
type Order = {
  productId: string;
  price: number;
};
type User = {
  firstName: string;
  age: number;
  email: string;
  password?: string;
  orders: Order[];
  register?(): string;
};

const user: User = {
  firstName: 'Evynne',
  age: 20,
  email: 'Evynne@mail.com',
  orders: [{ productId: '1', price: 200 }],
  register() {
    return 'oloco';
  },
};

const printLog = (message: string) => {
  console.log(message);
};
// printLog(user.password) -> erro
// Com o "!" eu digo que essa senha existe mesmo
printLog(user.password!);

// Unions
type Author = {
  books: string[];
};
const author: Author & User = {
  age: 2,
  books: ['1'],
  orders: [],
  firstName: 'Evynne',
  email: 'Email',
};

// Interfaces
interface UserInterface {
  readonly firstName: string;
  email: string;
}

const emailUser: UserInterface = {
  email: 'evynne@8.com',
  firstName: 'evynne',
};

// emailUser.firstName = '12'; erro
// email.user.email = "email tal"; ok
