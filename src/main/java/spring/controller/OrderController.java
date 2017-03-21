package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order/order.do")
public class OrderController {

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		// ViewName 으로 사용
		return "order/orderForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("order") OrderCommand orderCommand) {
		// ViewName 으로 사용
		return "order/orderCompletion";
	}
}
