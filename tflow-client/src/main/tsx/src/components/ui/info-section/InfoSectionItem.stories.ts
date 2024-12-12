import { Meta, StoryObj } from '@storybook/react';
import InfoSectionItem, { DifferenceType, FormatType } from './InfoSectionItem';

const meta: Meta<typeof InfoSectionItem> = {
  component: InfoSectionItem,
  tags: ['autodocs'],
};

export default meta;

type Story = StoryObj<typeof InfoSectionItem>;

export const PositiveInfoSection: Story = {
  args: {
    title: 'Positive',
    value: 25,
    difference: 15,
    differenceType: DifferenceType.POSITIVE,
  },
};

export const NegativeInfoSection: Story = {
  args: {
    title: 'Negative currency',
    value: 25,
    difference: 15,
    differenceType: DifferenceType.NEGATIVE,
    formatType: FormatType.CURRENCY,
  },
};
