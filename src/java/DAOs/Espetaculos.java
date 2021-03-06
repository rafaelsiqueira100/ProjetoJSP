package DAOs;
import java.sql.SQLException;
import core.MeuResultSet;
import DBOs.Espetaculo;
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
        
        	String query = "SELECT COUNT(e.codEspetaculo) AS qtosEspetaculos FROM Espetaculo E"
                //+ " inner join Sessao s on s.codEspetaculo = e.codEspetaculo inner join Teatro t on t.codTeatro = s.codTeatro inner join Setor se on se.codTeatro = t.codTeatro inner join Assento a on a.codSetor = se.codSetor inner join Ingresso i on i.codAssento = a.codAssento where (SELECT COUNT(codAssento) FROM Assento) > (SELECT COUNT(codIngresso) FROM Ingresso)"     
                +"";
        	this.getBd().prepareStatement(query);
        
        	MeuResultSet rsEspetaculo = (MeuResultSet) this.getBd().executeQuery();
        
        	if (rsEspetaculo.next()) {
         	   qtosEspetaculos  = rsEspetaculo.getInt("qtosEspetaculos");
	        }
        	
	        return qtosEspetaculos  ;
    	}
        
	public Espetaculo[] getEspetaculosDisponiveis() throws SQLException {
        	String query = "SELECT * FROM Espetaculo e "
                        //+ "inner join Sessao s on s.codEspetaculo = e.codEspetaculo inner join Teatro t on t.codTeatro = s.codTeatro inner join Setor se on se.codTeatro = t.codTeatro inner join Assento a on a.codSetor = se.codSetor inner join Ingresso i on i.codAssento = a.codAssento where (SELECT COUNT(codAssento) FROM Assento) > (SELECT COUNT(codIngresso) FROM Ingresso)"
                        + "";
       
       		Espetaculo[] Espetaculos = new Espetaculo[this.qtosEspetaculosDisponiveis()];
               
	        this.getBd().prepareStatement(query);
        
        	MeuResultSet Espetaculo = (MeuResultSet) this.getBd().executeQuery();
        
        	int indiceEspetaculos = -1;
	        while (Espetaculo.next()) {
        	    indiceEspetaculos++;
            
            		try {
                		Espetaculo aIncluir = new Espetaculo (Espetaculo.getInt("codEspetaculo"), Espetaculo.getString("nome"), Espetaculo.getInt("codGenero"), Espetaculo.getInt("duracao"), Espetaculo.getString("sinopse"), Espetaculo.getInt("censura"), Espetaculo.getString("direcao"), Espetaculo.getString("idioma"));
                
                		Espetaculos[indiceEspetaculos] = aIncluir;
	            	} catch (Exception e) {
                            
                        e.printStackTrace();
                        }            
        	}
        
        	return Espetaculos;
 	   }
	public Espetaculo getEspetaculo(String nome) throws Exception{
		String query = "SELECT * FROM Espetaculo e WHERE e.nome = ?";
		this.getBd().prepareStatement(query) ;
		this.getBd().setString(1, nome);
		MeuResultSet rsEspetaculo = (MeuResultSet) this.getBd().executeQuery();
		Espetaculo retorno = null;
		if(rsEspetaculo.next())
			retorno =  new Espetaculo (rsEspetaculo.getInt("codEspetaculo"), rsEspetaculo.getString("nome"), rsEspetaculo.getInt("codGenero"), rsEspetaculo.getInt("duracao"), rsEspetaculo.getString("sinopse"), rsEspetaculo.getInt("censura"), rsEspetaculo.getString("direcao"), rsEspetaculo.getString("idioma"));
		else
            throw new Exception("Espetaculos : Não existe espetáculo com esse nome:" + nome);
                return retorno;
	}
    public Espetaculo getEspetaculo(int codEspetaculo) throws Exception{
		String query = "SELECT * FROM Espetaculo e WHERE e.codEspetaculo = ?";
		this.getBd().prepareStatement(query) ;
		this.getBd().setInt(1, codEspetaculo);
		MeuResultSet rsEspetaculo = (MeuResultSet) this.getBd().executeQuery();
		Espetaculo retorno = null;
		if(rsEspetaculo.next())
			retorno =  new Espetaculo (rsEspetaculo.getInt("codEspetaculo"), rsEspetaculo.getString("nome"), rsEspetaculo.getInt("codGenero"), rsEspetaculo.getInt("duracao"), rsEspetaculo.getString("sinopse"), rsEspetaculo.getInt("censura"), rsEspetaculo.getString("direcao"), rsEspetaculo.getString("idioma"));
		else
            throw new Exception("Espetaculos : Não existe espetáculo com esse código:" + Integer.toString(codEspetaculo));
                return retorno;
	}
}
