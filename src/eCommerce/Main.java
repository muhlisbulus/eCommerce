package eCommerce;

import eCommerce.business.concretes.AuthManager;
import eCommerce.business.concretes.UserManager;
import eCommerce.dataAccess.concretes.InMemoryDao;
import eCommerce.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		InMemoryDao dao=new InMemoryDao();
		User user1=new User(1, "Muhlis", "Buluþ", "muhlisbulus@gmail.com", "12345678", true);
		
		
		AuthManager authManager=new AuthManager(new UserManager(dao));
		authManager.register(user1);
		
		
		UserManager userManager=new UserManager(dao);
		userManager.getAll();

	}

}
