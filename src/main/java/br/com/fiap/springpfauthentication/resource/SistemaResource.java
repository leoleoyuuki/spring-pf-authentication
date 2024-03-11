package br.com.fiap.springpfauthentication.resource;

import br.com.fiap.springpfauthentication.entity.Perfil;
import br.com.fiap.springpfauthentication.entity.Sistema;
import br.com.fiap.springpfauthentication.repository.SistemaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sistema")
public class SistemaResource {

    @Autowired
    private SistemaRepository repo;

    @GetMapping
    public List<Sistema> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Sistema findById(@PathVariable Long id) {
        return repo.findById( id ).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Sistema save(@RequestBody Sistema sistema) {
        return repo.save( sistema );
    }

    @Transactional
    @GetMapping(value = "/{id}/responsaveis")
    public Sistema findByIdSistema(@PathVariable Long id) {
        return repo.findById( id ).orElseThrow();
    }

    @Transactional
    @PostMapping(value = "/{id}/responsaveis")
    public Sistema saveSistema(@RequestBody Sistema sistema) {
        return repo.save( sistema );
    }

}