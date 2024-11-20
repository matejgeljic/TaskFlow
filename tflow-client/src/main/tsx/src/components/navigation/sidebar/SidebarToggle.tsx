import React, { Dispatch, SetStateAction } from 'react';
import { motion } from 'framer-motion';
import { FiChevronsRight } from 'react-icons/fi';

const SidebarToggle = ({ isExpanded, setIsExpanded }: { isExpanded: boolean; setIsExpanded: Dispatch<SetStateAction<boolean>> }) => {
  const handleClick = () => {
    setIsExpanded((prevState) => !prevState);
  };
  return (
    <motion.span layout className={'mt-auto w-full justify-items-center pb-6'} onClick={handleClick}>
      <FiChevronsRight className={`transition-transform ${isExpanded && 'rotate-180'}`} />
    </motion.span>
  );
};

export default SidebarToggle;
