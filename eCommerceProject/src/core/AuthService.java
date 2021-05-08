package core;

public interface AuthService {
	void registerWithGoogle(String email,String password,String firstName,String lastName);
    void loginWithGoogle(String email, String password);

}
