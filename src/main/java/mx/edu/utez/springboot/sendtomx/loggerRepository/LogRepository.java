package mx.edu.utez.springboot.sendtomx.loggerRepository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.springboot.sendtomx.loggerEntity.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Serializable>  {

}
