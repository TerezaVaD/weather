package cs.vsb.tereza.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	@RequestMapping("/greeting")
	public String greeting() {
		return "Te pic a ahoj";
	}
}
