/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quick.math.calculos;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import quick.math.Principal;
import quick.math.calculos.util.Primo;
import quick.math.calculos.util.Util;

/**
 *
 * @author aluno
 */
public class Operacao {

    private Principal principal;
    private Util util;

    private int[] quantidadeOperacoes = new int[]{5, 10, 15};
    private int nivel; //0 => FÁCIL, 1 => MÉDIO, 2 => DIFÍCIL

    public Operacao(Principal principal) {
        this.principal = principal;
        this.util = new Util();
    }

    public void montarOperacao(int textViewPergunta, int b1View, int b2View, Character operacao) {

        if (this.principal.operacoesRealizadas >= quantidadeOperacoes[nivel]) {
            this.principal.confirma();
        } else {

            this.principal.operacoesRealizadas++;

            TextView pergunta = (TextView) this.principal.findViewById(textViewPergunta);
            Button b1 = (Button) this.principal.findViewById(b1View);
            Button b2 = (Button) this.principal.findViewById(b2View);

            Integer n1 = util.gerarNumeroAleatorio(nivel);
            Integer n2 = util.gerarNumeroAleatorio(nivel);
            Integer resultadoCorreto = null;

            switch (operacao) {
                case '+':
                    resultadoCorreto = n1 + n2;
                    break;
                case '-':
                    n1 = n1 > n2 ? n1 : n2;
                    n2 = n1 > n2 ? n2 : n1;
                    resultadoCorreto = n1 - n2;
                    break;
                case 'x':
                    resultadoCorreto = n1 * n2;
                    break;
                case '÷':
                    n1 = n1 > n2 ? n1 : n2;
                    n2 = n1 > n2 ? n2 : n1;
                    while (n1 == 0 || n2 == 0 || n1 % n2 != 0 || new Primo(n1).verificarPrimo() || n1 == n2 || n2 == 1) {
                        n1 = util.gerarNumeroAleatorio(nivel);
                        n2 = util.gerarNumeroAleatorio(nivel);

                    }
                    resultadoCorreto = n1 / n2;
                    break;
            }

            pergunta.setText(n1 + " " + operacao + " " + n2);

            if (new Random().nextBoolean()) {
                b1.setText(resultadoCorreto + ""); //b1: resposta correta
                b2.setText((util.gerarNumeroErrado(resultadoCorreto)) + ""); //resposta errada
                // Adicionar um Listener 
                b1.setOnClickListener(criarAcaoNoBotao(operacao, true));
                b2.setOnClickListener(criarAcaoNoBotao(operacao, false));

            } else {
                b2.setText(resultadoCorreto + ""); // b2: resposta correta
                b1.setText((util.gerarNumeroErrado(resultadoCorreto)) + ""); //resposta errada
                // Adicionar um Listener 
                b2.setOnClickListener(criarAcaoNoBotao(operacao, true));
                b1.setOnClickListener(criarAcaoNoBotao(operacao, false));
            }
        }

    }

    private View.OnClickListener criarAcaoNoBotao(final char operacao, final boolean certo) {
        View.OnClickListener acao = null;

        acao = new View.OnClickListener() {
            public void onClick(View v) {
                if (certo) {
                    principal.operacoesCertas++;
                    switch (operacao) {
                        case '+':
                            principal.somacerto(v);
                            break;
                        case '-':
                            principal.subtracaocerto(v);
                            break;
                        case 'x':
                            principal.multiplicacaocerto(v);
                            break;
                        case '÷':
                            principal.divisaocerto(v);
                            break;
                    }
                } else {
                    switch (operacao) {
                        case '+':
                            principal.somacerto(v);
                            break;
                        case '-':
                            principal.subtracaocerto(v);
                            break;
                        case 'x':
                            principal.multiplicacaocerto(v);
                            break;
                        case '÷':
                            principal.divisaocerto(v);
                            break;
                    }
                }
            }
        };

        return acao;
    }

    public int[] getQuantidadeOperacoes() {
        return quantidadeOperacoes;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

}
