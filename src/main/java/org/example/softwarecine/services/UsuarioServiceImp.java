package org.example.softwarecine.services;

import org.example.softwarecine.models.Usuario;
import org.example.softwarecine.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService{

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) {
        String passwordRaw = usuario.getContrasenia();
        String encodedPassword = passwordEncoder.encode(passwordRaw);
        usuario.setContrasenia(encodedPassword);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<Usuario> update(Usuario usuario, Integer id) {
        Optional<Usuario> usuarioOp = this.findById(id);
        Usuario usuarioOptional = null;

        if(usuarioOp.isPresent()){
            Usuario usuarioBD = usuarioOp.orElseThrow();
            usuarioBD.setNombre(usuario.getNombre());
            usuarioBD.setApellido(usuario.getApellido());
            usuarioBD.setEmail(usuario.getEmail());
            usuarioBD.setNumDocumento(usuario.getNumDocumento());
            usuarioBD.setRol(usuario.getRol());
            usuarioOptional = save(usuarioBD);
        }
        return Optional.ofNullable(usuarioOptional);
    }
}
