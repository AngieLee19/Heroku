package com.example.mutantesapirest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface MutantController {
    public ResponseEntity<?> detect(@RequestBody String[] dna);
}
