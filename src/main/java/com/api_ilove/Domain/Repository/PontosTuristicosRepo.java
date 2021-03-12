package com.api_ilove.Domain.Repository;

import com.api_ilove.Domain.Model.PontosTuristicosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontosTuristicosRepo extends JpaRepository<PontosTuristicosModel,Long> {
}
