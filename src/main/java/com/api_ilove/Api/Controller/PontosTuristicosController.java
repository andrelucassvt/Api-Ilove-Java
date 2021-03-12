package com.api_ilove.Api.Controller;

import com.api_ilove.Domain.Model.PontosTuristicosModel;
import com.api_ilove.Domain.Repository.PontosTuristicosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pontosturisticos")
public class PontosTuristicosController {

    @Autowired
    private PontosTuristicosRepo pontosTuristicosRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PontosTuristicosModel criar(@Valid @RequestBody PontosTuristicosModel pontosTuristicosModel){
        return pontosTuristicosRepo.save(pontosTuristicosModel);
    }
}
