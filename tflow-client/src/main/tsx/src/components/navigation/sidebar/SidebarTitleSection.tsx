import { motion } from 'framer-motion';
import React from 'react';
import TfLogo from '../../../assets/logo.svg?react';

const SidebarTitleSection = ({ isExpanded }: { isExpanded: boolean }) => {
  const title = isExpanded && (
    <motion.div>
      <span className="font-bold">TaskFlow</span>
    </motion.div>
  );

  return (
    <div className="my-6 flex h-10 w-full items-center gap-4 rounded-md p-6">
      <div className="flex items-center justify-center">
        <div className="flex items-center gap-4">
          <motion.div layout>
            <TfLogo />
          </motion.div>
          {title}
        </div>
      </div>
    </div>
  );
};

export default SidebarTitleSection;
