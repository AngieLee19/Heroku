package com.example.mutantesapirest.matriz;

import com.example.mutantesapirest.matriz.MatrixCreator;
import org.junit.jupiter.api.*;

public class MatrixCreatorTest {
    MatrixCreator matrixCreator;
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Comienzan los tests de MatrixCreator");
        System.out.println();
    }
    @AfterAll
    public static void afterAll(){
        System.out.println();
        System.out.println("Finalizan los tests de MatrixCreator");
    }
    @BeforeEach
    public void beforeEach(){
        matrixCreator = new MatrixCreator();
    }



    @Test
    public void hacerMatrizTest (){
        String[] cadena = {"AGT","TCG","ACA"};
        char[][] esperado = {
                {'A','G','T'},
                {'T','C','G'},
                {'A','C','A'}
        };
        char[][] resultado = new char [3][3];
        resultado = matrixCreator.hacerMatriz(cadena);

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                Assertions.assertTrue(esperado[i][j] == resultado[i][j]);
            }
        }

        System.out.println("Matriz resultado: ");
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
