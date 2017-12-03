package br.com.milgrau.midiacenter.repository;


import br.com.milgrau.midiacenter.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario,Long>{

    List<Usuario> findById(int id);
}
