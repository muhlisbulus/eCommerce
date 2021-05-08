package eCommerce.business.concretes;



import eCommerce.business.abstracts.AuthService;
import eCommerce.business.abstracts.UserService;
import eCommerce.core.Utils;
import eCommerce.entities.concretes.LoginDto;
import eCommerce.entities.concretes.User;

public class AuthManager implements AuthService{
	private UserService userservice;
	

	public AuthManager(UserService userservice) {
		super();
		this.userservice = userservice;
	}

	@Override
	public void register(User user) {
		if(UserValidate(user)
				&&passwordValidate(user.getPassword())
				&&Exists(user.geteMail())==false
				&&Utils.emailValidate(user.geteMail())) {
			userservice.add(user);
			
			System.out.println("Kay�t ba�ar�l�");
		}
		else {
			System.out.println("Kay�t ba�ar�s�z!!!");
		}
	}

	@Override
	public void login(LoginDto dto) {
		User user=userservice.get(dto.getEmail());
		if(user!=null&& user.getPassword().equals(dto.getPassword())) {
			System.out.println("Ba�ar�yla giri� yapt�n�z");
		}
		else {
			System.out.println("Giri� ba�ar�s�z");
			
		}
		
	}

	@Override
	public void verify(User user) {
        System.out.println("Email do�ruland�" +user.geteMail());		
	}

	@Override
	public boolean Exists(String email) {
         User user=userservice.get(email); {
        	 if(user==null) {
        		 return false;
        	 }
        	 else {
        		 System.out.println("Email zaten mevcut"+email);
        		 return true;
        	 }
        	 
         }
			
		
			
		}
	
	public boolean UserValidate(User user) {
		if(user!=null && !user.getFirstName().isEmpty()&&!user.getLastName().isEmpty()&&
				!user.geteMail().isEmpty()&&!user.getPassword().isEmpty()){
		return true;
	}
			System.out.println("Bo� alan b�rakmay�n�z");
			return false;
	
		
	}



	public boolean passwordValidate(String password) {
		if(password.length()>=6) {
			return true;
			
		}
		
			System.out.println("Parola 6 karakterden uzun olmal�d�r");
			return false;
		
				
	
	}
}


