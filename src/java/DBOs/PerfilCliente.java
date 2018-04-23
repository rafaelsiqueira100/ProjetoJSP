package DAOs;

import java.util.Objects;

/**
 *
 * @author u15185
 */
public class PerfilCliente {
    private int codPerfil;
    private String descricao;
    private int percentualDesconto;

    public PerfilCliente(int codPerfil, String descricao, int percentualDesconto) {
        this.codPerfil = codPerfil;
        this.descricao = descricao;
        this.percentualDesconto = percentualDesconto;
    }

    public int getCodPerfil() {
        return codPerfil;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setCodPerfil(int codPerfil) {
        this.codPerfil = codPerfil;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPercentualDesconto(int percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.codPerfil;
        hash = 23 * hash + Objects.hashCode(this.descricao);
        hash = 23 * hash + this.percentualDesconto;
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
        final PerfilCliente other = (PerfilCliente) obj;
        if (this.codPerfil != other.codPerfil) {
            return false;
        }
        if (this.percentualDesconto != other.percentualDesconto) {
            return false;
        }
        return Objects.equals(this.descricao, other.descricao);
    }

    @Override
    public String toString() {
        return "PerfilCliente{" + "codPerfil=" + codPerfil + ", descricao=" + descricao + ", percentualDesconto=" + percentualDesconto + '}';
    }
}
