package lavajato.crm.api.cliente;

import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lavajato.crm.api.endereco.DadosEndereco;

public record DadosCadastroClientes(

    @NotBlank
    String nome,

    @NotBlank
    String telefone,

    @DateTimeFormat
    @Past
    @Future
    Date dataDeNascimento,

    @NotBlank
    @Email
    String email,

    @CPF
    @NotBlank
    @Pattern(regexp = "\\d{11}")
    String cpf,

    @NotNull
    @Valid
    DadosEndereco endereco) {
    
}