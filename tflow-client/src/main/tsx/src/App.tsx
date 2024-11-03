import React from 'react';
import { Sidebar } from './components/navigation/Sidebar';
import { Topbar } from './components/navigation/Topbar';

const App = () => {
  return (
    <main className="flex bg-base">
      <Sidebar />
      <div className={'w-full'}>
        <Topbar />
        content
      </div>
    </main>
  );
};

export default App;
