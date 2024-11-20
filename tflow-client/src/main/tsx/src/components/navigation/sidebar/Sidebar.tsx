import React, { useState } from 'react';
import { motion } from 'framer-motion';
import SidebarTitleSection from './SidebarTitleSection';
import SidebarItem from './SidebarItem';
import SidebarToggle from './SidebarToggle';
import { SIDEBAR_ITEMS } from '../../../constants';

const Sidebar = () => {
  const [isExpanded, setIsExpanded] = useState<boolean>(true);
  const [selected, setSelected] = useState('Dashboard');

  const sidebarItems = SIDEBAR_ITEMS.map((item) => {
    return (
      <SidebarItem
        key={item.title}
        Icon={item.icon}
        title={item.title}
        selected={selected}
        setSelected={setSelected}
        isExpanded={isExpanded}
        path={item.path}
      />
    );
  });

  return (
    <motion.aside layout animate={{ width: isExpanded ? '288px' : '138px' }} className={'relative flex h-screen flex-col gap-4 bg-white px-6'}>
      <SidebarTitleSection isExpanded={isExpanded} />
      <SidebarToggle isExpanded={isExpanded} setIsExpanded={setIsExpanded} />
      {sidebarItems}
    </motion.aside>
  );
};

export default Sidebar;
