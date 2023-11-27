package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.usuarioService;

import com.example.veterinariaf.entity.usuario;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@Controller
public class controler_usuario {

    usuarioService userServicio;

    public controler_usuario(usuarioService userServicio) {
        this.userServicio = userServicio;
    }

    @GetMapping("/user")
    public usuario usuario(@AuthenticationPrincipal OidcUser principal) {
        System.out.println(principal.getClaims());
        String email = (String) principal.getClaims().get("email");
        usuario user = this.userServicio.buscarEmail(email);
        return user;

    }



  /*  @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        // Realiza la revocación del token de acceso en Auth0
        // ...

        // Invalida la sesión y redirige a la página de inicio o donde quieras
        request.getSession().invalidate();
        return "redirect:/index";
    }*/
}