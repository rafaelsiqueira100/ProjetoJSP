/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import DBOs.Assento;
import core.MeuResultSet;
import java.sql.SQLException;

/**
 *
 * @author u16191
 */
public class Assentos extends Dao{
    public Assentos() throws Exception{
        super();
    }
     public Assento[] getAssentosOcupados(int codSessao, int codSetor) throws SQLException {
         //mudar SQLStatement para o Assento
       	String query = "SELECT * FROM Assentos a "
                + "inner join Setor se on se.codSetor = a.codSetor"
                + "inner join Teatro t on t.codTeatro = se.codTeatro"
                + "inner join Sessao s on s.codTeatro = t.codTeatro"
                + "inner join Ingresso i on i.codAssento = a.codAssento"
                + "where s.codSessao = ? and se.codSetor = ?";
               
       
	Assento[] assentos = new Assento[this.qtosAssentosOcupados(codSessao, codSetor)];
               
        this.getBd().prepareStatement(query);
        
        this.getBd().setInt(1, codSessao);
        this.getBd().setInt(2, codSetor);
        
       	MeuResultSet resAssento = (MeuResultSet) this.getBd().executeQuery();
        
       	int indiceAssentos = -1;
        while (resAssento.next()) {
       	    indiceAssentos++;
            
       		try {
               		Assento aIncluir = new Assento (resAssento.getInt("codAssento"), resAssento.getInt("codSetor"));
                
               		assentos[indiceAssentos] = aIncluir;
            	} catch (SQLException e) {}            
       	}        
      	return assentos;
     
     
     }
     public int qtosAssentosOcupados(int codSessao, int codSetor) throws SQLException{
      
        int qtosAssentos  = 0;
                //mudar SQLStatement para o Assento
       	String query = "SELECT COUNT(e.codAssento) AS qtosAssentos FROM Assentos a "
                + "inner join Setor se on se.codSetor = a.codSetor"
                + "inner join Teatro t on t.codTeatro = se.codTeatro"
                + "inner join Sessao s on s.codTeatro = t.codTeatro"
               +"inner join Ingresso i on i.codAssento = a.codAssento"
                + "where s.codSessao = ? and se.codSetor = ?";
        
       	this.getBd().prepareStatement(query);
        this.getBd().setInt(1, codSessao);
        this.getBd().setInt(2, codSetor);
       	MeuResultSet rsAssento = (MeuResultSet) this.getBd().executeQuery();
        
       	if (rsAssento.next()) {
            qtosAssentos  = rsAssento.getInt("qtosAssentos");
        }
        	
        return qtosAssentos  ;
     
     }
     public Assento[] getAssentos(int codSessao, int codSetor) throws SQLException {
         //mudar SQLStatement para o Assento
       	String query = "SELECT * FROM Assentos a "
                + "inner join Setor se on se.codSetor = a.codSetor"
                + "inner join Teatro t on t.codTeatro = se.codTeatro"
                + "inner join Sessao s on s.codTeatro = t.codTeatro"
                + "where s.codSessao = ? and se.codSetor = ?";
               
       
	Assento[] assentos = new Assento[this.qtosAssentos(codSessao, codSetor)];
               
        this.getBd().prepareStatement(query);
        this.getBd().setInt(1, codSessao);
        this.getBd().setInt(2, codSetor);
        
       	MeuResultSet resAssento = (MeuResultSet) this.getBd().executeQuery();
        
       	int indiceAssentos = -1;
        while (resAssento.next()) {
       	    indiceAssentos++;
            
       		try {
               		Assento aIncluir = new Assento (resAssento.getInt("codAssento"), resAssento.getInt("codSetor"));
                
               		assentos[indiceAssentos] = aIncluir;
            	} catch (SQLException e) {}            
       	}        
      	return assentos;
     
     
     }
     public int qtosAssentos(int codSessao, int codSetor) throws SQLException{
      
        int qtosAssentos  = 0;
                //mudar SQLStatement para o Assento
       	String query = "SELECT COUNT(e.codAssento) AS qtosAssentos FROM Assentos a "
                + "inner join Setor se on se.codSetor = a.codSetor"
                + "inner join Teatro t on t.codTeatro = se.codTeatro"
                + "inner join Sessao s on s.codTeatro = t.codTeatro"
                + "where s.codSessao = ? and se.codSetor = ?";
        
       	this.getBd().prepareStatement(query);
        this.getBd().setInt(1, codSessao);
        this.getBd().setInt(2, codSetor);
        
       	MeuResultSet rsAssento = (MeuResultSet) this.getBd().executeQuery();
        
       	if (rsAssento.next()) {
            qtosAssentos  = rsAssento.getInt("qtosAssentos");
        }
        	
        return qtosAssentos  ;
     
     }
     public Assento[] getAssentosDisponiveis(int codSessao, int codSetor)throws Exception{
         try{
             Assento[] assentosOcupados = getAssentosOcupados(codSessao, codSetor);
             Assento[] totalAssentos = getAssentos(codSessao, codSetor);
             Assento[] assentosDisponiveis = new Assento[totalAssentos.length - assentosOcupados.length ];
             int indDisp = 0;
             for(int i=0;i< totalAssentos.length; i++){
                 if(!contem(assentosOcupados,totalAssentos[i])){//se nao esta na de ocupados
                     assentosDisponiveis[indDisp] = new Assento(totalAssentos[i].getCodAssento(),totalAssentos[i].getCodSetor());
                 }
             }
             return assentosDisponiveis;
             
         }
         catch(Exception ex){
             ex.printStackTrace();
             
         }
         throw new Exception("");
     }
     public boolean contem(Assento[]ocup, Assento a){
        for(int i=0;i<ocup.length;i++){
               if(ocup[i].equals(a))
                   return true;
        }
        return false;
     }
}
