import { IconType } from 'react-icons';
import React, { Dispatch, SetStateAction } from 'react';
import { motion } from 'framer-motion';
import { useNavigate } from 'react-router-dom';

export interface SidebarItemProps {
  Icon: IconType;
  title: string;
  selected: string;
  setSelected: Dispatch<SetStateAction<string>>;
  isExpanded: boolean;
  path: string;
}
const SidebarItem = ({ Icon, title, selected, setSelected, isExpanded, path }: SidebarItemProps) => {
  const navigation = useNavigate();

  const handleClick = () => {
    setSelected(title);
    navigation(path);
  };
  const titleClass = selected === title ? 'text-white bg-primary' : 'text-font';
  const titleSection = isExpanded && (
    <motion.span layout initial={{ opacity: 0, y: 12 }} animate={{ opacity: 1, y: 0 }} transition={{ delay: 0.125 }}>
      {title}
    </motion.span>
  );

  return (
    <motion.div layout onClick={handleClick} className={'flex h-10 w-full cursor-pointer items-center gap-4 rounded-md p-6 ' + titleClass}>
      <motion.span className="grid h-full w-10 place-content-center text-lg">
        <Icon />
      </motion.span>
      {titleSection}
    </motion.div>
  );
};

export default SidebarItem;
