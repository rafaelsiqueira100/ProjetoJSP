

package DAOs;

import core.*;

/**
 * Classe cujos atributos correspondem aos objetos de acesso ao BD
 * @author Matheus Alencar Zanfolin
 * @since 2016
 */
public class DAOs {
    private static Clientes     	tabelaClientes;
    private static Espetaculos  	tabelaEspetaculos;
    private static GenerosEspetaculos 	tabelaGenerosEspetaculos ;
    private static PerfisClientes	tabelaPerfisClientes;
    private static Poltronas     	tabelaPoltronas;
    private static Sessoes		tabelaSessoes;
    private static Teatros        	tabelaTeatros;
    
    /**
     * Visto que todos os atributos são estáticos, são todos inicializados no construtor estático.
     */
    static {
        try {
            tabelaClientes      	= new Clientes();
            tabelaEspetaculos		= new Espetaculos();
            tabelaGenerosEspetaculos 	= new GenerosEspetaculos();
            tabelaPerfisClientes	= new PerfisClientes();
            tabelaPoltronas		= new Poltronas();
            tabelaSessoes		= new Sessoes();
            tabelaTeatros		= new Teatros();
            
        } catch (Exception e) {}        
    }
    /**
     * Pega o dao de clientes
     * @return o dao que dá acesso a tabela de cliente
     */
    public static Clientes getTabelaClientes () {
        return tabelaClientes ;
    }
    /**
     * Pega o dao de Espetaculos
     * @return o dao que dá acesso a tabela de Espetaculo
     */
    public static Usuarios getTabelaEspetaculos() {
        return tabelaEspetaculos;
    }
    /**
     * Pega o dao de Generos de Espetaculos
     * @return o dao que dá acesso a tabela de Genero de Espetaculo
     */
    public static Fornecedores getTabelaGenerosEspetaculos() {
        return tabelaGenerosEspetaculos;
    }
    /**
     * Pega o dao de Perfis de Clientes
     * @return o dao que dá acesso a tabela de Perfil de Cliente
     */
    public static Lotes getTabelaPerfisClientes() {
        return tabelaPerfisClientes;
    }
    /**
     * Pega o dao de Poltronas
     * @return o dao que dá acesso a tabela de Poltrona
     */
    public static Poltronas getTabelaPoltronas() {
        return tabelaPoltronas;
    }
    /**
     * Pega o dao de Sessoes
     * @return o dao que dá acesso a tabela de Sessão
     */
    public static Sessoes getTabelaSessoes() {
        return tabelaSessoes;
    }
    /**
     * Pega o dao de Teatros
     * @return o dao que dá acesso a tabela de Teatro
     */
    public static Teatros getTabelaTeatros() {
        return tabelaTeatros;
    }
    
   
}
