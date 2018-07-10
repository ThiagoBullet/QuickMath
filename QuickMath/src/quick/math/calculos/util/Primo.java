/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quick.math.calculos.util;

/**
 *
 * @author aluno
 */
public class Primo {

    private int numero;

    public Primo(int numero) {
        this.numero = numero;
    }

    public boolean verificarPrimo() {
        int contador = 0;

        if (numero != 0) {
            for (int i = 1; i <= numero; i++) {
                if (numero % i == 0) {
                    contador++;
                }
            }
        }

        return contador == 1 || contador == 2;
    }
}
