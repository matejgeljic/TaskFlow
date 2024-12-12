import React from 'react';
import { Card, CardHeader, CardIconColor } from '../ui/card/Card';
import { FiUsers } from 'react-icons/fi';
import InfoSectionItem, { DifferenceType, FormatType } from '../ui/info-section/InfoSectionItem';

export const CustomersInfoSection = () => {
  return (
    <Card>
      <CardHeader Icon={FiUsers} cardTitle={'Customers'} color={CardIconColor.SECONDARY} cardDescription={'This Week'} />
      <CustomersInfoSectionContent />
    </Card>
  );
};

const CustomersInfoSectionContent = () => {
  return (
    <div className={'flex justify-between gap-9 text-sm text-fontLight'}>
      <InfoSectionItem title={'Customers'} value={1250} difference={14.53} differenceType={DifferenceType.POSITIVE} formatType={FormatType.NUMBER} />
      <InfoSectionItem title={'Active'} value={1180} difference={85} differenceType={DifferenceType.POSITIVE} formatType={FormatType.NUMBER} />
    </div>
  );
};
