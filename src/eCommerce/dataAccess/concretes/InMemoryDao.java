package eCommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class InMemoryDao implements UserDao {
	List<User> users=new ArrayList<User>();
	public InMemoryDao() {
		super();
		User user5=new User(3, "Engin", "Demirog ", "engin@gmail.com", "1234567821", true);
	      
	      
	      users.add(user5);
	}

	@Override
	public void add(User user) {
     users.add(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int user›d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return users;
	}

	

}
