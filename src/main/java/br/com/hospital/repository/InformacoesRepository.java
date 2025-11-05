package br.com.hospital.repository;

import br.com.hospital.model.Informacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InformacoesRepository extends JpaRepository<Informacoes, Long> {

    Optional<Informacoes> findByNome(String nome);
    @Query("SELECT DISTINCT i.tipoAgendamento FROM Informacoes i")
    List<String> findDistinctTipos();

    @Query("SELECT DISTINCT i.especialidadeRelacionada FROM Informacoes i WHERE i.tipoAgendamento = :tipo")
    List<String> findDistinctEspecialidadesByTipo(String tipo);

    List<Informacoes> findByEspecialidadeRelacionada(String especialidade);

}
