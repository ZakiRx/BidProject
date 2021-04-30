package zoz.bidproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

	@RequestMapping("/")
	public String start() {
		return "<h1 align='center'>Hello From Bid Home</h1>";
	}
	
}
