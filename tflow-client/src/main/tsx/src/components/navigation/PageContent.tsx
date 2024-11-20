import Sidebar from './sidebar/Sidebar';
import Topbar from './topbar/Topbar';
import React from 'react';

const PageContent = () => {
  return (
    <main className="flex bg-base">
      <Sidebar />
      <div className={'w-full'}>
        <Topbar />
          Content
      </div>
    </main>
  );
};

export default PageContent;
