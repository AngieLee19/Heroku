package com.example.mutantesapirest.services;

import com.example.mutantesapirest.MutantesApiRestApplication;
import com.example.mutantesapirest.matriz.HintSearch;
import com.example.mutantesapirest.matriz.MatrixCreator;
import com.example.mutantesapirest.matriz.MutantDetector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;



@SpringBootTest(classes = MutantesApiRestApplication.class)
public class MutantServiceImplTest {
    @MockBean
    public MatrixCreator matrixCreator;
    @MockBean
    public MutantDetector mutantDetector;
    //@Autowired
    private MutantServiceImpl mutantService = new MutantServiceImpl();

    @Test
    public void ImplementarServicioMutante() throws Exception {
            String[] cadenaMatriz = {"GGGG", "TCGA", "AGAA", "GCAG"};
            char[][] matriz = {
                    {'G', 'G', 'G', 'G'},
                    {'T', 'C', 'G', 'A'},
                    {'A', 'G', 'A', 'A'},
                    {'G', 'C', 'A', 'G'}
            };
            when(matrixCreator.hacerMatriz(cadenaMatriz)).thenReturn(matriz);
            when(mutantDetector.isMutant(matriz)).thenReturn(true);
            Assertions.assertTrue(mutantService.isMutant(cadenaMatriz));
    }

    @Test
    public void NoImplementarServicioMutante() throws Exception {
        String[] cadenaMatriz = {"GGAG", "TCGA", "AGAA", "GCAG"};
        char[][] matriz = {
                {'G', 'G', 'A', 'G'},
                {'T', 'C', 'G', 'A'},
                {'A', 'G', 'A', 'A'},
                {'G', 'C', 'A', 'G'}
        };
        try{
            Exception ex = assertThrows(Exception.class, ()->{
                mutantService.isMutant(cadenaMatriz);
            });
            when(matrixCreator.hacerMatriz(cadenaMatriz)).thenReturn(matriz);
            when(mutantDetector.isMutant(matriz)).thenReturn(false);
            Assertions.assertEquals("No es mutante",ex.getMessage());
        } catch (Exception e){
            e.getMessage();
        }

    }
}
