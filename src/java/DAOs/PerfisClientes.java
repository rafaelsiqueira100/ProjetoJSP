package DAOs;
import core.MeuResultSet;
import java.sql.SQLException;
import DBOs.PerfilCliente;
import java.sql.Date;
/**
 *
 * @author u15185
 */
public class PerfisClientes extends Dao{
    public PerfisClientes() throws Exception{
        super();
    }
    public int qtosPerfisClientes() throws SQLException{
    int qtosPerfisClientes  = 0;
                //mudar SQLStatement para o PerfilCLiente
       	String query = "SELECT COUNT(pc.codPerfiCliente) AS qtosPerfis FROM PerfilCliente pc ";
        
       	this.getBd().prepareStatement(query);
        
       	MeuResultSet rsPerfilCliente = (MeuResultSet) this.getBd().executeQuery();
        
       	if (rsPerfilCliente.next()) {
            qtosPerfisClientes  = rsPerfilCliente.getInt("qtosPerfisClientes");
        }
        	
        return qtosPerfisClientes  ;
    }
    
    public PerfilCliente[] getPerfisClientes() throws SQLException{
    //mudar SQLStatement para o CLiente
      	String query = "SELECT * FROM PerfilCliente " ;
       
	PerfilCliente[] perfisClientes = new PerfilCliente[this.qtosPerfisClientes()];
               
        this.getBd().prepareStatement(query);
        
       	MeuResultSet perfilCliente = (MeuResultSet) this.getBd().executeQuery();
        
       	int indicePerfisClientes = -1;
        while (perfilCliente.next()) {
       	    indicePerfisClientes++;
            
       		try {
               		PerfilCliente aIncluir = new PerfilCliente (perfilCliente.getInt("codPerfil"), perfilCliente.getString("descricao"), perfilCliente.getInt("percentualDesconto"));
                
               		perfisClientes[indicePerfisClientes] = aIncluir;
            	} catch (SQLException e) {}            
       	}        
      	return perfisClientes;
    }
    public PerfilCliente getPerfilCliente(int codPerfil) throws SQLException{
    //mudar SQLStatement para o CLiente
      	String query = "SELECT * FROM PerfilCliente p WHERE p.codPerfil = ?" ;
       
	PerfilCliente perfil = null;
               
        this.getBd().prepareStatement(query);
        
       	MeuResultSet resultado = (MeuResultSet) this.getBd().executeQuery();
        
        if (resultado.next()) {
            perfil = new PerfilCliente (resultado.getInt("codPerfil"), resultado.getString("descricao"), resultado.getInt("percentualDesconto"));
        }
        else{
            throw new SQLException("PerfilCliente: não há nenhum perfil com o código: "+codPerfil);
        }
      	return perfil;
    }
}
