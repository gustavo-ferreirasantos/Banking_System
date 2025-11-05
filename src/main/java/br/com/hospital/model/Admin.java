package br.com.hospital.model;

import br.com.hospital.repository.MedicoRepository;
import br.com.hospital.repository.PacienteRepository;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Admin extends User {
    private String cargo;
    private String nivelAcesso;

    public Admin(String name, String email, String password, String cargo, String nivelAcesso) {
        super(name, email, password);
        this.cargo = cargo;
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public boolean autenticar(String email, String senha, PacienteRepository repository) {
        return false;
    }


    public void adicionarPaciente(PacienteRepository pacienteRepository) {

    }

    public void adicionarMedico(MedicoRepository medicoRepository) {

    }

    public void modficarSenha(String senha, MedicoRepository medicoRepository) {

    }

}

























