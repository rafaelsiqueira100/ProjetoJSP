package DAOs;

import DBOs.Poltrona;
import core.MeuResultSet;
import java.sql.SQLException;

/**
 *
 * @author u15185
 */
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author u16191
 */
public class Poltronas extends Dao{
    public Poltronas() throws Exception{
        super();
    }
    /* public Poltrona[] getPoltronasOcupados(int codSessao, int codSetor) throws SQLException {
         //mudar SQLStatement para o Poltrona
       	String query = "SELECT * FROM Poltronas a "
                + "inner join Setor se on se.codSetor = a.codSetor"
                + "inner join Teatro t on t.codTeatro = se.codTeatro"
                + "inner join Sessao s on s.codTeatro = t.codTeatro"
                + "inner join Ingresso i on i.codPoltrona = a.codPoltrona"
                + "where s.codSessao = ? and se.codSetor = ?";
               
       
	Poltrona[] Poltronas = new Poltrona[this.qtosPoltronasOcupados(codSessao, codSetor)];
               
        this.getBd().prepareStatement(query);
        
        this.getBd().setInt(1, codSessao);
        this.getBd().setInt(2, codSetor);
        
       	MeuResultSet resPoltrona = (MeuResultSet) this.getBd().executeQuery();
        
       	int indicePoltronas = -1;
        while (resPoltrona.next()) {
       	    indicePoltronas++;
            
       		try {
               		Poltrona aIncluir = new Poltrona (resPoltrona.getInt("codPoltrona"), resPoltrona.getInt("codSetor"));
                
               		Poltronas[indicePoltronas] = aIncluir;
            	} catch (SQLException e) {}            
       	}        
      	return Poltronas;
     
     
     }
     public int qtosPoltronasOcupados(int codSessao, int codSetor) throws SQLException{
      
        int qtosPoltronas  = 0;
                //mudar SQLStatement para o Poltrona
       	String query = "SELECT COUNT(e.codPoltrona) AS qtosPoltronas FROM Poltronas a "
                + "inner join Setor se on se.codSetor = a.codSetor"
                + "inner join Teatro t on t.codTeatro = se.codTeatro"
                + "inner join Sessao s on s.codTeatro = t.codTeatro"
               +"inner join Ingresso i on i.codPoltrona = a.codPoltrona"
                + "where s.codSessao = ? and se.codSetor = ?";
        
       	this.getBd().prepareStatement(query);
        this.getBd().setInt(1, codSessao);
        this.getBd().setInt(2, codSetor);
       	MeuResultSet rsPoltrona = (MeuResultSet) this.getBd().executeQuery();
        
       	if (rsPoltrona.next()) {
            qtosPoltronas  = rsPoltrona.getInt("qtosPoltronas");
        }
        	
        return qtosPoltronas  ;
     
     }*/
     public int qtosPoltronas(int codSessao, int codSetor)throws Exception{
     try{
         int qtosPoltronas  = 0;
                //mudar SQLStatement para o Poltrona
       	String query = "SELECT COUNT(a.codPoltrona) FROM Poltronas a "
                + "inner join Setor se on se.codSetor = a.codSetor"
                + "inner join Teatro t on t.codTeatro = se.codTeatro"
                + "inner join Sessao s on s.codTeatro = t.codTeatro"
                + "where s.codSessao = ? and se.codSetor = ?";
        
       	this.getBd().prepareStatement(query);
        this.getBd().setInt(1, codSessao);
        this.getBd().setInt(2, codSetor);
       	MeuResultSet rsPoltrona = (MeuResultSet) this.getBd().executeQuery();
        
       	if (rsPoltrona.next()) {
            qtosPoltronas  = rsPoltrona.getInt("qtosPoltronas");
        }
        	
        return qtosPoltronas  ;}
     catch (Exception ex){
            ex.getMessage();
        }
     throw new Exception("qtdPoltronas");
     }
     public Poltrona[] getPoltronas(int codSessao, int codSetor) throws Exception {
         try{
         //mudar SQLStatement para o Poltrona
       	String query = "SELECT * FROM Poltronas a "
                + "inner join Setor se on se.codSetor = a.codSetor"
                + "inner join Teatro t on t.codTeatro = se.codTeatro"
                + "inner join Sessao s on s.codTeatro = t.codTeatro"
                + "where s.codSessao = ? and se.codSetor = ?"
                + "order by a.fileira";
               
       
	Poltrona[] Poltronas = new Poltrona[this.qtosPoltronas(codSessao, codSetor)];
               
        this.getBd().prepareStatement(query);
        this.getBd().setInt(1, codSessao);
        this.getBd().setInt(2, codSetor);
        
       	MeuResultSet resPoltrona = (MeuResultSet) this.getBd().executeQuery();
        
       	int indicePoltronas = -1;
        while (resPoltrona.next()) {
       	    indicePoltronas++;
            
       		try {
               		Poltrona aIncluir = new Poltrona (resPoltrona.getInt("codPoltrona"), resPoltrona.getInt("fileira"), resPoltrona.getString("letra").charAt(0), resPoltrona.getBoolean("situacao"), resPoltrona.getInt("codSetor") );
                
               		Poltronas[indicePoltronas] = aIncluir;
            	} catch (SQLException e) {}            
       	}        
      	return Poltronas;
        }
        catch(Exception ex){
             ex.getMessage();
        }
         throw new Exception("Get Poltrona");
     }/*
     public int qtosPoltronas(int codSessao, int codSetor) throws SQLException{
      
        int qtosPoltronas  = 0;
                //mudar SQLStatement para o Poltrona
       	String query = "SELECT COUNT(e.codPoltrona) AS qtosPoltronas FROM Poltronas a "
                + "inner join Setor se on se.codSetor = a.codSetor"
                + "inner join Teatro t on t.codTeatro = se.codTeatro"
                + "inner join Sessao s on s.codTeatro = t.codTeatro"
                + "where s.codSessao = ? and se.codSetor = ?";
        
       	this.getBd().prepareStatement(query);
        this.getBd().setInt(1, codSessao);
        this.getBd().setInt(2, codSetor);
        
       	MeuResultSet rsPoltrona = (MeuResultSet) this.getBd().executeQuery();
        
       	if (rsPoltrona.next()) {
            qtosPoltronas  = rsPoltrona.getInt("qtosPoltronas");
        }
        	
        return qtosPoltronas  ;
     
     }
     public Poltrona[] getPoltronasDisponiveis(int codSessao, int codSetor)throws Exception{
         try{
             Poltrona[] PoltronasOcupados = getPoltronasOcupados(codSessao, codSetor);
             Poltrona[] totalPoltronas = getPoltronas(codSessao, codSetor);
             Poltrona[] PoltronasDisponiveis = new Poltrona[totalPoltronas.length - PoltronasOcupados.length ];
             int indDisp = 0;
             for(int i=0;i< totalPoltronas.length; i++){
                 if(!contem(PoltronasOcupados,totalPoltronas[i])){//se nao esta na de ocupados
                     PoltronasDisponiveis[indDisp] = new Poltrona(totalPoltronas[i].getCodPoltrona(),totalPoltronas[i].getCodSetor());
                 }
             }
             return PoltronasDisponiveis;
             
         }
         catch(Exception ex){
             ex.printStackTrace();
             
         }
         throw new Exception("");
     }
     public boolean contem(Poltrona[]ocup, Poltrona a){
        for(int i=0;i<ocup.length;i++){
               if(ocup[i].equals(a))
                   return true;
        }
        return false;
     }
}*/

}
