import React from 'react';
import { motion } from 'framer-motion';

export function Topbar() {
  return (
    <motion.div layout className={'h-20 bg-white pl-6 pt-7 font-bold'}>
      <span>Dashboard</span>
    </motion.div>
  );
}
