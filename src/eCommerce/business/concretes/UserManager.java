package eCommerce.business.concretes;

import java.util.List;

import eCommerce.business.abstracts.UserService;

import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class UserManager implements UserService {
	private UserDao userdao;
	
	

	public UserManager(UserDao userdao) {
		super();
		this.userdao = userdao;
		
	}

	@Override
	public void add(User user) {
         
        	userdao.add(user);

        	
         
	}

	@Override
	public void update(User user) {
		System.out.println("Güncelleme iþlemi tamamlandý ");
	}

	@Override
	public void delete(int userÝd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(String email) {
		// TODO Auto-generated method stub
		return userdao.get(email);
	}

	@Override
	public List<User> getAll() {
		for (User user : userdao.getAll()) { 
			System.out.println(user.getId() + " "+user.geteMail() + " " +user.getFirstName()+  " "  +user.getLastName());
			
		}
		return userdao.getAll();
	}
	
		public boolean userValidate(User user) {
			if(user.getFirstName().length()>=2&&user.getLastName().length()>=2) {
				return true;
			}
			System.out.println("Adýnýz ve soyadýnýz 2 karakterden küçük olmamalý");
			return false;
		}
		
	}
	

