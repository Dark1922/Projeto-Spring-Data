package projeto.spring.data.dao;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import projeto.spring.data.model.UsuarioSpringData;

import javax.persistence.LockModeType;
import java.util.List;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long> {

    @Transactional(readOnly = true) // Apenas para leitura, esse código não pode fazer alteração no banaco
    @Query(value = "select p from UsuarioSpringData p where p.nome like %?1%")
    public List<UsuarioSpringData> buscaPorNome(String nome);

    @Lock(LockModeType.READ) // Controle de Transação
    @Transactional(readOnly = true) // Apenas para leitura, esse código não pode fazer alteração no banaco
    @Query(value = "select p from UsuarioSpringData p where p.nome = :paramnome")
    public UsuarioSpringData buscaPorNomeParam(@Param("paramnome") String paramnome);

    @Modifying
    @Transactional
    @Query("delete from UsuarioSpringData u where u.nome = ?1")
    public void deletePorNome(String nome);

    @Modifying
    @Transactional()
    @Query("update UsuarioSpringData u set u.email = ?1 where u.nome = ?2")
    public void updateEmailPorNome(String email, String nome);
}



