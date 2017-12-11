package mx.edu.utez.springboot.sendtomx.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.springboot.sendtomx.loggerConverter.ContactConverter;
import mx.edu.utez.springboot.sendtomx.loggerEntity.Contact;
import mx.edu.utez.springboot.sendtomx.loggerModel.ContactModel;
import mx.edu.utez.springboot.sendtomx.loggerRepository.ContactRepository;
import mx.edu.utez.springboot.sendtomx.loggerService.ContactService;

@Service
public class ContactServiceImpl implements  ContactService{

	@Autowired
	private ContactRepository contactRepository;
	
	
	@Autowired
	private ContactConverter contactConverter;
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		// TODO Auto-generated method stub
		
		Contact contact= contactRepository.save(contactConverter.convertContactModelToContact(contactModel));
		 return contactConverter.convertContactToContactModel(contact);
		 
	}

	@Override
	public List<ContactModel> listAllContacts() {
		// TODO Auto-generated method stub
		List<Contact> contacts=contactRepository.findAll();
		List<ContactModel> contactsModel=new LinkedList<>();
		for(Contact c:contacts){
			
			contactsModel.add(contactConverter.convertContactToContactModel(c));
		}
		return contactsModel;
	}

	@Override
	public Contact findContactById(int id) {
		// TODO Auto-generated method stub
		
		return contactRepository.findById(id);
	}

	public ContactModel findContactByIdModel(int id){
		return contactConverter.convertContactToContactModel(contactRepository.findById(id));
	}

	@Override
	public void removeContact(int id) {
		Contact contact=findContactById(id);
		if(contact !=null){
		contactRepository.delete(contact);
		}		
		
		
	}

}
