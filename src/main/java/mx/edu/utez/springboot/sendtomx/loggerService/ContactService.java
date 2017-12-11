package mx.edu.utez.springboot.sendtomx.loggerService;


import java.util.List;

import mx.edu.utez.springboot.sendtomx.loggerEntity.Contact;
import mx.edu.utez.springboot.sendtomx.loggerModel.ContactModel;

public interface ContactService {

	
	public abstract ContactModel addContact(ContactModel contactModel);
	public abstract List<ContactModel> listAllContacts();
	public abstract Contact findContactById(int id);
	public abstract ContactModel findContactByIdModel(int id);
	public abstract void removeContact(int id);
	
}
