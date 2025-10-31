package br.com.hospital.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Agendamento {

    private Date data;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento status; // AGENDADO, REALIZADO, CANCELADO

    public void cancelar() {
        this.status = StatusAgendamento.CANCELADO;
    }

    public void confirmar() {
        this.status = StatusAgendamento.AGENDADO;
    }

    public void concluir() {
        this.status = StatusAgendamento.REALIZADO;
    }

    public abstract String getDescricao(); // cada tipo de agendamento fornece sua descrição



    public enum StatusAgendamento {
        AGENDADO,
        REALIZADO,
        CANCELADO
    }

}