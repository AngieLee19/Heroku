package com.example.mutantesapirest.services;

import com.example.mutantesapirest.matriz.HintSearch;
import com.example.mutantesapirest.matriz.MatrixCreator;
import com.example.mutantesapirest.matriz.MutantDetector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MutantServiceImpl implements MutantService{

    public MatrixCreator matrixCreator = new MatrixCreator();
    public HintSearch mutantSearch = new HintSearch();
    public MutantDetector mutantDetector = new MutantDetector(mutantSearch);

    @Override
    //@Transactional
    public boolean isMutant(String[] dna) throws Exception {
        try{
            char[][] dnaMatriz = matrixCreator.hacerMatriz(dna);
            if(mutantDetector.isMutant(dnaMatriz)){
                return true;
            } else {
                throw new Exception("No es mutante");
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

