package com.eehsantos.manager_api.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.eehsantos.manager_api.application.service.UserService;
import com.eehsantos.manager_api.domain.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Tag(name = "User", description = "Operações relacionadas a usuários")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Criar usuário", description = "Cria um novo usuário no sistema")
    public User create(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuário por ID", description = "Retorna um usuário específico pelo seu ID")
    public Optional<User> getById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping
    @Operation(summary = "Buscar todos usuário", description = "Retorna todos usuário")
    public List<User> list() {
        return service.listUsers();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir usuário por ID", description = "Exclui um usuário especifico pelo seu ID")
    public void delete(@PathVariable Long id) {
        service.deleteUser(id);
    }
}
