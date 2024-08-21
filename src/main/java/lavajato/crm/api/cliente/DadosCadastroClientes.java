package lavajato.crm.api.cliente;

import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past(message = "A data de nascimento deve ser uma data passada")
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