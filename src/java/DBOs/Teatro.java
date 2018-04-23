package DAOs;

import java.util.Objects;

/**
 *
 * @author u15185
 */
public class Teatro {
    private int codTeatro;
    private String telefone;
    private String nome;
    private String endereco;

    public Teatro(int codTeatro, String telefone, String nome, String endereco) {
        this.codTeatro = codTeatro;
        this.telefone = telefone;
        this.nome = nome;
        this.endereco = endereco;
    }

    public int getCodTeatro() {
        return codTeatro;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setCodTeatro(int codTeatro) {
        this.codTeatro = codTeatro;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.codTeatro;
        hash = 71 * hash + Objects.hashCode(this.telefone);
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.endereco);
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
        final Teatro other = (Teatro) obj;
        if (this.codTeatro != other.codTeatro) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.endereco, other.endereco);
    }

    @Override
    public String toString() {
        return "Teatro{" + "codTeatro=" + codTeatro + ", telefone=" + telefone + ", nome=" + nome + ", endereco=" + endereco + '}';
    }
}
