import React, { useState } from 'react';
import ButtonModal from './ButtonModal';
import Modal from './Modal';

const App = () => {
  const [ativo, setAtivo] = React.useState(true);
  const [dados, setDados] = React.useState({ nome: 'Evynne', idade: 23 });

  function handleClick() {
    setAtivo(!ativo);
    setDados({ ...dados, faculdade: 'Graduando' });
  }

  const [modal, setModal] = React.useState(false);
  return (
    <>
      <p>{dados.nome}</p>
      <p>{dados.idade}</p>
      <p>{dados.faculdade}</p>
      <button onClick={handleClick}>
        {ativo ? 'botão ativo' : 'Botão inativo'}
      </button>
      <Modal setModal={setModal} Modal={modal} />
      <br />
      <ButtonModal setModal={setModal} />
    </>
  );
};

export default App;
