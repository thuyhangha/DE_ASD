
public class FFAccount {

	private String accountNumber;
	private int numberOfMiles;
	private int numberOfFlights;
	private AccountState accountState;

	public FFAccount(String accNum) {
		accountNumber = accNum;
		accountState = new Silver(this);
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getNumberOfMiles() {
		return numberOfMiles;
	}

	public void setNumberOfMiles(int numberOfMiles) {
		this.numberOfMiles = numberOfMiles;
	}

	public int getNumberOfFlights() {
		return numberOfFlights;
	}

	public void setNumberOfFlights(int numberOfFlights) {
		this.numberOfFlights = numberOfFlights;
	}

	public AccountState getAccountState() {
		return accountState;
	}

	public void setAccountState(AccountState accountState) {
		this.accountState = accountState;
	}

	public void addFlight(int newMiles) {
		accountState.addFlight(newMiles);
	}
}
