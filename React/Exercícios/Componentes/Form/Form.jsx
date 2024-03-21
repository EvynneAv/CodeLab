import React from 'react';
import Input from './Input';
import Button from './Button';

function Form() {
  return (
    <form action="">
      <p>
        <label htmlFor="nome"></label>
        <Input />
      </p>
      <p>
        <label htmlFor="email"></label>
        <Input />
      </p>
      <Button />
    </form>
  );
}

export default Form;
