package projeto.spring.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tipo;

    @Column(nullable = false)
    private String numero;

    @ManyToOne(optional = false)
    private UsuarioSpringData usuarioSpringData;
}
