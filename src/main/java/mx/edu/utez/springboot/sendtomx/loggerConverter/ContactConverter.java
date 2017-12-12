package mx.edu.utez.springboot.sendtomx.loggerConverter;

import org.springframework.stereotype.Component;

import mx.edu.utez.springboot.sendtomx.loggerEntity.Contact;
import mx.edu.utez.springboot.sendtomx.loggerModel.ContactModel;

@Component
public class ContactConverter {

    public Contact convertContactModelToContact(ContactModel contactModel) {

        Contact contact = new Contact();
        contact.setId(contactModel.getId());
        contact.setFirstname(contactModel.getFirstname());
        contact.setLastname(contactModel.getLastname());
        contact.setTelephone(contactModel.getTelephone());
        contact.setCity(contactModel.getCity());
        return contact;
    }

    public ContactModel convertContactToContactModel(Contact contact) {

        ContactModel contactModel = new ContactModel();
        contactModel.setId(contact.getId());
        contactModel.setFirstname(contact.getFirstname());
        contactModel.setLastname(contact.getLastname());
        contactModel.setTelephone(contact.getTelephone());
        contactModel.setCity(contact.getCity());
        return contactModel;
    }
}
