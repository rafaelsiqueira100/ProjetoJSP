package DAOs;
import java.sql.SQLException;
import core.MeuResultSet;
import DBOs.Genero;
/**
 *
 * @author u15185
 */
public class GenerosEspetaculos extends Dao{
    public GenerosEspetaculos() throws Exception{
        super();
    }
    public Genero selecionaGenero(int codGenero) throws Exception{
        String query = "SELECT * FROM GeneroEspetaculo ge where ge.codGenero = ?";
        this.getBd().prepareStatement(query);
        this.getBd().setInt(1, codGenero);
        MeuResultSet rsGenero = (MeuResultSet) this.getBd().executeQuery();
        Genero retorno = null;
        if(rsGenero.next())
            retorno = new Genero(rsGenero.getInt("codGenero"), rsGenero.getString("nome"));
        else
            throw new Exception("GenerosEspetaculos: Não existe Gênero com esse código: "+ codGenero );
        return retorno;
    }
}
