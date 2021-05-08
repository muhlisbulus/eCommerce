package eCommerce.core;


import eCommerce.googleMail.GoogleMail;

public class GoogleAuthAdapter implements GoogleService {
	

	@Override
	public void logToSystem(String email,String message) {
		GoogleMail mail=new GoogleMail(); 
		mail.google(email,message);
		
	}

	
	

	

	

}
