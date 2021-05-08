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
			
			System.out.println("Kayıt başarılı");
		}
		else {
			System.out.println("Kayıt başarısız!!!");
		}
	}

	@Override
	public void login(LoginDto dto) {
		User user=userservice.get(dto.getEmail());
		if(user!=null&& user.getPassword().equals(dto.getPassword())) {
			System.out.println("Başarıyla giriş yaptınız");
		}
		else {
			System.out.println("Giriş başarısız");
			
		}
		
	}

	@Override
	public void verify(User user) {
        System.out.println("Email doğrulandı" +user.geteMail());		
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
			System.out.println("Boş alan bırakmayınız");
			return false;
	
		
	}



	public boolean passwordValidate(String password) {
		if(password.length()>=6) {
			return true;
			
		}
		
			System.out.println("Parola 6 karakterden uzun olmalıdır");
			return false;
		
				
	
	}
}


