import { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';

const formatTitle = (location: string) => {
  if (location.includes('-')) {
    return location
      .substring(1, location.length)
      .split('-')
      .map((word) => word[0].toUpperCase() + word.substring(1, word.length))
      .join(' ');
  }

  const title = location.slice(1, location.length).split('/')[0];
  return title[0].toUpperCase() + title.substring(1, title.length);
};

const useTopbarTitle = () => {
  const [currentTitle, setCurrentTitle] = useState<string | null>(null);

  const location = useLocation();

  useEffect(() => {
    const title = formatTitle(location.pathname);

    setCurrentTitle(title);
  }, [location.pathname]);

  return {
    currentTitle,
  };
};

export default useTopbarTitle;
