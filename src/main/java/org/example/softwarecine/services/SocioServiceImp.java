package org.example.softwarecine.services;

import org.example.softwarecine.models.Socio;
import org.example.softwarecine.repositories.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocioServiceImp implements SocioService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    SocioRepository socioRepository;

    @Override
    public List<Socio> findAll() {
        return socioRepository.findAll();
    }

    @Override
    public Socio save(Socio socio) {
        String rawPassword = socio.getContrasenia();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        socio.setContrasenia(encodedPassword);
        return socioRepository.save(socio);
    }

    @Override
    public Optional<Socio> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Socio> update(Socio socio, Integer id) {
        return Optional.empty();
    }
}
