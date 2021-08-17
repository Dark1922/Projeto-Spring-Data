package projeto.spring.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import projeto.spring.data.dao.InterfaceSpringDataUser;
import projeto.spring.data.dao.InterfaceTelefone;
import projeto.spring.data.model.Telefone;
import projeto.spring.data.model.UsuarioSpringData;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {

    @Autowired
    private InterfaceSpringDataUser interfaceSpringDataUser;

    @Autowired
    private InterfaceTelefone interfaceTelefone;

    @Test
    public void testeInsert() {

        UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
        usuarioSpringData.setEmail("teste@gmail.com");
        usuarioSpringData.setIdade(21);
        usuarioSpringData.setLogin("teste 123");
        usuarioSpringData.setSenha("123");
        usuarioSpringData.setNome("Testanto1");

        interfaceSpringDataUser.save(usuarioSpringData);

        System.out.println("Usuário cadastrado -> " + interfaceSpringDataUser.count());

    }

    @Test
    public void testeConsulta() {
        Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
        System.out.println(usuarioSpringData.get().getId());
        System.out.println(usuarioSpringData.get().getNome());
        System.out.println(usuarioSpringData.get().getEmail());
        System.out.println(usuarioSpringData.get().getIdade());
        System.out.println(usuarioSpringData.get().getLogin());
        System.out.println(usuarioSpringData.get().getSenha());


        for(Telefone telefone : usuarioSpringData.get().getTelefones()){
            System.out.println(telefone.getNumero());
            System.out.println(telefone.getTipo());
            System.out.println(telefone.getId());
            System.out.println(telefone.getUsuarioSpringData().getNome());
        }

    }

    @Test
    public void testeConsultaTodos() {
        Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();

        for (UsuarioSpringData usuarioSpringData : lista) {
            System.out.println(usuarioSpringData.getId());
            System.out.println(usuarioSpringData.getNome());
            System.out.println(usuarioSpringData.getEmail());
            System.out.println(usuarioSpringData.getIdade());
            System.out.println(usuarioSpringData.getLogin());
            System.out.println(usuarioSpringData.getSenha());
            System.out.println("---------------------------------------------------------");
        }
    }

    @Test
    public void testeUpdade() {
        Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);

        UsuarioSpringData data = usuarioSpringData.get();
        data.setNome("Marcus Vinicius Update Spring dATA");
        interfaceSpringDataUser.save(data);
    }

    @Test
    public void testeDelete() {
        interfaceSpringDataUser.deleteById(5L);
    }

    @Test
    public void testeConsultaNome() {
        List<UsuarioSpringData> list = interfaceSpringDataUser.buscaPorNome("Vinicius");

        for (UsuarioSpringData usuarioSpringData : list) {
            System.out.println(usuarioSpringData.getId());
            System.out.println(usuarioSpringData.getNome());
            System.out.println(usuarioSpringData.getEmail());
            System.out.println(usuarioSpringData.getIdade());
            System.out.println(usuarioSpringData.getLogin());
            System.out.println(usuarioSpringData.getSenha());
            System.out.println("---------------------------------------------------------");
        }
    }

    @Test
    public void testeConsultaNomeParam() {
        UsuarioSpringData usuarioSpringData = interfaceSpringDataUser.buscaPorNomeParam("Vinicius");

        System.out.println(usuarioSpringData.getId());
        System.out.println(usuarioSpringData.getNome());
        System.out.println(usuarioSpringData.getEmail());
        System.out.println(usuarioSpringData.getIdade());
        System.out.println(usuarioSpringData.getLogin());
        System.out.println(usuarioSpringData.getSenha());
        System.out.println("---------------------------------------------------------");
    }

    @Test
    public void testeDeletePorNome(){
        interfaceSpringDataUser.deletePorNome("Delete por Nome");
    }

    @Test
    public void testeUpdateEmailPorNome(){
        interfaceSpringDataUser.updateEmailPorNome("testeUpdate@gmail.com", "Vinicius" );
    }

    @Test
    public void testeInsertTelefone(){

        Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);

        Telefone telefone = new Telefone();
        telefone.setTipo("celular");
        telefone.setNumero("5453455454545");
        telefone.setUsuarioSpringData(usuarioSpringData.get());

        interfaceTelefone.save(telefone);
    }
    @Test
    public void blaAbriBanco() {
    	System.out.println("oi banco");
    }


}

