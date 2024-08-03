package lavajato.crm.api.cliente;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lavajato.crm.api.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_de_nascimento")
    private Date dataDeNascimento;

    @Embedded
    private Endereco endereco;

    public Cliente(DadosCadastroClientes dados) {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.dataDeNascimento = dados.dataDeNascimento();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }
}