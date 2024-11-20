import React, { Dispatch, SetStateAction } from 'react';
import { FiChevronsRight, FiChevronsLeft } from 'react-icons/fi';

const SidebarToggle = ({ isExpanded, setIsExpanded }: { isExpanded: boolean; setIsExpanded: Dispatch<SetStateAction<boolean>> }) => {
  const handleClick = () => {
    setIsExpanded((prevState) => !prevState);
  };

  const toggleIcon = isExpanded ? <FiChevronsRight /> : <FiChevronsLeft />;

  return (
    <button
      className={'pointer absolute -right-3 top-9 z-10 flex h-6 w-6 items-center justify-center rounded-[16px] border border-font'}
      onClick={handleClick}
    >
      {toggleIcon}
    </button>
  );
};

export default SidebarToggle;
