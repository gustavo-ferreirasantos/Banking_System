package br.com.hospital.model;

import br.com.hospital.model.Medico;
import br.com.hospital.model.Paciente;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date data;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;

    public enum StatusAgendamento {
        AGENDADO, CANCELADO, CONCLUIDO
    }

    // 🔹 Construtor padrão
    public Agendamento() {}

    // 🔹 Construtor com todos os dados
    public Agendamento(Date data, Paciente paciente, Medico medico, StatusAgendamento status) {
        this.data = data;
        this.paciente = paciente;
        this.medico = medico;
        this.status = status;
    }

}
