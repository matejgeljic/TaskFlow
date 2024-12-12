import React from 'react';
import { Chart as ChartJS, BarElement, Tooltip, Legend, CategoryScale, LinearScale, ChartOptions } from 'chart.js';
import { Bar } from 'react-chartjs-2';
import { Card, CardHeader, CardIconColor } from '../ui/card/Card';

export const SalesChartSection = () => {
  return (
    <Card>
      <CardHeader color={CardIconColor.PRIMARY} cardTitle={'Sales'} cardDescription={'This week'} />
      <SalesInfoSectionContent />
    </Card>
  );
};

ChartJS.register(BarElement, CategoryScale, LinearScale, Tooltip, Legend);

const SalesInfoSectionContent = () => {
  const dates = getLast7Days();

  const data = {
    labels: dates,
    datasets: [
      {
        data: [85, 25, 60, 10, 75, 55, 75],
        backgroundColor: '#97A5EB',
      },
    ],
  };

  const options: ChartOptions<'bar'> = {
    plugins: {
      legend: {
        display: false,
      },
    },
    scales: {
      y: {
        ticks: {
          stepSize: 20,
        },
        min: 0,
        max: 100,
        grid: {
          display: false,
        },
      },
      x: {
        grid: {
          display: false,
        },
      },
    },
  };
  return <Bar data={data} options={options} />;
};

function getLast7Days(): string[] {
  const result = [];
  const today = new Date();

  for (let i = 0; i < 7; i++) {
    const date = new Date();
    date.setDate(today.getDate() - i);

    const formattedDate = date.toLocaleString('en-US', {
      month: 'short',
      day: 'numeric',
    });

    result.push(formattedDate);
  }

  return result.reverse();
}
