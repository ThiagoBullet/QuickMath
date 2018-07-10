/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quick.math.calculos.util;

import java.util.Random;

/**
 *
 * @author aluno
 */
public class Util {

    public int getNumeroMaximoPorNivel(int nivel) {
        switch (nivel) {
            case 0:
                return 20;
            case 1:
                return 30;
            case 2:
                return 40;
            default:
                return 20;

        }
    }

    public Integer gerarNumeroAleatorio(int nivel) {
        return 1 + (int) (Math.random() * getNumeroMaximoPorNivel(nivel));
    }

    public Integer gerarNumeroErrado(Integer numeroCorreto) {
        Integer numeroErrado = null;
        while (numeroErrado == null || numeroErrado.equals(numeroCorreto)) {
            numeroErrado = new Random().nextInt(20);
        }
        return numeroErrado;
    }
}
