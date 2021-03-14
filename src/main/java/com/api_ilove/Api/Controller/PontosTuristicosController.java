package com.api_ilove.Api.Controller;

import com.api_ilove.Domain.Model.PontosTuristicosModel;
import com.api_ilove.Domain.Repository.PontosTuristicosRepo;
import com.api_ilove.Domain.Service.PontosTuristicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pontosturisticos")
public class PontosTuristicosController {

    @Autowired
    private PontosTuristicosService pontosTuristicosService;

    @GetMapping
    public List<PontosTuristicosModel> ListarPontosTuristicos(){
        return pontosTuristicosService.ListarPontosTuristicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PontosTuristicosModel> buscarId(@PathVariable Long id){
        return pontosTuristicosService.buscarId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PontosTuristicosModel criar(@Valid @RequestBody PontosTuristicosModel pontosTuristicosModel){
        return pontosTuristicosService.criar(pontosTuristicosModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PontosTuristicosModel> atualizar(@Valid @PathVariable Long id,
                                                           @RequestBody PontosTuristicosModel pontosTuristicosModel){
        return pontosTuristicosService.atualizar(id,pontosTuristicosModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        return pontosTuristicosService.deletar(id);
    }
}