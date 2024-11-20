import React from 'react';
import PageContent from './components/navigation/PageContent';
import { BrowserRouter } from 'react-router-dom';

const App = () => {
  return (
    <BrowserRouter>
      <PageContent />
    </BrowserRouter>
  );
};

export default App;
