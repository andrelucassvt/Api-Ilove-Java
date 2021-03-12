package com.api_ilove.Domain.Service;

import com.api_ilove.Domain.Model.MunicipioModel;
import com.api_ilove.Domain.Repository.MunicipioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class MunicipiosService {

    @Autowired
    private MunicipioRepo municipioRepo;

    public List<MunicipioModel> ListarMunicipios(){
        return municipioRepo.findAll();
    }

    public ResponseEntity<MunicipioModel> buscarId(@PathVariable Long id){
        Optional<MunicipioModel> municipioModelOptional = municipioRepo.findById(id);

        if(municipioModelOptional.isPresent()){
            return ResponseEntity.ok(municipioModelOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public MunicipioModel adicionarMunicipio(MunicipioModel municipioModel){
        return municipioRepo.save(municipioModel);
    }

    public ResponseEntity<MunicipioModel> atualizar(Long id, MunicipioModel municipioModel){
        if (!municipioRepo.existsById(id)){
            return ResponseEntity.notFound().build();
        }else{
            municipioModel.setId(id);
            municipioModel = municipioRepo.save(municipioModel);

            return ResponseEntity.ok(municipioModel);
        }
    }

    public ResponseEntity<Void> deletar(Long id){
        if (!municipioRepo.existsById(id)){
            return ResponseEntity.notFound().build();
        }else {
            municipioRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }
}
