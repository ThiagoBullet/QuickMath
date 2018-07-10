/**
 * @author profGenildo
 */
package banco;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import quick.math.R;

public class bdMatematica extends bdSQLITE
{ //nome do banco de dados e versão
  public static final String BD = "bdMatematica";
  public static final int versaoBD = 1;
 
  public bdMatematica(Context ActivityCorrente)
  { super(ActivityCorrente, BD, versaoBD);
  }
 
  private void criaTabelas(SQLiteDatabase bd)
  { try
    {//cria o banco de dados atravez do arquivo create.
      lerScriptSQL(R.raw.script_bd, bd);
    }catch (Exception e)
    {//Código para tratar o erro de sua escolha ou necessidade :)
    }
  }
  
  public void onCreate(SQLiteDatabase bd)
  { criaTabelas(bd);
  }
   
  public void onUpgrade(SQLiteDatabase bd, int versaoAtual, int versaoNova)
  {//Realiza tratamento de upgrade do banco de dados
   //Use quando tiver alteração de estrutura do BD. Por exemplo, em tabelas.
   //Aqui você deve fazer o tratamento do update do banco.
   //no caso estou apagando minha tabela e criando novamente.
    try
    {//Por exemplo, no pior caso, poderia ser assim: 
      bd.execSQL("drop table usuarios;");
      criaTabelas(bd);
    } catch (Exception e)
    { //Código para tratar o erro de sua escolha ou necessidade :)
    }        
  }
  
}
