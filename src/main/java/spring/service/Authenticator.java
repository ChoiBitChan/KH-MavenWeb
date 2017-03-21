package spring.service;

import org.springframework.beans.factory.annotation.Autowired;

public interface Authenticator {
	
	void authenticate(LoginCommand loginCommand) throws AuthenticationException;

}
