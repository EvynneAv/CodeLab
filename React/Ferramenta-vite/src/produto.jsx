import React, { useContext } from 'react';
import { GlobalContext } from './GlobalContext';
const produto = () => {
  const global = React.useContext(GlobalContext);

  console.log(global);
  if (global.dados === null) return null;
  return (
    <div>
      Produto:
      {global.dados.map((produto) => (
        <li key={produto.id}>{produto.nome}</li>
      ))}{' '}
    </div>
  );
};

export default produto;
