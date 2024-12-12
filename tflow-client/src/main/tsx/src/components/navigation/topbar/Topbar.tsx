import React from 'react';
import { motion } from 'framer-motion';
import useTopbarTitle from './useTopbarTitle';

const Topbar = () => {
  const { currentTitle } = useTopbarTitle();

  return (
    <motion.div layout className={'h-20 bg-white pl-6 pt-9 font-bold'}>
      <span>{currentTitle!}</span>
    </motion.div>
  );
};

export default Topbar;
