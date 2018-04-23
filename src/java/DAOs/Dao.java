
package DAOs;

import core.*;

/**
 * @author Rafael Andre Siqueira
 *  Superclasse de todas as classes DAO do projeto 
 */
public class Dao {
    private MeuPreparedStatement bd;
    /**
     * inicializa o objeto meuPreparedStatement que será utilizado em todos os acessos ao BD
     * @throws Exception  devido ao método meu prepared statement
     */
    public Dao() throws Exception {
        this.bd = new MeuPreparedStatement ("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://Regulus:1433;databasename=JSP1RB16191", "JSP1RB16191", "JSP1RB16191");            
    }
    /**
     * Pega o atributo MeuPreparedStatement do objeto DAO
     * @return o atributo MeuPreparedStatement do objeto DAO. Visto que o atributo é de nível
     * private, este método é o único acesso que as classes filhas terão ao objeto meuPreparedStatement
     */
    public MeuPreparedStatement getBd() {
        return this.bd;
    }
}

