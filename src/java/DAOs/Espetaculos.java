package DAOs;
import java.sql.SQLException;
import core.MeuResultSet;
import DBOs.Espetaculo
/**
 *
 * @author u15185
 */
public class Espetaculos extends Dao{
    /*TODO
    * Consultar Todos
    * Consultar por Codigo
    * Consultar por nome
    * Consultar Todos por GeneroEspetaculo
    * Consultar Todos por Censura    
    */
	public Espetaculos() throws Exception{
		super();
	}


	public int qtosEspetaculosDisponiveis() throws SQLException {
        	int qtosEspetaculos  = 0;
        
        	String query = "SELECT COUNT(e.codEspetaculo)
		 AS qtosEspetaculos FROM Espetaculos e 
		inner join Sessao s on s.codEspetaculo = e.codEspetaculo
		inner join Teatro t on t.codTeatro = s.codTeatro
		inner join Setor set on set.codTeatro = t.codTeatro
		inner join Assento a on a.codSetor = set.codSetor
		inner join Ingresso i on i.codAssento
		where (SELECT COUNT(codAssento) FROM Assento) > 
		(SELECT COUNT(codIngresso) FROM Ingresso)
		";
        
        	this.getBd().prepareStatement(query);
        
        	MeuResultSet rsEspetaculo = (MeuResultSet) this.getBd().executeQuery();
        
        	if (rsEspetaculo.next()) {
         	   qtosEspetaculos  = rsEspetaculo.getInt("qtosEspetaculos");
	        }
        	
	        return qtosEspetaculos  ;
    	}
	public Espetaculo[] getEspetaculosDisponiveis() throws SQLException {
        	String query = "SELECT * FROM Espetaculo e 
		inner join Sessao s on s.codEspetaculo = e.codEspetaculo
		inner join Teatro t on t.codTeatro = s.codTeatro
		inner join Setor set on set.codTeatro = t.codTeatro
		inner join Assento a on a.codSetor = set.codSetor
		inner join Ingresso i on i.codAssento
		where (SELECT COUNT(codAssento) FROM Assento) > 
		(SELECT COUNT(codIngresso) FROM Ingresso)
		";
       
       		Espetaculo[] Espetaculos = 
		new Espetaculo[this.qtosEspetaculosDisponiveis()];
               
	        this.getBd().prepareStatement(query);
        
        	MeuResultSet Espetaculo = (MeuResultSet) this.getBd().executeQuery();
        
        	int indiceEspetaculos = -1;
	        while (Espetaculo.next()) {
        	    indiceEspetaculos++;
            
            		try {
                		Espetaculo aIncluir = new Espetaculo (Espetaculo.getInt("codEspetaculo"), Espetaculo.getInt("codPedido"), Espetaculo.getBigDecimal("razaoPrecoFinal"), Espetaculo.getDate("dataPagamento"), Espetaculo.getDate("dataFoiEntregue"));
                
                		Espetaculos[indiceEspetaculos] = aIncluir;
	            	} catch (Exception e) {}            
        	}
        
        	return Espetaculos;
 	   }
	public Espetaculo getEspetaculo(String nome) throws SQLException{
		String query = "SELECT * FROM Espetaculo e WHERE e.nome = ?";
		this.getBd().prepareStatement(query) ;
		this.getBd().setString(1, nome);
		MeuResultSet rsEspetaculo = (MeuResultSet) this.getBd().executeQuery();
		Espetaculo retorno = null;
		if(rsEspetaculo.next())
			retorno = new Espetaculo(rsEspetaculo.get);
		else

	
	}
}
