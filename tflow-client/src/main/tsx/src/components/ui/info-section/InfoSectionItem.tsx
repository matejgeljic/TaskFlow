import React from 'react';

interface InfoSectionItemProps {
  title: string;
  value: number;
  difference?: number;
  differenceType?: DifferenceType;
  formatType: FormatType;
}

export enum DifferenceType {
  POSITIVE = 'POSITIVE',
  NEGATIVE = 'NEGATIVE',
}

export enum FormatType {
  CURRENCY = 'CURRENCY',
  PERCENTAGE = 'PERCENTAGE',
  NUMBER = 'NUMBER',
}

const InfoSectionItem = ({ title, value, difference, differenceType, formatType }: InfoSectionItemProps) => {
  const differenceStyle = differenceType === DifferenceType.POSITIVE ? 'text-action' : 'text-danger';
  const differencePrefix = differenceType === DifferenceType.POSITIVE ? '+' : '-';

  const differenceValue = difference && <span className={'text-xs ' + differenceStyle}>{differencePrefix + difference}%</span>;

  return (
    <div className={'flex flex-col gap-2'}>
      <span>{title}</span>
      <div className={'flex gap-3'}>
        <span className={'font-bold text-black'}>{formatDashboardValue(value, formatType)}</span>
        {differenceValue}
      </div>
    </div>
  );
};

export default InfoSectionItem;

const formatDashboardValue = (value: number, valueType: FormatType) => {
  switch (valueType) {
    case FormatType.CURRENCY:
      return value.toString() + '€';
    case FormatType.PERCENTAGE:
      return value.toString() + '%';
    case FormatType.NUMBER:
    default:
      return value.toString();
  }
};
