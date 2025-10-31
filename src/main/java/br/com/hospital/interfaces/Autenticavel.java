package br.com.hospital.interfaces;

import br.com.hospital.repository.PacienteRepository;

public interface Autenticavel {
    public boolean autenticar(String email, String senha, PacienteRepository repository);
}
