package customers;

public class EmailSender implements IEmailSender {
	private String outgoingMailServer = "smtp.acme.com";

	public void sendEmail (String email, String message){
		System.out.println("EmailSender: sending '"+message+"' to "+email );
	}
	
	public String getOutgoingMailServer () {
		return outgoingMailServer;
	}
}
