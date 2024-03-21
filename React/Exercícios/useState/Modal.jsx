import React from 'react';

const Modal = ({ Modal, setModal }) => {
  if (Modal) {
    return (
      <div style={{ backgroundColor: 'lightblue' }}>
        esse é o modal
        <button onClick={() => setModal(false)}>Fechar</button>
      </div>
    );
  } else {
    return null;
  }
};

export default Modal;
