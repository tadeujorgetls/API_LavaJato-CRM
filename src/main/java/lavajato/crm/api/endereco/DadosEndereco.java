package lavajato.crm.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

    @NotBlank
    String logradouro,

    @NotBlank
    String bairro,

    @NotBlank
    String numero,

    @NotBlank
    String complemento,

    @NotBlank
    String uf,
    
    @NotBlank
    String cidade,

    @NotBlank
    @Pattern(regexp = "\\d{8}")
    String cep) {

}
