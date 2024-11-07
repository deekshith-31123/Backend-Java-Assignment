/*Create a class named Bank and other classes such as ICICI and HDFC. The Bank class should have default transaction charges, which will serve as the base. Based on these default charges, the ICICI and HDFC classes will calculate their specific transaction charges. Ensure that proper access specifiers are used throughout the code. */
class Bank {
    protected double defaultTransactionCharge = 5.0;

    public double getTransactionCharge() {
        return defaultTransactionCharge;
    }
}

class ICICI extends Bank {
    @Override
    public double getTransactionCharge() {
        return defaultTransactionCharge + 2.0;
    }
}

class HDFC extends Bank {
    @Override
    public double getTransactionCharge() {
        return defaultTransactionCharge + 1.5;
    }
}

public class BankDemo {
    public static void main(String[] args) {
        Bank icici = new ICICI();
        Bank hdfc = new HDFC();

        System.out.println("ICICI Transaction Charge: " + icici.getTransactionCharge());
        System.out.println("HDFC Transaction Charge: " + hdfc.getTransactionCharge());
    }
}
