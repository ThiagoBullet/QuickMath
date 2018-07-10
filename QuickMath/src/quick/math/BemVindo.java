/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quick.math;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

/**
 *
 * @author Aluno
 */
public class BemVindo extends Activity implements Runnable {
    MediaPlayer tocador;
    @Override
    
    public void onCreate(Bundle savedInstanceState)
    { super.onCreate(savedInstanceState);
      setContentView(R.layout.tela_bemvindo);
        
      Handler tempo = new Handler();
      tempo.postDelayed(this, 2000);
      
      tocador = MediaPlayer.create(this, R.raw.som);
      tocador.start();
    }          
 
    public void run() {
        startActivity(new Intent(this, Principal.class));
        this.finish();
    }  
}
