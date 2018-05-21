/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;
import java.sql.SQLException;
import core.MeuResultSet;
import DBOs.Setor;
/**
 *
 * @author u16191
 */
public class Setores extends Dao{
    public Setores() throws Exception{
        super();
    }
    public int qtosSetoresDisponiveis(int codTeatro) throws SQLException {
        	int qtosSetores  = 0;
        
        	String query = "SELECT COUNT(set.codSetor) FROM Setores set"
                        + " inner join Teatro t on set.codTeatro = t.codTeatro"
                        + " inner join Assento a on a.codSetor = set.codSetor"
                        + " inner join Ingresso i on i.codAssento"
                        + " WHERE (SELECT COUNT(codAssento) FROM Assento) > (SELECT COUNT(codIngresso) FROM Ingresso)"
                        + " AND t.codTeatro = ?";
        	this.getBd().prepareStatement(query);
                this.getBd().setInt(1, codTeatro);
        	
        	MeuResultSet rsEspetaculo = (MeuResultSet) this.getBd().executeQuery();
        
        	if (rsEspetaculo.next()) {
         	   qtosSetores  = rsEspetaculo.getInt("qtosSetores");
	        }
        	
	        return qtosSetores  ;
    	}
        
	public Setor[] SetoresDisponiveis(int codTeatro) throws SQLException {
        	String query = "SELECT * FROM Setores set"
                        + " inner join Teatro t on set.codTeatro = t.codTeatro"
                        + " inner join Assento a on a.codSetor = set.codSetor"
                        + " inner join Ingresso i on i.codAssento"
                        + " WHERE (SELECT COUNT(codAssento) FROM Assento) > (SELECT COUNT(codIngresso) FROM Ingresso)"
                        + " AND t.codTeatro = ?";
         
       
       		Setor[] setores = new Setor[this.qtosSetoresDisponiveis(codTeatro)];
               
	        this.getBd().prepareStatement(query);
                this.getBd().setInt(1, codTeatro);
        	MeuResultSet setor = (MeuResultSet) this.getBd().executeQuery();
        
        	int indiceSetores = -1;
	        while (setor.next()) {
        	    indiceSetores++;
            
            		try {
                		Setor aIncluir = new Setor (setor.getInt("codSessao"),
                                        setor.getInt("codTeatro"),setor.getString("nome"));
                
                		setores[indiceSetores] = aIncluir;
	            	} catch (Exception e) {}            
        	}
        
        	return setores;
 	   }
}
