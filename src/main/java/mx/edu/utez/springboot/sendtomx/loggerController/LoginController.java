package mx.edu.utez.springboot.sendtomx.loggerController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.edu.utez.springboot.sendtomx.loggerConstant.ViewConstant;
import mx.edu.utez.springboot.sendtomx.loggerModel.UserCredential;
import mx.edu.utez.springboot.sendtomx.loggerModel.UserModel;
import mx.edu.utez.springboot.sendtomx.loggerService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    private static final Log LOG = LogFactory.getLog(LoginController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm(Model model,
            @RequestParam(name = "error", required = false) String error,
            @RequestParam(name = "logout", required = false) String logout) {
        LOG.info("METHOD: showLoginForm() --PARAM : error=" + error + ", logout:" + logout);

        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        LOG.info("Returning to login view");
        return ViewConstant.LOGIN;
    }

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public String loginCheck(@ModelAttribute("userCredentials") UserCredential userCredential) {
        LOG.info("ENTRA A LoginController:/loginCheck");
        //LOG.info("METHOD: loginCheck() --PARAM : userCredentials="+userCredential);
        if (userCredential.getUsername().equals("username") && userCredential.getPassword().equals("password")) {
            LOG.info(userCredential.getUsername() + " " + userCredential.getPassword());
            LOG.info("Entra al direccionamiento a ver los contactos");
            return "redirect:/contacts/showcontacts";
        } else {
            LOG.info("Returning to login?error view aaaaaaaaaaaaaaaa");
            return "redirect:login?error";
        }
    }

    @GetMapping({"/loginsuccess", "/"})
    public String loginCheck() {
        LOG.info("METHOD: loginCheck() --PARAM : userCredentials=");

        LOG.info("Returning to login?error view");
        return "redirect:/contacts/showcontacts";
    }

    @RequestMapping(value = "/registrarUsuario", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contactModel") UserModel userModel, RedirectAttributes model) {
        LOG.info("METHOD: addcontact() --PARAM : contactModel=" + userModel);
        if (null != userService.addUser(userModel)) {
            model.addFlashAttribute("result", 1);
        } else {
            model.addFlashAttribute("result", 0);
        }
        return "redirect:/login";
    }
    
    

    /*
	@GetMapping("/")
	public String redirectToLogin(){
		LOG.info("METHOD: redirectToLogin()");
		return "redirect:login";
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name="error",required=false)String error,
		 @RequestParam(name="logout",required=false)String logout){
		LOG.info("METHOD: showLoginForm() --PARAM : error="+error+", logout:"+logout);
		UserCredential  userCredential=new UserCredential();
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredentials", userCredential);
		LOG.info("Returning to login view");
		return ViewConstant.LOGIN;
	}
     */
}
