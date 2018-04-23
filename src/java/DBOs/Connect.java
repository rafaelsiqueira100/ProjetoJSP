/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author u16191
 */
import static java.lang.System.out;
import java.sql.Date;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Connect 
{
    private BD bd;
    
    public Connect () throws Exception
    {
        try
        {
            this.bd = new BD ("com.microsoft.sqlserver.jdbc.SQLServerDriver","jdbc:sqlserver://regulus:1433;databasename=JSP1RB16191","JSP1RB16191", "JSP1RB16191");
        }
        catch(Exception e)
        {
            throw new Exception ("conexao com SGBD");
        }
    }

    public void finalize () throws Exception
    {
        try
        {
           bd.fecharConexao();
        }
        catch (SQLException e)
        {
            throw new Exception ("desconexao do SGBD");
        }
    }
    
    /*public boolean ValidaLoginSenha (String login, String pass) throws Exception
    {
    	ResultSet resultado = null;
        try
        {
            resultado = bd.execConsulta("SELECT COUNT(*) AS Qtos FROM Usuario WHERE Login = '" + login + "' AND Senha = '" + pass + "'");
        }
        catch (SQLException e)
        {
            throw new Exception ("comando");
        }

        try
        {
            resultado.first();
        }
        catch (SQLException e)
        {
            throw new Exception ("posicionamento em linha");
        }

        int r = 0;

        try
        {
            r = resultado.getInt ("Qtos");
            return r > 0;
        }
        catch (SQLException e)
        {
            throw new Exception ("recuperacao de coluna");
        }

    }
    
    public List montaComboCompromisso() throws SQLException, Exception 
    {  
       String sql = "SELECT descCompromisso FROM COMPROMISSOS";
       
       try
       {
          ResultSet rs = null;
          rs = bd.execConsulta(sql);
          List lista = new ArrayList();   
          while (rs.next()) 
          {   
             String [] dados = new String[2];
             dados[0] =(rs.getString("descCompromisso"));
             lista.add(dados[0]);
          }   
          rs.close();
          return lista;
       }
       catch (SQLException e)
       {  
	   throw new Exception ("Erro na montaComboCompromisso()");
       }
    }
    
    public List<Espetaculo> montaComboDatas(String usuario) throws SQLException, Exception 
    {  
       String sql = "SELECT distinct data FROM AGENDAS WHERE usuario ='" + usuario + "'";
       try
       {
          ResultSet rs = null;
          rs = bd.execConsulta(sql);
          List lista = new List<Espetaculo>();   
          while (rs.next()) 
          {   
             String [] dados = new String[2];
             dados[0] =(rs.getString("data"));
             lista.add(dados[0]);
          }   
          rs.close();
          return lista;
       }
       catch (SQLException e)
       {  
	   throw new Exception ("Erro na montaComboCompromisso()");
       }
    }*/
    public List<Espetaculo> montaComboEspetaculos()throws SQLException{
	try{
		String sql = "SELECT * FROM Espetaculo";
		ResultSet rs = bd.execConsulta(sql);
		List lista = new List<Espetaculo>();   
          	while (rs.next()) 
          	{   
             		Espetaculo atual = new Espetaculo(rs.getInt("codEspetaculo"), 
rs.getString("nome"), rs.getInt("codGenero"), rs.getString("duracao"), rs.getString("sinopse"), rs.getInteger("censura"), 
rs.getString("direcao"), rs.getString("idioma"));
             		//dados[0] =(rs.getString("data"));
             		lista.add(dados);
          	}   
          	rs.close();
          	return lista;
	}
	catch(SQLException ex){
		throw new Exception("Erro de conexão: Connect.montaComboEspetaculos()");
	}

    }
	public List<Date> montaComboDatas(String nome)throws SQLException{
		try{
			String sql = "SELECT * FROM "
		}
		catch(SQLException ex){
			throw new Exception("Erro de conexão: Connect.montaComboDatas()");
		}
	}
	public String selecionaGenero(int cod)throws SQLException, Exception{
		try{
			String sql = "SELECT nome FROM GeneroEspetaculo where codGenero = "+cod;
			String nome = null;
			ResultSet rs = bd.execConsulta(sql);
			if(rs.next())
				nome = rs.getString("nome");
			if(nome == null)
				throw new Exception("Não há gênero de código"+cod);
			return nome;
		}
		catch(SQLException ex){
			throw new Exception("Erro de conexão: Connect.selecionaGenero()");
		}
	}
	
	public String selecionaEspetaculo(int cod)throws SQLException, Exception{
		try{
			String sql = "SELECT nome FROM Espetaculo WHEREcodEspetaculo = "+cod;
			String nome = null;
			ResultSet rs = bd.execConsulta(sql);
			if(rs.next())
				nome = rs.getString("nome");
			if(nome == null)
				throw new Exception("Não há espetáculo de código"+cod);
			return nome;
		}
		catch(SQLException ex){
			throw new Exception("Erro de conexão: Connect.selecionaGenero()");
		}
	}
    
    /*public boolean existsUser (String login) throws Exception
    {
    	ResultSet resultado = null;
        try
        {
            resultado = bd.execConsulta
            ("Select count(*) as Qtos from Usuario where Nome like '" + login + "'");
        }
        catch (SQLException e)
        {
            throw new Exception ("comando");
        }

        try
        {
            resultado.first ();
        }
        catch (SQLException e)
        {
            throw new Exception ("posicionamento em linha");
        }

        int r = 0;
        try
        {
            r = resultado.getInt ("Qtos");
            return r > 0;
        }
        catch (SQLException e)
        {
            throw new Exception ("recuperacao de coluna");
        }
    }
    

    public void insertUser (String email, String login, String senha, String nome) throws Exception
    {
        if (this.existsUser (login))
        {
            throw new Exception ("Login ja registrado!");
        }

        try
        {
            bd.execComando
            ("Insert into Usuario (Email, Login, Senha, Nome) values ('" + email + "','" + login + "','" + senha + "','" + nome + "')");
        }
        catch(SQLException e)
        {
            throw new Exception ("Erro na inclusão de um NOVO USUÁRIO");
        }
    }  
    
    public boolean insertAgendas (String sql) throws Exception
    {
        try
        {
            bd.execComando (sql);
            return true;
        }
        catch(SQLException e)
        {
            return false;
        }
    }  

    public List listaAgenda(String usuario) throws Exception 
    {
        List lista = new ArrayList();
        try
        {
            String sql = "select * from AGENDAS where usuario = '" + usuario + "'";
            ResultSet resultado = null;
            resultado = bd.execConsulta(sql);
            while (resultado.next())
            {
                this.agenda = new agendaDBO(resultado.getInt("idCompromisso"),resultado.getString("data"),resultado.getString("horario"),resultado.getString("observacao"),resultado.getString("usuario"));
                lista.add(agenda);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return lista;
    }    
    
    
    public List listaAgendaData(String usuario,String data) throws Exception 
    {
        List lista = new ArrayList();
        try
        {
            String sql = "select * from AGENDAS where usuario = '" + usuario + "' and data='" + data + "'";
            ResultSet resultado = null;
            resultado = bd.execConsulta(sql);
            while (resultado.next())
            {
                this.agenda = new agendaDBO(resultado.getInt("idCompromisso"),resultado.getString("data"),resultado.getString("horario"),resultado.getString("observacao"),resultado.getString("usuario"));
                lista.add(agenda);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return lista;
    }    
    
    public void montaGridViewAgendas (String usuario) throws Exception
    {
        try
        {
           String[] nomesColunas = {"DATA", "HORARIO", "COMPROMISSO","OBSERVAÇÃO"};
           //List<String[]> listaDados = new ArrayList<>();
           JTable tabela = new JTable();
           ResultSet resultado = null;
           String sql = "select * from AGENDAS where usuario = '" + usuario + "'";
           resultado = bd.execConsulta(sql);

           DefaultTableModel model =(DefaultTableModel) tabela.getModel();
           model.setNumRows(0);
            
           while(resultado.next()) 
           {
              model.addRow(new Object[] 
              { 
                 //retorna os dados da tabela do BD, cada campo e um coluna.
                 resultado.getString("data"),
                 resultado.getString("horario"),
                 resultado.getString("compromisso"),
                 resultado.getString("observacao")
              }); 
           } 
           //return tabela;
           //return sql;
        }
        catch(SQLException e)
        {
            throw new Exception ("Erro na montagem do gridview de COMPROMISSOS! ");
        }
    }      */
}  
    
    

