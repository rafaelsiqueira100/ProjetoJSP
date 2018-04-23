
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author u16191
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class BD 
{
    private Connection conn;
    private Statement  cmd;

    public BD (String drv, String strCon, String usr, String senha) throws Exception
    {
        try
        {
            Class.forName (drv);
        }
        catch (ClassNotFoundException e)
        {
            throw new Exception ("driver");
        }

        try
        {
            conn = DriverManager.getConnection (strCon, usr, senha);
        }
        catch (SQLException e)
        {
            throw new Exception ("conexao");
        }

        try
        {
            cmd = conn.createStatement
                     (ResultSet.TYPE_SCROLL_INSENSITIVE,
                      ResultSet.CONCUR_READ_ONLY);
        }
        catch (SQLException e)
        {
            throw new Exception ("comando");
        }
    }

    public void execComando (String cmdSQL) throws Exception
    {
        try
        {
            this.cmd.executeUpdate (cmdSQL);
        }
        catch (SQLException e)
        {
            throw new Exception ("execucao comando");
        }
    }

    public ResultSet execConsulta (String qrySQL) throws Exception
    {
        ResultSet resultado = null;

        try
        {
            resultado = this.cmd.executeQuery (qrySQL);
        }
        catch (SQLException e)
        {
            throw new Exception ("execucao consulta da execConsulta");
        }

        return resultado;
    }

     
    public void fecharConexao () throws Exception
    {
        try
        {
            this.cmd.close ();
            this.cmd = null;

            this.conn.close ();
            this.conn = null;
        }
        catch (SQLException e)
        {
            throw new Exception ("fechamento");
        }
    }
}
