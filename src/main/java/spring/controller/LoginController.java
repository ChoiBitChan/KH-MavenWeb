package spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.service.AuthenticationException;
import spring.service.Authenticator;
import spring.service.LoginCommand;
import spring.validator.LoginCommandValidator;

@Controller
@RequestMapping("/login/login.do")
public class LoginController {
	
	private String formViewName = "login/form";
	
	@Autowired
	private Authenticator authenticator;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}
	
	// 1번째 실행
	@ModelAttribute
	public LoginCommand formBacking() {
		return new LoginCommand();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	// 모델데이터에 같은 이름의 커맨드가 있으면 formBacking에 있는 LoginCommand 객체를 넣어준다
	public String submit(@Valid LoginCommand loginCommand, BindingResult result) {
		
		if(result.hasErrors()) {
			return formViewName;
		}
		
		try {
			authenticator.authenticate(loginCommand);
			return "redirect:/index.jsp";
		} catch (AuthenticationException e) {
			result.reject("invalidIdOrPassword", new Object[] {loginCommand.getUserId()}, null);
			return formViewName;
		}
		
	}
	
	// 2번째 실행
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new LoginCommandValidator());
	}
	
	public void setAuthenticator(Authenticator loginService) {
		this.authenticator = loginService;
	}

}
