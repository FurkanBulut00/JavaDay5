package business.abstracts;

import entitites.concretes.User;

public interface AuthService {
	boolean validate(User user);
	boolean login(User user);
}
