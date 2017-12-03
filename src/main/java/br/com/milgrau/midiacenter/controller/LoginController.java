package br.com.milgrau.midiacenter.controller;

import br.com.milgrau.midiacenter.model.Usuario;
import br.com.milgrau.midiacenter.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String login(Model model){

        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(Usuario usuario){

        if(usuario.getEmail().equals("tv@saojudas.com.br") && usuario.getSenha().equals("12345")){

            Sessao.logado = "1";
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("redirect:/login");
    }
}
