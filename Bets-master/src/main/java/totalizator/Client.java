package totalizator;

import exeption.BillException;
import exeption.NameException;

public class Client {
    private String clientName;
    private double bill;

    public Client(String clientName, double bill) throws BillException, NameException {

            if (bill < 0) {
                throw new BillException();
            }


            this.clientName = clientName;
            this.bill = bill;            
           

    }

    public void setName(String name) {
        this.clientName = clientName;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public String getName() {
        return this.clientName;
    }

    public double getBill() {
        return this.bill;
    }
}

