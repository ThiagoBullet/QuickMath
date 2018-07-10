package quick.math;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import android.media.MediaPlayer;
import android.widget.AbsoluteLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import banco.bdAdmin;
import quick.math.calculos.Operacao;
import quick.math.calculos.util.Nivel;
import quick.math.calculos.util.Util;

public class Principal extends Activity {

    VideoView video;
    MediaPlayer tocador;

    private bdAdmin banco;
    private final Util util;

    boolean tocar;

//    public final int QUANTIDADE_OPERACOES = 3;
    public int operacoesRealizadas;
    public int operacoesCertas;

    private Operacao operacao;

    public Principal() {
        this.util = new Util();
        this.operacao = new Operacao(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        tocar = true;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void tocar_video(View ver) {
        if (tocar) {
            this.tocarVideo();
        } else {
            this.pararVideo();
        }
    }

    private void tocarVideo() {
        tocar = false;

        video = (VideoView) findViewById(R.id.video_ajuda);
        MediaController controle = new MediaController(this);
        controle.setAnchorView(video);
        video.setMediaController(controle);
        video.requestFocus();
        Uri localVideo = Uri.parse("android.resource://"
                + this.getPackageName() + "/" + R.raw.video);

        video.setVideoURI(localVideo);
        video.setKeepScreenOn(true);
        video.start();
    }

    private void pararVideo() {
        tocar = true;

        video.stopPlayback();
    }

    public void comecar(View principal) {
        setContentView(R.layout.tela_inicial);
    }

    public void jogar(View principal) {
        setContentView(R.layout.tela_niveis);

        RadioGroup nivelGrupo = (RadioGroup) findViewById(R.id.niveis);
        RadioButton nivelSelecionado = (RadioButton) findViewById(nivelGrupo.getCheckedRadioButtonId());
        this.operacao.setNivel(new Nivel(nivelSelecionado.getId()).verificarNivel());

        nivelGrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup rg, int selecionado) {
                operacao.setNivel(new Nivel(selecionado).verificarNivel());
            }
        });

    }

    public void ajuda(View principal) {
        setContentView(R.layout.tela_ajuda);
    }

    public void creditos(View principal) {
        setContentView(R.layout.tela_creditos);
    }

    public void soma(View principal) {
        abrirTela(R.layout.tela_exercicios, R.id.widget0, R.drawable.fundo02);
        this.operacao.montarOperacao(R.id.widget49,
                R.id.widget51,
                R.id.widget51_copy,
                '+');

    }

    public void somacerto(View principal) {
        abrirTela(R.layout.tela_exercicios, R.id.widget0, R.drawable.fundo02);
        this.operacao.montarOperacao(R.id.widget49,
                R.id.widget51,
                R.id.widget51_copy,
                '+');

    }

    public void subtracao(View principal) {
        abrirTela(R.layout.tela_exercicios, R.id.widget0, R.drawable.fundo03);

        this.operacao.montarOperacao(R.id.widget49,
                R.id.widget51,
                R.id.widget51_copy,
                '-');
    }

    public void subtracaocerto(View principal) {
        abrirTela(R.layout.tela_exercicios, R.id.widget0, R.drawable.fundo03);

        this.operacao.montarOperacao(R.id.widget49,
                R.id.widget51,
                R.id.widget51_copy,
                '-');
    }

    public void multiplicacao(View principal) {
        abrirTela(R.layout.tela_exercicios, R.id.widget0, R.drawable.fundo04);

        this.operacao.montarOperacao(R.id.widget49,
                R.id.widget51,
                R.id.widget51_copy,
                'x');
    }

    public void multiplicacaocerto(View principal) {
        abrirTela(R.layout.tela_exercicios, R.id.widget0, R.drawable.fundo04);

        this.operacao.montarOperacao(R.id.widget49,
                R.id.widget51,
                R.id.widget51_copy,
                'x');
    }

    public void divisao(View Principal) {
        abrirTela(R.layout.tela_exercicios, R.id.widget0, R.drawable.fundo05);

        this.operacao.montarOperacao(R.id.widget49,
                R.id.widget51,
                R.id.widget51_copy,
                '÷');
    }

    public void divisaocerto(View principal) {
        abrirTela(R.layout.tela_exercicios, R.id.widget0, R.drawable.fundo05);

        this.operacao.montarOperacao(R.id.widget49,
                R.id.widget51,
                R.id.widget51_copy,
                '÷');
    }

    public void voltar(View principal) {
        setContentView(R.layout.tela_inicial);
    }

    public void confirmar(View principal) {
        setContentView(R.layout.tela_errou);
    }

    public void tenteNovamente(View principal) {
        setContentView(R.layout.tela_operacoes);
        zerar();
    }

    public void errado(View principal) {
        setContentView(R.layout.tela_errou);
    }

    public void jogar_novamente(View principal) {
        setContentView(R.layout.tela_operacoes);
        zerar();
    }

    private void zerar() {
        operacoesRealizadas = 0;
        operacoesCertas = 0;
    }

    public void sair(View principal) {
        finish();
    }

    public void exit(View principal) {
        abrirTela(R.layout.tela_errou, R.id.widget0, R.drawable.fundoerrou);
        TextView quantidadeRealizadas = (TextView) findViewById(R.id.widgete2);
        quantidadeRealizadas.setText(operacoesRealizadas + "");
        TextView quantidadeCertas = (TextView) findViewById(R.id.widgete1);
        quantidadeCertas.setText(operacoesCertas + "");
    }

    public void confirma() {
        if (operacoesCertas > (this.operacao.getQuantidadeOperacoes()[this.operacao.getNivel()] / 2)) {
            abrirTela(R.layout.tela_acertou, R.id.widget0, R.drawable.fundoacertou);
            TextView quantidadeRealizadas = (TextView) findViewById(R.id.widgeta2);
            quantidadeRealizadas.setText(operacoesRealizadas + "");
            TextView quantidadeCertas = (TextView) findViewById(R.id.widgeta1);
            quantidadeCertas.setText(operacoesCertas + "");
            tocador = MediaPlayer.create(this, R.raw.somacertou);
            tocador.start();
        } else {
            abrirTela(R.layout.tela_errou, R.id.widget0, R.drawable.fundomelhorar);
            TextView quantidadeRealizadas = (TextView) findViewById(R.id.widgete2);
            quantidadeRealizadas.setText(operacoesRealizadas + "");
            TextView quantidadeCertas = (TextView) findViewById(R.id.widgete1);
            quantidadeCertas.setText(operacoesCertas + "");
            tocador = MediaPlayer.create(this, R.raw.somerrou);
            tocador.start();
        }
    }

    private void abrirTela(int tela, int idLayout, int idFundo) {
        setContentView(tela);
        AbsoluteLayout layout = (AbsoluteLayout) findViewById(idLayout);
        layout.setBackgroundResource(idFundo);
    }

}
