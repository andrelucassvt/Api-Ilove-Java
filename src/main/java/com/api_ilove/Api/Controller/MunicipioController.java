package com.api_ilove.Api.Controller;


import com.api_ilove.Domain.Model.MunicipioModel;
import com.api_ilove.Domain.Repository.MunicipioRepo;
import com.api_ilove.Domain.Service.MunicipiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/municipio")
public class MunicipioController {

    @Autowired
    private MunicipiosService municipiosService;

    @GetMapping
    public List<MunicipioModel> ListarMunicipios(){
        return municipiosService.ListarMunicipios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MunicipioModel> buscarId(@PathVariable Long id){
        return municipiosService.buscarId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MunicipioModel adicionarMunicipio(@Valid @RequestBody MunicipioModel municipioModel){
        return municipiosService.adicionarMunicipio(municipioModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MunicipioModel> atualizar(@Valid @PathVariable Long id,
                                                    @RequestBody MunicipioModel municipioModel){
        return municipiosService.atualizar(id,municipioModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        return municipiosService.deletar(id);
    }


}
