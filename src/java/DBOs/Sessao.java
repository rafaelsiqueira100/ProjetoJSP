import java.sql.TimeSpan;
public class Sessao(){
	private int codSessao;
	private int codEspetaculo;
	private int codTeatro;
	private TimeSpan dataHorario;
	public Sessao(int codS, int codE, int codT, Timespan dataH){
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

    public TimeSpan getDataHorario() {
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

    public void setDataHorario(TimeSpan dataHorario) {
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

    @Override
    public String toString() {
        return "Sessao{" + "codSessao=" + codSessao + ", codEspetaculo=" + codEspetaculo + ", codTeatro=" + codTeatro + ", dataHorario=" + dataHorario.toString() + '}';
    }

}