package lavajato.crm.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;
    private String uf;
    private String cidade;
    private String cep;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
        this.cep = dados.cep();
    }
}