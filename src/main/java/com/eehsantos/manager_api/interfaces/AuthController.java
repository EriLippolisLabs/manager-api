package com.eehsantos.manager_api.interfaces;
import com.eehsantos.manager_api.infrastructure.config.JwtService;
import com.eehsantos.manager_api.interfaces.dto.AuthRequest;
import com.eehsantos.manager_api.interfaces.dto.AuthResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "auth", description = "Auth para geração do JWT")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    @Operation(summary = "login", description = "Cria um nova tarefa no sistema")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        if ("admin".equals(request.username()) && "admin".equals(request.password())) {
            String token = jwtService.generateToken(request.username());
            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(401).build();
    }
}