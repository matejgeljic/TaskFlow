import { FiUsers, FiFolder, FiGrid, FiPackage } from 'react-icons/fi';
export const PATHS = {
  base: '/',
  dashboard: '/dashboard',
  orders: '/orders',
  customers: '/customers',
  inventory: '/inventory',
};

export const SIDEBAR_ITEMS = [
  { title: 'Dashboard', icon: FiGrid, path: PATHS.dashboard },
  { title: 'Orders', icon: FiPackage, path: PATHS.orders },
  { title: 'Customers', icon: FiUsers, path: PATHS.customers },
  { title: 'Inventory', icon: FiFolder, path: PATHS.inventory },
];
