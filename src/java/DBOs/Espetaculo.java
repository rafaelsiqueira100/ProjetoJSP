package DBOs;

import DAOs.DAOs;
import java.util.Objects;
public class Espetaculo{

	private int codEspetaculo;
	private String nome;
	private int codGenero;
	private int duracao;
	private String sinopse;
	private Integer censura;
	private String direcao;
	private String idioma;
	//private static List<>

	public Espetaculo(int cod, String nom, int codGen, int dur, String sin, Integer cens, String dir, String idiom){
		this.codEspetaculo = cod;
		this.nome = nom;
		this.codGenero = codGen;
		this.duracao = dur;
		this.sinopse = sin;
		this.censura = cens;
		this.direcao = dir;
		this.idioma  = idiom;
	}
        @Override
	public String toString(){
		
		//String resultado = Integer.toString(this.codEspetaculo) + " - "+ this.nome + '\r'+'\n'+"G�nero:"+DAOs.getTabelaGenerosEspetaculos().selecionaGenero(this.codGenero).getNomeGenero()+'\r'+'\n'+"Dura��o: " + Integer.toString(this.duracao) + " minutos"+'\r'+'\n'+"Sinopse: " + this.sinopse + '\r'+'\n'+"Dire��o: " + this.direcao + '\r'+'\n'+"Idioma: " + this.idioma + '\r'+ '\n';
		//if(this.censura == null)
		//	resultado += "Classifica��o: Livre para todos os p�blicos.";
		//else	
		//	resultado += "Classifica��o: N�o recomendado para menores de "+ this.censura.toString()+" anos.";
		//return resultado;
                return null;
	}
	 public int getCodEspetaculo() {
        	return codEspetaculo;
    	}

    	public String getNome() {
    	    return nome;
    	}
	
   	 public int getCodGenero() {
   	     return codGenero;
   	 }
	
   	 public int getDuracao() {
    	    return duracao;
   	 }

   	 public String getSinopse() {
   	     return sinopse;
    	}
	
    	public int getCensura() {
    	    return censura;
    		}

   	public String getDirecao() {
    	    return direcao;
   	 }

    	public String getIdioma() {
    	    return idioma;
   	 }
public void setCodEspetaculo(int codEspetaculo) {
        this.codEspetaculo = codEspetaculo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodGenero(int codGenero) {
        this.codGenero = codGenero;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setCensura(int censura) {
        this.censura = censura;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.codEspetaculo;
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + this.codGenero;
        hash = 47 * hash + this.duracao;
        hash = 47 * hash + Objects.hashCode(this.sinopse);
        hash = 47 * hash + this.censura;
        hash = 47 * hash + Objects.hashCode(this.direcao);
        hash = 47 * hash + Objects.hashCode(this.idioma);
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
        final Espetaculo other = (Espetaculo) obj;
        if (this.codEspetaculo != other.codEspetaculo) {
            return false;
        }
        if (this.codGenero != other.codGenero) {
            return false;
        }
        if (this.duracao != other.duracao) {
            return false;
        }
        if (this.censura != other.censura) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sinopse, other.sinopse)) {
            return false;
        }
        if (!Objects.equals(this.direcao, other.direcao)) {
            return false;
        }
        return Objects.equals(this.idioma, other.idioma);
    }

}