package br.com.hospital.model;

import br.com.hospital.repository.PacienteRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    private int cargaHoraria;
    private int horasTrabalhadas = 0;


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
