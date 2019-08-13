package Session6;

class BankAtm {
	String atmId;
	String bankName;
	String location;
	double balance;

	BankAtm(String atmId, String bankName, String location, double balance) {
		this.atmId = atmId;
		this.bankName = bankName;
		this.location = location;
		this.balance = balance;
	}

	void withdraw(double amt) throws BankATMException {
		if (balance < 10000)
			throw new BankATMException("Cannot withdraw. Balance is below $10000");
		else if (balance < amt)
			throw new BankATMException("Cannot withdraw. Your balance is only $" + balance);
		else
			balance = balance - amt;
	}

	void deposit(double amt) {
		balance = balance + amt;
	}

	void printBalance() {
		System.out.println(atmId + " Balance $" + balance);
	}
}

class BankATMException extends Exception {

	public BankATMException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}

public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BankAtm atm1 = new BankAtm("001", "Caught Bank", "Alpharetta", 12000);
		BankAtm atm2 = new BankAtm("002", "Obscure Bank", "Alpharetta", 10000);
		BankAtm atm3 = new BankAtm("003", "Lower Case Two Bank", "Alpharetta", 8000);

		try {
			atm1.printBalance();
			System.out.println("Withdrawing $15000...");
			atm1.withdraw(15000);
		} catch (BankATMException e) {
			e.printStackTrace();
		}
		System.out.println();
		try {
			atm3.printBalance();
			System.out.println("Withdrawing $2000...");
			atm3.withdraw(2000);
		} catch (BankATMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		atm2.printBalance();
		System.out.println("Depositing $3000...");
		atm2.deposit(3000);
		atm2.printBalance();


	}

}
