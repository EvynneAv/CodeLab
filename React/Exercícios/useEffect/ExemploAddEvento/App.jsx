import React, { useState } from 'react';
import Produto from './produto';
const App = () => {
  const [ativo, setAtivo] = React.useState(false);

  return (
    <div>
      {ativo && <Produto />}
      <button onClick={() => setAtivo(!ativo)}>Ativo</button>
    </div>
  );
};

export default App;
