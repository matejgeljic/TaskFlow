import React from 'react';
import { Card, CardHeader, CardIconColor } from '../ui/card/Card';
import { FiPieChart } from 'react-icons/fi';
import InfoSectionItem, { DifferenceType, FormatType } from '../ui/info-section/InfoSectionItem';

export const SalesInfoSection = () => {
  return (
    <Card>
      <CardHeader Icon={FiPieChart} cardTitle={'Sales'} color={CardIconColor.PRIMARY} cardDescription={'This Week'} />
      <SalesInfoSectionContent />
    </Card>
  );
};

const SalesInfoSectionContent = () => {
  return (
    <div className={'flex justify-between gap-9 text-sm text-fontLight'}>
      <InfoSectionItem title={'Sales'} value={14.99} difference={0.03} differenceType={DifferenceType.POSITIVE} formatType={FormatType.CURRENCY} />
      <InfoSectionItem title={'Volume'} value={14.99} difference={0.1} differenceType={DifferenceType.NEGATIVE} formatType={FormatType.NUMBER} />
    </div>
  );
};
