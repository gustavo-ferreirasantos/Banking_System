package br.com.hospital.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue("Procedimento")
public class Procedimento extends Agendamento {

    public Procedimento() {
        super();
    }

    public Procedimento(Date data, Paciente paciente, Medico medico, StatusAgendamento status) {
        super(data, paciente, medico, status);
    }
}
