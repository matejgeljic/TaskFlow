import { SalesInfoSection } from './SalesInfoSection';
import { CustomersInfoSection } from './CustomersInfoSection';
import { OrdersInfoSection } from './OrdersInfoSection';
import { MarketingChartSection } from './MarketingChartSection';
import { SalesChartSection } from './SalesChartSection';

const Dashboard = () => {
  return (
    <div className={'grid grid-cols-3 gap-4'}>
      <SalesInfoSection />
      <CustomersInfoSection />
      <OrdersInfoSection />
      <MarketingChartSection />
      <div className={'col-span-2'}>
        <SalesChartSection />
      </div>
    </div>
  );
};

export default Dashboard;
