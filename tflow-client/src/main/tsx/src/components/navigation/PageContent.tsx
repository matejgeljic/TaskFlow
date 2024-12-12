import Sidebar from './sidebar/Sidebar';
import Topbar from './topbar/Topbar';
import React from 'react';
import { Navigate, Route, Routes } from 'react-router-dom';
import { PATHS } from '../../constants';
import Dashboard from '../dashboard/Dashboard';

const PageContent = () => {
  return (
    <main className="flex">
      <Sidebar />
      <div className={'w-full bg-base'}>
        <Topbar />
        <div className={'px-6 pt-8'}>
          <Routes>
            <Route path={PATHS.base} element={<Navigate to={PATHS.dashboard} />} />
            <Route path={PATHS.dashboard} element={<Dashboard />} />
            <Route path={PATHS.orders} element={<h1>Orders</h1>} />
            <Route path={PATHS.customers} element={<h1>Customers</h1>} />
            <Route path={PATHS.inventory} element={<h1>Inventory</h1>} />
          </Routes>
        </div>
      </div>
    </main>
  );
};

export default PageContent;
