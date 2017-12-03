package br.com.milgrau.midiacenter.controller;

import br.com.milgrau.midiacenter.model.Conteudo;
import br.com.milgrau.midiacenter.repository.ConteudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConteudoController {

    @Autowired
    ConteudoRepository conteudoRepository;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model){

        Iterable<Conteudo> conteudos  = conteudoRepository.findAll();
        model.addAttribute("conteudos", conteudos);
        return "index";
    }
}
