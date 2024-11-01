import React, { Dispatch, SetStateAction, useState } from 'react';
import { motion } from 'framer-motion';
import { IconType } from 'react-icons';
import { FiUsers, FiFolder, FiGrid, FiPackage, FiChevronsRight } from 'react-icons/fi';
import TfLogo from '../../assets/logo.svg?react';

export function Navigation() {
  const [isExpanded, setIsExpanded] = useState(true);
  const [selected, setSelected] = useState('Dashboard');

  const navigationWidth = isExpanded ? 'w-72' : 'w-fit';

  return (
    <motion.nav layout className={'flex h-screen flex-col gap-4 bg-white px-6 ' + navigationWidth}>
      <TitleSection isExpanded={isExpanded} />
      <NavigationItem Icon={FiGrid} title={'Dashboard'} selected={selected} setSelected={setSelected} isExpanded={isExpanded} />
      <NavigationItem Icon={FiPackage} title={'Orders'} selected={selected} setSelected={setSelected} isExpanded={isExpanded} />
      <NavigationItem Icon={FiUsers} title={'Customers'} selected={selected} setSelected={setSelected} isExpanded={isExpanded} />
      <NavigationItem Icon={FiFolder} title={'Inventory'} selected={selected} setSelected={setSelected} isExpanded={isExpanded} />
      <ToggleExpanded isExpanded={isExpanded} setIsExpanded={setIsExpanded} />
    </motion.nav>
  );
}

export interface NavigationItemProps {
  Icon: IconType;
  title: string;
  selected: string;
  setSelected: Dispatch<SetStateAction<string>>;
  isExpanded: boolean;
}
export function NavigationItem({ Icon, title, selected, setSelected, isExpanded }: NavigationItemProps) {
  const handleClick = () => {
    setSelected(title);
  };
  const titleClass = selected === title ? 'text-white bg-primary' : 'text-font';
  const titleSection = isExpanded && (
    <motion.span layout initial={{ opacity: 0, y: 12 }} animate={{ opacity: 1, y: 0 }} transition={{ delay: 0.125 }}>
      {title}
    </motion.span>
  );

  return (
    <motion.span layout onClick={handleClick} className={'flex h-10 w-full items-center gap-4 rounded-md p-6 transition-colors ' + titleClass}>
      <motion.div layout className="grid h-full w-10 place-content-center text-lg">
        <Icon />
      </motion.div>
      {titleSection}
    </motion.span>
  );
}

export function TitleSection({ isExpanded }: { isExpanded: boolean }) {
  const title = isExpanded && (
    <motion.div layout initial={{ opacity: 0, y: 12 }} animate={{ opacity: 1, y: 0 }} transition={{ delay: 0.125 }}>
      <span className="font-bold">TaskFlow</span>
    </motion.div>
  );

  return (
    <div className="my-6 pb-3">
      <div className="flex items-center justify-center">
        <div className="flex items-center gap-2">
          <motion.div layout>
            <TfLogo />
          </motion.div>
          {title}
        </div>
      </div>
    </div>
  );
}

export function ToggleExpanded({ isExpanded, setIsExpanded }: { isExpanded: boolean; setIsExpanded: Dispatch<SetStateAction<boolean>> }) {
  return (
    <motion.span
      layout
      className={'w-full justify-items-center mt-auto pb-6'}
      onClick={() => {
        setIsExpanded((prevState) => !prevState);
      }}
    >
      <FiChevronsRight className={`transition-transform ${isExpanded && 'rotate-180'}`} />
    </motion.span>
  );
}
