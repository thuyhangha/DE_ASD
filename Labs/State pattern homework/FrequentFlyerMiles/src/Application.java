
public class Application {

	public static void main(String[] args) {
		FFAccount ffaccount = new FFAccount("1234567"); 
		ffaccount.setAccountState(new Silver(ffaccount));
		
		ffaccount.addFlight(13000);
		System.out.println("Accountnr ="+ffaccount.getAccountNumber()); 
		System.out.println("Account type ="+ffaccount.getAccountState().getAccountType()); 
		System.out.println("miles ="+ffaccount.getNumberOfMiles());
		ffaccount.addFlight(99000);
		System.out.println("Accountnr ="+ffaccount.getAccountNumber()); 
		System.out.println("Account type ="+ffaccount.getAccountState().getAccountType()); 
		System.out.println("miles ="+ffaccount .getNumberOfMiles());

	}

}
