package br.com.milgrau.midiacenter.controller;

import br.com.milgrau.midiacenter.model.Conteudo;
import br.com.milgrau.midiacenter.model.Usuario;
import br.com.milgrau.midiacenter.repository.ConteudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.annotation.MultipartConfig;
import javax.validation.Valid;
import java.io.*;

@Controller
public class PublicarController {

    @Autowired
    ConteudoRepository conteudoRepository;

    @GetMapping("/publicar")
    public String index(Model model){

        model.addAttribute("conteudo", new Conteudo());
        return "publicar";
    }

    @PostMapping("/publicar")
    public String index(@RequestParam("file")MultipartFile file,Conteudo conteudo){

        String diretorioInserir = "";
        String diretorioBuscar = "";
        try {

            diretorioInserir = "/home/igorsantos/Documentos/midiacenter/target/classes/static/imagens/" + file.getOriginalFilename();
            diretorioBuscar = "/imagens/" + file.getOriginalFilename();
            file.transferTo(new File (diretorioInserir));
        }catch (Exception e){

            e.printStackTrace();
        }

        Usuario usuario = new Usuario();
        usuario.setId(1);
        conteudo.setIdUsuario(usuario);
        conteudo.setDiretorioInserir(diretorioInserir);
        conteudo.setDiretorioBuscar(diretorioBuscar);
        if(isVideo(file.getOriginalFilename()))

            conteudo.setTipoArquivo("video");
        else{

            conteudo.setTipoArquivo("foto");
        }
        conteudoRepository.save(conteudo);
        return "publicar";
    }

    public boolean isVideo(String arquivo){

        arquivo = arquivo.substring(arquivo.lastIndexOf("."),arquivo.length());
        if(arquivo.equals(".mp4") || arquivo.equals("mp4"))
            return true;

        return false;
    }

}
