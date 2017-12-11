package mx.edu.utez.springboot.sendtomx.loggerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.edu.utez.springboot.sendtomx.loggerService.ContactService;
import mx.edu.utez.springboot.sendtomx.loggerModel.ContactModel;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("rest")
public class RestController {


	@Autowired
	ContactService contactService;
	
	@GetMapping("checkrest")
	public ResponseEntity<String> checkRest(){
		return new ResponseEntity<>("OK!",HttpStatus.OK);
	}
	
	@GetMapping("contacts")
	public List<ContactModel> listAllContacts(){
		return contactService.listAllContacts();
	}
	
	@GetMapping("contactsentity")
	public ResponseEntity<List<ContactModel>> checkRest2(){
		return new ResponseEntity<>(contactService.listAllContacts(),HttpStatus.OK);
	}
}
