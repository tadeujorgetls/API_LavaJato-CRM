package lavajato.crm.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lavajato.crm.api.cliente.Cliente;
import lavajato.crm.api.cliente.ClienteRepository;
import lavajato.crm.api.cliente.DadosCadastroClientes;

@RestController
@RequestMapping("clientes")
@CrossOrigin(origins = "http://localhost:8080")
public class LavaJatoController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid DadosCadastroClientes dados) {
        Cliente novoCliente = new Cliente(dados); // Cria um novo Cliente com os dados recebidos
        repository.save(novoCliente); // Salva o cliente no repositório
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
        //repository.save(dados);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> buscarPorCpf(@PathVariable String cpf) {
        Cliente cliente = repository.findByCpf(cpf);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}