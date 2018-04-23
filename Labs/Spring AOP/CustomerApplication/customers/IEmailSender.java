package customers;

public interface IEmailSender {	
	String getOutgoingMailServer();
	void sendEmail(String email, String message);
}