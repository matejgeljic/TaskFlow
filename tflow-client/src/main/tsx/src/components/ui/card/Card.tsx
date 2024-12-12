import { PropsWithChildren } from 'react';
import { IconType } from 'react-icons';

export const Card = ({ children }: PropsWithChildren) => {
  return <div className={'flex flex-col gap-6 rounded-xl bg-white p-3'}>{children}</div>;
};

export enum CardIconColor {
  PRIMARY = 'primary',
  SECONDARY = 'secondary',
}

interface CardHeaderProps {
  Icon?: IconType;
  color: CardIconColor;
  cardTitle?: string;
  cardDescription?: string;
}

export const CardHeader = ({ Icon, color, cardTitle, cardDescription }: CardHeaderProps) => {
  const colorVariants = {
    primary: 'bg-primary text-primary',
    secondary: 'bg-secondary text-black',
  };

  const cardHeaderContent = Icon ? (
    <span className={`rounded-lg bg-opacity-15 p-2 ${colorVariants[color]}`}>
      <Icon />
    </span>
  ) : (
    <p className={'text-sm font-bold'}>{cardTitle}</p>
  );

  return (
    <div className={'text-2 flex items-center justify-between'}>
      {cardHeaderContent}
      <p className={'text-xs text-fontLight'}>{cardDescription}</p>
    </div>
  );
};
