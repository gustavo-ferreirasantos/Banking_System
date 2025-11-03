package br.com.hospital.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue("Consulta")
public class Consulta extends Agendamento {

    public Consulta() {
        super();
    }

    public Consulta(Date data, Paciente paciente, Medico medico, StatusAgendamento status) {
        super(data, paciente, medico, status);
    }
}