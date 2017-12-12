package mx.edu.utez.springboot.sendtomx.loggerController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.edu.utez.springboot.sendtomx.loggerConstant.ViewConstant;
import mx.edu.utez.springboot.sendtomx.loggerModel.ContactModel;
import mx.edu.utez.springboot.sendtomx.loggerModel.UserModel;
import mx.edu.utez.springboot.sendtomx.loggerService.ContactService;
import mx.edu.utez.springboot.sendtomx.loggerService.UserService;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("contacts")
public class ContactController {

    private static final Log LOG = LogFactory.getLog(ContactController.class);

    @Autowired
    private ContactService contactService;
    @Autowired
    private UserService userService;
    
    @PostMapping("/registrarUsuario")
    public String sendRegistroUsuarioHTML() {
        return "/registroUsuario";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("contactModel") UserModel userModel, RedirectAttributes model) {
        LOG.info("METHOD: addcontact() --PARAM : contactModel=" + userModel);
        if (null != userService.addUser(userModel)) {
            model.addFlashAttribute("result", 1);
        } else {
            model.addFlashAttribute("result", 0);
        }
        return "redirect:/login"; //Aqupi debería redireccionar al login despues de haberse registrado un usuario
    }

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/contacts/showcontacts";
    }

    @GetMapping("/contactform")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String redirectContactForm(@RequestParam(name = "id", required = false) Integer id, Model model) {
        ContactModel contactModel = new ContactModel();

        if (id != null) {
            contactModel = contactService.findContactByIdModel(id);
        }
        model.addAttribute("contactModel", contactModel);
        return ViewConstant.CONTACT_FORM;
    }

    @PostMapping("/addcontact")
    public String addContact(@ModelAttribute("contactModel") ContactModel contactModel, RedirectAttributes model) {
        LOG.info("METHOD: addcontact() --PARAM : contactModel=" + contactModel);
        if (null != contactService.addContact(contactModel)) {
            model.addFlashAttribute("result", 1);
        } else {
            model.addFlashAttribute("result", 0);
        }

        return "redirect:/contacts/showcontacts";
    }

    @GetMapping("/showcontacts")
    public ModelAndView showContacts() {
        ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username", user.getUsername());
        mav.addObject("contacts", contactService.listAllContacts());
        return mav;
    }

    @GetMapping("removecontact")
    public ModelAndView removeContact(@RequestParam(name = "id", required = true) int id) {

        contactService.removeContact(id);
        return showContacts();
    }
}
