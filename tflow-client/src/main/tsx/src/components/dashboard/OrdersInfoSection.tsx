import React from 'react';
import { Card, CardHeader, CardIconColor } from '../ui/card/Card';
import { FiPackage, FiPieChart } from 'react-icons/fi';
import InfoSectionItem, { DifferenceType, FormatType } from '../ui/info-section/InfoSectionItem';

export const OrdersInfoSection = () => {
  return (
    <Card>
      <CardHeader Icon={FiPackage} cardTitle={'Sales'} color={CardIconColor.SECONDARY} cardDescription={'This Week'} />
      <OrdersInfoSectionContent />
    </Card>
  );
};

const OrdersInfoSectionContent = () => {
  return (
    <div className={'flex justify-between gap-9 text-sm text-fontLight'}>
      <InfoSectionItem title={'All orders'} value={450} formatType={FormatType.NUMBER} />
      <InfoSectionItem title={'Pending'} value={10} formatType={FormatType.NUMBER} />
      <InfoSectionItem title={'Completed'} value={440} formatType={FormatType.NUMBER} />
    </div>
  );
};
