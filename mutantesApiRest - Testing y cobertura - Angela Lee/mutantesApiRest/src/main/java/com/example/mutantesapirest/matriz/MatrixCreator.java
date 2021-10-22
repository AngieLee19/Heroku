package com.example.mutantesapirest.matriz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@AllArgsConstructor
@Setter
@Getter
public class MatrixCreator {

    public char[][]hacerMatriz(String[] dna){
        //convierte el array de strings en una matriz de caracteres
        int n = dna.length;
        char[][] dnaMatriz = new char[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dnaMatriz[i][j] = dna[i].charAt(j % n);
            }
        }
        return dnaMatriz;
    }
}

