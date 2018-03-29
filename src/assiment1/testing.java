package assiment1;

import Company.ComputerStore;
import Company.ComputerTechnician;
import Company.DeliveryPerson;
import Company.Importer;
import Company.QAPerson;
import other.Customer;

public class testing
{
	public static void main(String[] args)
	{
		
		ComputerTechnician tec = new ComputerTechnician();
		DeliveryPerson dp = new DeliveryPerson();
		Importer im = new Importer();
		QAPerson qa = new QAPerson();
		
		ComputerStore yossi = new ComputerStore(im, qa, tec, dp);
		
		Customer rina = new Customer("Rina");
		
		rina.creatNewOrder(yossi);

	}

}
