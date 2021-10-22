package com.example.mutantesapirest.matriz;

import org.junit.jupiter.api.*;

public class MutantDetectorTest {
    MutantDetector mutantDetector;
    HintSearch hintSearch = new HintSearch();
    @BeforeAll
    public static void beforeAll(){
        System.out.println();
        System.out.println("Comienzan los tests de MutantDetector");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println();
        System.out.println("Finalizan los tests de MutantDetector");
        System.out.println();
    }
    @Test
    public void detectarMutante(){
        char[][] matriz = {
                {'G','G','G','G'},
                {'T','C','G','A'},
                {'A','G','A','G'},
                {'G','C','A','G'}
        };
        MutantDetector mutantDetector = new MutantDetector(hintSearch);
        boolean resultado = mutantDetector.isMutant(matriz);
        Assertions.assertTrue(resultado);
    }

}
