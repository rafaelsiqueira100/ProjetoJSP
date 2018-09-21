package DAOs;

import core.MeuResultSet;
import java.sql.SQLException;
import DBOs.Cliente;

/**
 *
 * @author u15185
 */
public class Clientes extends Dao{
    /*TODO
    * Consultar Todos
    * Consultar por usuario
    * Consultar por cpf
    * Consultar por email?
    */
    public Clientes() throws Exception{
        super();
    }
    
    public int qtosClientesDisponiveis() throws SQLException {
       	int qtosClientes  = 0;
                //mudar SQLStatement para o CLiente
       	String query = "SELECT COUNT(e.codCliente) AS qtosClientes FROM Clientes e inner join Sessao s on s.codCliente = e.codCliente inner join Teatro t on t.codTeatro = s.codTeatro inner join Setor set on set.codTeatro = t.codTeatro inner join Assento a on a.codSetor = set.codSetor inner join Ingresso i on i.codAssento where (SELECT COUNT(codAssento) FROM Assento) > (SELECT COUNT(codIngresso) FROM Ingresso)";
        
       	this.getBd().prepareStatement(query);
        
       	MeuResultSet rsCliente = (MeuResultSet) this.getBd().executeQuery();
        
       	if (rsCliente.next()) {
            qtosClientes  = rsCliente.getInt("qtosClientes");
        }
        	
        return qtosClientes  ;
    }
    
    public Cliente[] getClientesDisponiveis() throws SQLException {
        //mudar SQLStatement para o CLiente
       	String query = "SELECT * FROM Cliente c "
                //+ "inner join Sessao s on s.codCliente = e.codCliente inner join Teatro t on t.codTeatro = s.codTeatro inner join Setor set on set.codTeatro = t.codTeatro inner join Assento a on a.codSetor = set.codSetor inner join Ingresso i on i.codAssento where (SELECT COUNT(codAssento) FROM Assento) > (SELECT COUNT(codIngresso) FROM Ingresso)"
                +"";
       
	Cliente[] Clientes = new Cliente[this.qtosClientesDisponiveis()];
               
        this.getBd().prepareStatement(query);
        
       	MeuResultSet Cliente = (MeuResultSet) this.getBd().executeQuery();
        
       	int indiceClientes = -1;
        while (Cliente.next()) {
       	    indiceClientes++;
            
       		try {
               		Cliente aIncluir = new Cliente (Cliente.getString("usuario"), Cliente.getString("senha"), Cliente.getInt("codPerfil"), Cliente.getString("cpf"), Cliente.getString("rg"), Cliente.getString("nome"), Cliente.getString("dataNasc"), Cliente.getString("email"), Cliente.getString("celular"));
                
               		Clientes[indiceClientes] = aIncluir;
            	} catch (SQLException e) {}            
       	}        
      	return Clientes;
    }
    public boolean bate(String usuario, String senha){
        try{
            String query ="SELECT c.senha from Cliente c where c.usuario = ?";
            this.getBd().prepareStatement(query);
            this.getBd().setString(1, query);
            MeuResultSet rs = (MeuResultSet) this.getBd().executeQuery();
            String retorno = null;
            if(rs.next())
                retorno = rs.getString("senha");
            else
                return false;
            return (retorno.equals(senha));
        }
        catch(Exception e){
            return false;
        }
    }
    public Cliente getCliente(String usuario) throws Exception{
        String query = "SELECT * FROM Cliente c WHERE c.usuario = ?";
	this.getBd().prepareStatement(query) ;
	this.getBd().setString(1, usuario);
	MeuResultSet rsCliente = (MeuResultSet) this.getBd().executeQuery();
	Cliente retorno = null;
	if(rsCliente.next())
		retorno =  new Cliente (rsCliente.getString("usuario"), rsCliente.getString("senha"), rsCliente.getInt("codPerfil"), rsCliente.getString("cpf"), rsCliente.getString("rg"), rsCliente.getString("nome"), rsCliente.getString("dataNasc"), rsCliente.getString("email"), rsCliente.getString("celular"));
	else
            throw new Exception("Clientes : Não existe espetáculo com esse usuário:" + usuario);
        
        return retorno;
    }
    
    public Cliente getCliente(int codCliente) throws Exception{
	String query = "SELECT * FROM Cliente e WHERE e.codCliente = ?";
	this.getBd().prepareStatement(query) ;
	this.getBd().setInt(1, codCliente);
	MeuResultSet rsCliente = (MeuResultSet) this.getBd().executeQuery();
	Cliente retorno = null;
	if(rsCliente.next())
            retorno =  new Cliente (rsCliente.getString("usuario"), rsCliente.getString("senha"), rsCliente.getInt("codPerfil"), rsCliente.getString("cpf"), rsCliente.getString("rg"), rsCliente.getString("nome"), rsCliente.getString("dataNasc"), rsCliente.getString("email"), rsCliente.getString("celular"));
	else
            throw new Exception("Clientes : Não existe cliente com esse código:" + Integer.toString(codCliente));
        
        return retorno;
    }
   // public Cliente getCliente
    public boolean insertCliente(Cliente cliente){
        try {
            String command = "INSERT INTO Cliente VALUES (?,?,?,?,?,?,?,?,?)";
            this.getBd().prepareStatement(command);
            
            this.getBd().setString(1, cliente.getUsuario());
            this.getBd().setString(2, cliente.getSenha());
            this.getBd().setString(3, cliente.getCpf());
            this.getBd().setString(4, cliente.getRg());
            this.getBd().setString(5, cliente.getNome());
            this.getBd().setString(6, cliente.getDataNasc());
            this.getBd().setString(7, cliente.getEmail());
            this.getBd().setString(8, cliente.getCelular());
            this.getBd().setInt(9, cliente.getCodPerfil());
            
            this.getBd().executeQuery();
        } catch (SQLException e) {
            //System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
}
