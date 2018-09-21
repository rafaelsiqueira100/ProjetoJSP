package DAOs;

/**
 * Classe cujos atributos correspondem aos objetos de acesso ao BD
 * @author Matheus Alencar Zanfolin
 * @since 2016
 */
public class DAOs {
    private static Assentos             tabelaAssentos;
    private static Clientes     	tabelaClientes;
    private static Espetaculos  	tabelaEspetaculos;
    private static GenerosEspetaculos 	tabelaGenerosEspetaculos ;
    private static PerfisClientes	tabelaPerfisClientes;
    private static Poltronas     	tabelaPoltronas;
    private static Sessoes		tabelaSessoes;
    private static Teatros        	tabelaTeatros;
    private static Ingressos            tabelaIngressos;
    
    /**
     * Visto que todos os atributos são estáticos, são todos inicializados no construtor estático.
     */
    static {
        try {
            tabelaAssentos              = new Assentos();
            tabelaClientes      	= new Clientes();
            tabelaEspetaculos		= new Espetaculos();
            tabelaGenerosEspetaculos 	= new GenerosEspetaculos();
            tabelaPerfisClientes	= new PerfisClientes();
            tabelaPoltronas		= new Poltronas();
            tabelaSessoes		= new Sessoes();
            tabelaTeatros		= new Teatros();
            tabelaIngressos             = new Ingressos();
            
        } catch (Exception e) {}        
    }
    /**
     * Pega o dao de assentos
     * @return o dao que dá acesso a tabela de assento
     */
    public static Assentos getTabelaAssentos () {
        return tabelaAssentos ;
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
    public static Espetaculos getTabelaEspetaculos() {
        return tabelaEspetaculos;
    }
    /**
     * Pega o dao de Generos de Espetaculos
     * @return o dao que dá acesso a tabela de Genero de Espetaculo
     */
    public static GenerosEspetaculos getTabelaGenerosEspetaculos() {
        return tabelaGenerosEspetaculos;
    }
    /**
     * Pega o dao de Perfis de Clientes
     * @return o dao que dá acesso a tabela de Perfil de Cliente
     */
    public static PerfisClientes getTabelaPerfisClientes() {
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
    /**
        * Pega o dao de Ingressos
     * @return o dao que dá acesso a tabela de Ingresso
     */
    public static Ingressos getTabelaIngressos() {
        return tabelaIngressos;
    }
   
}
