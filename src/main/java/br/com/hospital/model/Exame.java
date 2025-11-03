package br.com.hospital.model;

import br.com.hospital.model.Agendamento;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue("Exame")
public class Exame extends Agendamento {

    public Exame() {
        super();
    }

    public Exame(Date data, Paciente paciente, Medico medico, StatusAgendamento status) {
        super(data, paciente, medico, status);
    }
}
