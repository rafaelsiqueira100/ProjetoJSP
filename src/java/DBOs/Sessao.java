package DBOs;

import java.sql.Timestamp;
import java.util.Objects;
import DAOs.DAOs;
import java.util.logging.Level;
import java.util.logging.Logger;
import DBOs.Espetaculo;
public class Sessao{
	private int codSessao;
	private int codEspetaculo;
	private int codTeatro;
	private Timestamp dataHorario;

	public Sessao(int codS, int codE, int codT, Timestamp dataH){
		this.codSessao = codS;
		this.codEspetaculo = codE;
		this.codTeatro = codTeatro;
		this.dataHorario = dataH;
	
	}

	public int getCodSessao() {
        return codSessao;
    }

    public int getCodEspetaculo() {
        return codEspetaculo;
    }

    public int getCodTeatro() {
        return codTeatro;
    }

    public Timestamp getDataHorario() {
        return dataHorario;
    }

    public void setCodSessao(int codSessao) {
        this.codSessao = codSessao;
    }

    public void setCodEspetaculo(int codEspetaculo) {
        this.codEspetaculo = codEspetaculo;
    }

    public void setCodTeatro(int codTeatro) {
        this.codTeatro = codTeatro;
    }

    public void setDataHorario(Timestamp dataHorario) {
        this.dataHorario = dataHorario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.codSessao;
        hash = 79 * hash + this.codEspetaculo;
        hash = 79 * hash + this.codTeatro;
        hash = 79 * hash + Objects.hashCode(this.dataHorario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sessao other = (Sessao) obj;
        if (this.codSessao != other.codSessao) {
            return false;
        }
        if (this.codEspetaculo != other.codEspetaculo) {
            return false;
        }
        if (this.codTeatro != other.codTeatro) {
            return false;
        }
        return Objects.equals(this.dataHorario, other.dataHorario);
    }
/*
private int codSessao;
	private int codEspetaculo;
	private int codTeatro;
	private Timestamp dataHorario;
*/
    @Override
    public String toString() {
        /*        Espetaculo espetaculoRelacionado = null;
            try {
                espetaculoRelacionado = DAOs.getTabelaEspetaculos().getEspetaculo(this.getCodEspetaculo());
            } catch (Exception ex) {
                Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
            }
        String resultado = Integer.toString(codEspetaculo)+ " - "+ espetaculoRelacionado.getNome() + '\r'+'\n'+"Gênero:"+DAOs.getTabelaGenerosEspetaculos().selecionaGenero(espetaculoRelacionado.getCodGenero()).getNomeGenero()+'\r'+'\n'+"Duração: " + espetaculoRelacionado.getDuracao() + " minutos"+'\r'+'\n'+"Sinopse: " + espetaculoRelacionado.getSinopse() + '\r'+'\n'+"Direção: " + espetaculoRelacionado.getDirecao() + '\r'+'\n'+"Idioma: " + espetaculoRelacionado.getIdioma() + '\r'+ '\n';
        
		if(espetaculoRelacionado.cens == null)
			resultado += "Classificação: Livre para todos os públicos.";
		else	
			resultado += "Classificação: Não recomendado para menores de "+ espetaculoRelacionado..toString()+" anos.";
	return resultado;	
         	*/
               return "a";
    }

}