package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.usuarioService;

import com.example.veterinariaf.entity.usuario;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class controler_inicio {

    usuarioService userServicio;

    public controler_inicio(usuarioService userServicio) {
        this.userServicio = userServicio;
    }

    @GetMapping("/") //Ruta Raiz
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) {

        if (principal != null) {
            System.out.println(principal.getClaims());
            //Usuario user = this.userServicio.getCrearUsuario(principal.getClaims().get("email")); //trae el correo de auth0
            usuario user = this.userServicio.getCrearUsuario(principal.getClaims());
            model.addAttribute("user",user);
            if(user.getRol().equals("administrador")){ //Consultar que rol es y redirige a la interfaz de ese usuario
                return "redirect:/inicio.html";
            }else{
                return "redirect:/entrada.html";
            }
        }
        else{
            return "index";
        }
        //System.out.println(principal.getClaims());//Trae informacion del usuario de inicio de sesio

    }
}