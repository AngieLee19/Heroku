package com.example.mutantesapirest.controllers;

import com.example.mutantesapirest.services.MutantService;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*") //permitir el acceso a la api desde distintos clientes
@RequestMapping(path = "api/mutants/") //la uri que necesitamos para acceder a los recursos, personas es el recurso en este caso
public class MutantControllerImpl implements MutantController {

    @Autowired
    protected MutantService servicio;

    @PostMapping("/post")
    public ResponseEntity<?> detect(@RequestBody String[] dna){
        try{
            if(servicio.isMutant(dna)){
                return ResponseEntity.status(HttpStatus.OK).body("{\"mutant\":\"Mutante encontrado.\"}");
            }else{
                throw new Exception();
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"mutant\":\"Mutante no encontrado.\"}"); //msj de error en JSON
        }
    }
}

