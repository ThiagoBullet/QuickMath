/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import android.database.sqlite.SQLiteDatabase;

/**
 *
 * @author genildo.santos
 */

public class bdAdmin
{
    private bdSQLITE bd;
    private SQLiteDatabase sqld;
 
    public bdAdmin(bdSQLITE bancoManager)
    {
        this.bd = bancoManager;
    }
 
    public void abrirBD_modoEscrita()
    {
        sqld = bd.getWritableDatabase();
    }
 
    public void abrirBD_modoLeitura()
    {
        sqld = bd.getReadableDatabase();
    }
    
    public SQLiteDatabase get()
    {
        if ( sqld != null && sqld.isOpen() )
        {
            return sqld;
        }
        return null;
    }
 
    public void close()
    {
        bd.close();
    }
}
