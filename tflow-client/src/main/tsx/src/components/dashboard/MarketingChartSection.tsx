import React from 'react';
import { Card, CardHeader, CardIconColor } from '../ui/card/Card';
import { Chart as ChartJS, ArcElement, Tooltip, Legend, ChartOptions } from 'chart.js';
import { Doughnut } from 'react-chartjs-2';

export const MarketingChartSection = () => {
  return (
    <Card>
      <CardHeader color={CardIconColor.PRIMARY} cardTitle={'Marketing'} cardDescription={'This week'} />
      <MarketingInfoSectionContent />
    </Card>
  );
};

ChartJS.register(ArcElement, Tooltip, Legend);

const MarketingInfoSectionContent = () => {
  const data = {
    labels: ['Acquisition', 'Purchase', 'Retention'],
    datasets: [
      {
        data: [60, 10, 30],
        backgroundColor: ['#5570F1', '#97A5EB', '#FFCC91'],
        borderWidth: 0,
        cutout: '70%',
        radius: '90%',
      },
    ],
  };
  const options: ChartOptions<'doughnut'> = {
    plugins: {
      legend: {
        display: true,
        position: 'top',
        align: 'center',
        labels: {
          usePointStyle: true,
          pointStyle: 'circle',
          boxWidth: 10,
          padding: 20,
        },
      },
      tooltip: {
        enabled: true,
      },
    },
  };

  return <Doughnut data={data} options={options} />;
};
