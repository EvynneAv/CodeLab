import React, { useState } from 'react';
import Produto from './produto';
import { GlobalStorage } from './GlobalContext';
const App = () => {
  return (
    <div>
      <GlobalStorage>
        <Produto />
      </GlobalStorage>
    </div>
  );
};

export default App;
