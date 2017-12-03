package br.com.milgrau.midiacenter.repository;


import br.com.milgrau.midiacenter.model.Conteudo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConteudoRepository extends CrudRepository<Conteudo,Long> {

    List<Conteudo> findById(int id);
}
