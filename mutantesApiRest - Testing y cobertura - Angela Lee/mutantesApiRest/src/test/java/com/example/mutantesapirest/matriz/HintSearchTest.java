package com.example.mutantesapirest.matriz;

import org.junit.jupiter.api.*;

public class HintSearchTest {
    HintSearch hintSearch;
    @BeforeAll
    public static void beforeAll(){
        System.out.println();
        System.out.println("Comienzan los tests de HintSearch");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println();
        System.out.println("Finalizan los tests de HintSearch");
        System.out.println();
    }
    @BeforeEach
    public void beforeEach() {
        hintSearch = new HintSearch();
    }

    @Test
    public void analizarMatrizHorizontalPar (){
        char[][] matriz = {
                {'A','G','A','G','C','G'},
                {'A','G','T','A','G','A'},
                {'G','C','T','T','T','T'},
                {'A','G','A','G','G','A'},
                {'C','T','T','T','T','C'},
                {'A','G','T','G','G','C'}
        };
        hintSearch.busqHoriz(matriz);
        Assertions.assertEquals(2,hintSearch.getContador());
        System.out.println();
        System.out.println("Test: Matriz Horizontal Par realizado con éxito");
    }

    @Test
    public void analizarMatrizHorizontalImpar (){
        char[][] matriz = {
                {'A','G','A','G','C','G','A'},
                {'A','G','T','A','G','A','G'},
                {'C','T','T','T','T','C','A'},
                {'A','G','A','G','G','A','G'},
                {'G','C','G','T','T','T','T'},
                {'A','G','T','G','G','C','C'},
                {'A','G','T','G','G','C','C'}
        };
        hintSearch.busqHoriz(matriz);
        Assertions.assertEquals(2,hintSearch.getContador());
        System.out.println();
        System.out.println("Test: Matriz Horizontal Impar realizado con éxito");
    }

    @Test
    public void analizarMatrizVertical (){
        char[][] matriz = {
                {'A','G','A','G','C','G'},
                {'C','G','T','A','A','A'},
                {'A','C','T','T','G','C'},
                {'A','G','G','G','G','C'},
                {'C','T','T','T','G','C'},
                {'A','G','A','G','G','C'}
        };
        hintSearch.busqVertical(matriz);
        Assertions.assertEquals(2,hintSearch.getContador());
        System.out.println();
        System.out.println("Test: Matriz Vertical realizado con éxito");
    }

    @Test
    public void analizarMatrizDiagonal (){
        char[][] matriz = {
                {'A','G','A','G','C','G'},
                {'A','G','T','A','G','A'},
                {'A','C','A','G','G','T'},
                {'A','G','A','G','T','A'},
                {'C','T','T','C','G','G'},
                {'A','G','A','G','A','G'}
        };
        hintSearch.busqDiagonal(matriz);
        Assertions.assertEquals(0,hintSearch.getContador());
        System.out.println();
        System.out.println("Test: Matriz Diagonal realizado con éxito");
    }

    @Test
    public void analizarMatrizDiagonalInv (){
        char[][] matriz = {
                {'A','G','A','G','C','G'},
                {'A','G','T','A','A','A'},
                {'A','G','C','G','G','T'},
                {'T','A','A','A','A','A'},
                {'C','T','G','T','G','G'},
                {'A','A','A','G','A','G'}
        };
        hintSearch.busqDiagonalInv(matriz);
        Assertions.assertEquals(0,hintSearch.getContador());
        System.out.println();
        System.out.println("Test: Matriz Diagonal Inversa realizado con éxito");
    }

}
