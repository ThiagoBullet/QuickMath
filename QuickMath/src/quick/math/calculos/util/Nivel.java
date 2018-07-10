/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quick.math.calculos.util;

import quick.math.R;

/**
 *
 * @author aluno
 */
public class Nivel {

    private int selecionado;

    public Nivel(int selecionado) {
        this.selecionado = selecionado;
    }

    public int verificarNivel() {
        switch (selecionado) {
            case R.id.nivel_facil:
                return 0;
            case R.id.nivel_medio:
                return 1;
            case R.id.nivel_dificil:
                return 2;
        }
        return 0;
    }
}
