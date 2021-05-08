package eCommerce.business.abstracts;

import eCommerce.entities.concretes.LoginDto;
import eCommerce.entities.concretes.User;

public interface AuthService {
	void register(User user);
	void login(LoginDto dto);
	void verify(User user  );
	boolean Exists(String email);

}
