package DAOs;

/**
 *
 * @author u15185
 */
public class Poltrona {
    private int idPoltrona;
    private int fileira;
    private char letra;
    private boolean situacao;

    public Poltrona(int idPoltrona, int fileira, char letra, boolean situacao) {
        this.idPoltrona = idPoltrona;
        this.fileira = fileira;
        this.letra = letra;
        this.situacao = situacao;
    }

    public int getIdPoltrona() {
        return idPoltrona;
    }

    public int getFileira() {
        return fileira;
    }

    public char getLetra() {
        return letra;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setIdPoltrona(int idPoltrona) {
        this.idPoltrona = idPoltrona;
    }

    public void setFileira(int fileira) {
        this.fileira = fileira;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idPoltrona;
        hash = 79 * hash + this.fileira;
        hash = 79 * hash + this.letra;
        hash = 79 * hash + (this.situacao ? 1 : 0);
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
        final Poltrona other = (Poltrona) obj;
        if (this.idPoltrona != other.idPoltrona) {
            return false;
        }
        if (this.fileira != other.fileira) {
            return false;
        }
        if (this.letra != other.letra) {
            return false;
        }
        return this.situacao == other.situacao;
    }

    @Override
    public String toString() {
        return "Poltrona{" + "idPoltrona=" + idPoltrona + ", fileira=" + fileira + ", letra=" + letra + ", situacao=" + situacao + '}';
    }    
}
