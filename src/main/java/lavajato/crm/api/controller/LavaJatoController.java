package lavajato.crm.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
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
public class LavaJatoController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroClientes dados) {
        repository.save(new Cliente(dados));
    }

    @GetMapping
    public Page<Cliente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao);
    }
}