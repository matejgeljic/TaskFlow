import React, { useState } from 'react';
import { motion } from 'framer-motion';
import { FiUsers, FiFolder, FiGrid, FiPackage } from 'react-icons/fi';
import SidebarTitleSection from './SidebarTitleSection';
import SidebarItem from './SidebarItem';
import SidebarToggle from './SidebarToggle';

export interface SidebarProps {
  onPageContentWidthChange: () => void;
}

const Sidebar = () => {
  const [isExpanded, setIsExpanded] = useState(true);
  const [selected, setSelected] = useState('Dashboard');

  const navigationWidth = isExpanded ? 'w-72' : 'w-fit';

  return (
    <motion.aside layout className={'flex h-screen flex-col gap-4 bg-white px-6 ' + navigationWidth}>
      <SidebarTitleSection isExpanded={isExpanded} />
      <SidebarItem Icon={FiGrid} title={'Dashboard'} selected={selected} setSelected={setSelected} isExpanded={isExpanded} />
      <SidebarItem Icon={FiPackage} title={'Orders'} selected={selected} setSelected={setSelected} isExpanded={isExpanded} />
      <SidebarItem Icon={FiUsers} title={'Customers'} selected={selected} setSelected={setSelected} isExpanded={isExpanded} />
      <SidebarItem Icon={FiFolder} title={'Inventory'} selected={selected} setSelected={setSelected} isExpanded={isExpanded} />
      <SidebarToggle isExpanded={isExpanded} setIsExpanded={setIsExpanded} />
    </motion.aside>
  );
};

export default Sidebar;
