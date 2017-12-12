package mx.edu.utez.springboot.sendtomx.loggerRepository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.springboot.sendtomx.loggerEntity.Contact;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, Serializable> {

	public abstract Contact findById(int id);
}
