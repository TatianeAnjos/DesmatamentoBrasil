package com.tatiane.DesmatamentoBrasil.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tatiane.DesmatamentoBrasil.entities.DadosDesmatamento;

@Repository
public interface DadosDesmatamentoRepository extends JpaRepository<DadosDesmatamento, Long> {


}
