package DBOs;

import java.util.Objects;

public class GeneroEspetaculo{
	private int codGenero;
	private String nome;
        
	public GeneroEspetaculo(int cod, String nom){
		this.codGenero = cod;
		this.nome = nom;	
	}
	
    public int getCodGenero() {
        return codGenero;
    }

    public String getNomeGenero() {
        return nome;
    }

    public void setCodGenero(int codGenero) {
        this.codGenero = codGenero;
    }

    public void setNomeGenero(String nomeGenero) {
        this.nome = nomeGenero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.codGenero;
        hash = 53 * hash + Objects.hashCode(this.nome);
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
        final GeneroEspetaculo other = (GeneroEspetaculo) obj;
        if (this.codGenero != other.codGenero) {
            return false;
        }
        return Objects.equals(this.nome, other.nome);
    }

    @Override
    public String toString() {
        return "GeneroEspetaculo{" + "codGenero=" + codGenero + ", nomeGenero=" + nome + '}';
    }
}