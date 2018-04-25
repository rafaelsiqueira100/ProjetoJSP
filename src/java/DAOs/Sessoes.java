package DBOs;

/**
 *
 * @author u15185
 */
public class Sessoes {
    public Sessoes() throws Exception{
		super();
	}


	public int qtosSessoesDisponiveis(int codEspetaculo) throws SQLException {
        	int qtosSessoes  = 0;
        
        	String query = "SELECT COUNT(e.codSessao)
		 AS qtosSessoes FROM Sessoes s
		inner join Teatro t on t.codTeatro = s.codTeatro
		inner join Setor set on set.codTeatro = t.codTeatro
		inner join Assento a on a.codSetor = set.codSetor
		inner join Ingresso i on i.codAssento
		where (SELECT COUNT(codAssento) FROM Assento) > 
		(SELECT COUNT(codIngresso) FROM Ingresso) and 
		s.codEspetaculo = ?";
        
        	this.getBd().prepareStatement(query);
        	this.getBd().setInt(1, codEspetaculo);
        	MeuResultSet rsSessao = (MeuResultSet) this.getBd().executeQuery();
        
        	if (rsSessao.next()) {
         	   qtosSessoes  = rsSessao.getInt("qtosSessoes");
	        }
        	
	        return qtosSessoes  ;
    	}
	public Sessao[] getSessoesDisponiveis(int codEspetaculo) throws SQLException {
        	String query = "SELECT * FROM Sessao e 
		inner join Sessao s on s.codSessao = e.codSessao
		inner join Teatro t on t.codTeatro = s.codTeatro
		inner join Setor set on set.codTeatro = t.codTeatro
		inner join Assento a on a.codSetor = set.codSetor
		inner join Ingresso i on i.codAssento
		where (SELECT COUNT(codAssento) FROM Assento) > 
		(SELECT COUNT(codIngresso) FROM Ingresso) and
		s.codEspetaculo = ?
		";
       
       		Sessao[] Sessoes = new Sessao[this.qtosSessoesDisponivies()];
               
	        this.getBd().prepareStatement(query);
        	this.getBd().setInt(1, codEspetaculo);
        	MeuResultSet Sessao = (MeuResultSet) this.getBd().executeQuery();
        
        	int indiceSessoes = -1;
	        while (Sessao.next()) {
        	    indiceSessoes++;
            
            	try {
                	Sessao aIncluir = new Sessao (Sessao.getInt("codSessao"), Sessao.getInt("codPedido"), Sessao.getBigDecimal("razaoPrecoFinal"), Sessao.getDate("dataPagamento"), Sessao.getDate("dataFoiEntregue"));
                
                	Sessoes[indiceSessoes] = aIncluir;
	            } catch (Exception e) {}            
        	}
        
        	return Sessoes;
 	   }
   
}
