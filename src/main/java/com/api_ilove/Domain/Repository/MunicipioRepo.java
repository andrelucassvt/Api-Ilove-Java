package com.api_ilove.Domain.Repository;

import com.api_ilove.Domain.Model.MunicipioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepo extends JpaRepository<MunicipioModel,Long> {
}
