package br.com.hospital.interfaces;

import br.com.hospital.repository.PacienteRepository;

public interface Autenticavel {
    //Colocar "public" é redundante para interfaces
    boolean autenticar(String email, String senha, PacienteRepository repository);
}
