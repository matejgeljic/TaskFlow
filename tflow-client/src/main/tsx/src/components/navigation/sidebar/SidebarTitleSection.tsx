import { motion } from 'framer-motion';
import React from 'react';
import TfLogo from '../../../assets/logo.svg?react';

const SidebarTitleSection = ({ isExpanded }: { isExpanded: boolean }) => {
  const title = isExpanded && (
    <motion.div layout initial={{ opacity: 0, y: 12 }} animate={{ opacity: 1, y: 0 }} transition={{ delay: 0.125 }}>
      <span className="font-bold">Massimo</span>
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
};

export default SidebarTitleSection;
