package DBOs;

/**
 *
 * @author u15185
 */
public class Poltrona {
    private int codPoltrona;
    private int fileira;
    private char letra;
    private boolean situacao;
    private int codSetor;
    public Poltrona(int codPoltrona, int fileira, char letra, boolean situacao, int codSetor) {
        this.codPoltrona = codPoltrona;
        this.fileira = fileira;
        this.letra = letra;
        this.situacao = situacao;
        this.codSetor = codSetor;
    }

    public int getCodPoltrona() {
        return codPoltrona;
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
        this.codPoltrona = idPoltrona;
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
    public int getCodSetor(){
        return this.codSetor;
    }
    public void setCodSetor(int codS){
        this.codSetor = codS;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.codPoltrona;
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
        if (this.codPoltrona != other.codPoltrona) {
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
        return "Poltrona{" + "idPoltrona=" + codPoltrona + ", fileira=" + fileira + ", letra=" + letra + ", situacao=" + situacao + '}';
    }    
}
