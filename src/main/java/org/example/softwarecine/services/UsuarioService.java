package org.example.softwarecine.services;

import org.example.softwarecine.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> findAll();

    Usuario save(Usuario usuario);

    Optional<Usuario> findById(Integer id);

    Optional<Usuario> update(Usuario usuario, Integer id);
}
