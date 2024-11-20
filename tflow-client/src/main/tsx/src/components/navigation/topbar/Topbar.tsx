import React from 'react';
import { motion } from 'framer-motion';

const Topbar = () => {
  return (
    <motion.div layout className={'h-20 bg-white pl-6 pt-9 font-bold'}>
      <span>Dashboard</span>
    </motion.div>
  );
};

export default Topbar;
