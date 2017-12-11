package mx.edu.utez.springboot.sendtomx.loggerController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class HelloWorldController.
 */
@Controller
@RequestMapping("test")
public class HelloWorldController {

	
	/** The Constant LOGGER. */
	private static final Log LOGGER=LogFactory.getLog(HelloWorldController.class);
	
	/**
	 * Go hello world.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("helloworld")
	public String goHelloWorld(Model model){
		
		LOGGER.info("logger info");
		LOGGER.warn("logger warn");
		LOGGER.error("logger error");
		LOGGER.debug("logger debug");
		model.addAttribute("name", "jose angel");
		
		return "helloworld";
	}
	
	/**
	 * Error.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("error")
	public String error(Model model){
		model.addAttribute("name", "jose angel");
		int a=6/0;
		return "helloworld";
	}
}
