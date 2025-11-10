package br.com.hospital.model;

import br.com.hospital.repository.PacienteRepository;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Medico extends User{

    private String crm;
    private Especialidade especialidade;

    public enum Especialidade{
        CLINICO_GERAL,
        CARDIOLOGISTA,
        PEDIATRA,
        GINECOLOGISTA,
        ORTOPEDISTA,
        DERMATOLOGISTA,
    }





    @Override
    public boolean autenticar(String email, String senha, PacienteRepository repository) {
        return false;
    }


}
