package com.api_ilove.Domain.Service;

import com.api_ilove.Domain.Model.MunicipioModel;
import com.api_ilove.Domain.Model.PontosTuristicosModel;
import com.api_ilove.Domain.Repository.MunicipioRepo;
import com.api_ilove.Domain.Repository.PontosTuristicosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class PontosTuristicosService {

    @Autowired
    private PontosTuristicosRepo pontosTuristicosRepo;

    @Autowired
    private MunicipioRepo municipioRepo;

    public List<PontosTuristicosModel> ListarPontosTuristicos(){
        return pontosTuristicosRepo.findAll();
    }

    public ResponseEntity<PontosTuristicosModel> buscarId(Long id){
        Optional<PontosTuristicosModel> pontosTuristicosModelOptional = pontosTuristicosRepo.findById(id);

        if(pontosTuristicosModelOptional.isPresent()){
            return ResponseEntity.ok(pontosTuristicosModelOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public PontosTuristicosModel criar(PontosTuristicosModel pontosTuristicosModel){
        MunicipioModel municipioModel =
                municipioRepo.findById(pontosTuristicosModel.getMunicipioModel().getId())
                .orElseThrow();
        pontosTuristicosModel.setMunicipioModel(municipioModel);
        return pontosTuristicosRepo.save(pontosTuristicosModel);
    }

    public ResponseEntity<PontosTuristicosModel> atualizar(Long id, PontosTuristicosModel pontosTuristicosModel){
        if (!pontosTuristicosRepo.existsById(id)){
            return ResponseEntity.notFound().build();
        }else{
            pontosTuristicosModel.setId(id);
            pontosTuristicosModel = pontosTuristicosRepo.save(pontosTuristicosModel);
            return ResponseEntity.ok(pontosTuristicosModel);
        }
    }

    public ResponseEntity<Void> deletar(Long id){
        if (!pontosTuristicosRepo.existsById(id)){
            return ResponseEntity.notFound().build();
        }else {
            pontosTuristicosRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }
}