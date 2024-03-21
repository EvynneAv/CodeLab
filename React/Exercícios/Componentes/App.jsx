import React from 'react';
import Header from './Header';
import Footer from './Footer';
import Form from './Form/Form';

const App = () => {
  return (
    <div>
      <Header />
      <p>Esse é o meu aplicativo</p>
      <Form />
      <Form />
      <Form />
      <Footer />
    </div>
  );
};

export default App;
