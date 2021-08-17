package projeto.spring.data.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import projeto.spring.data.model.Telefone;
import projeto.spring.data.model.UsuarioSpringData;

import java.util.List;

@Repository
public interface InterfaceTelefone extends CrudRepository<Telefone, Long> {



}



