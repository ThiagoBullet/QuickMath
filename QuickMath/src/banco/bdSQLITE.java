/**
 * @author Aluno
 */
package banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public abstract class bdSQLITE extends SQLiteOpenHelper
{ protected Context ActivityCorrente;
 
  public bdSQLITE(Context activity, String nome, int versao)
  { super(activity, nome, null, versao);
    this.ActivityCorrente = activity;
  }
 
  public abstract void onCreate(SQLiteDatabase bd);
 
  public abstract void onUpgrade(SQLiteDatabase bd, int versaoAtual, int versaoNova);
     
  protected void lerScriptSQL(int scriptSQL, SQLiteDatabase bd) throws IOException
  { StringBuilder sql = new StringBuilder();
    BufferedReader comandos_SQL = new BufferedReader(new InputStreamReader(ActivityCorrente.getResources().openRawResource(scriptSQL)));
    
    String linhaComando;
    while((linhaComando = comandos_SQL.readLine()) != null )
    { linhaComando = linhaComando.trim();
      if ( linhaComando.length() > 0 )
      { sql.append(linhaComando);
        if ( linhaComando.endsWith(";") )
        { bd.execSQL(sql.toString());
          sql.delete(0, sql.length());
        }
      }
    }
  }
}

