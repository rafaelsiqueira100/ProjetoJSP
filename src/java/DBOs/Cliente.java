package DBOs;
import java.util.Date;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author u16191
 */
public class Cliente {
    private String usuario;
    private String senha;            
    private int codPerfil;   
    private String celular;
    private String cpf;
    private String rg;
    private String nome;
    private Date dataNasc;
    private String email;


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        if(usuario == null || usuario.equals(""))
            throw new IllegalArgumentException();
        this.usuario = usuario;
        
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if(senha == null || senha.equals(""))
            throw new IllegalArgumentException();
        this.senha = senha;
    }

    public int getCodPerfil() {
        return this.codPerfil;
    }

    public void setCodPerfil(int codPerfil) {
        if(codPerfil<1)
            throw new IllegalArgumentException();
        this.codPerfil = codPerfil;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(cpf == null || cpf.equals(""))
            throw new IllegalArgumentException();
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        if(rg == null || rg.equals(""))
            throw new IllegalArgumentException();
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null || nome.equals(""))
            throw new IllegalArgumentException();
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        Date hoje = new Date((System.currentTimeMillis()));
        Date dataNova = (Date)dataNasc.clone();
        if(dataNasc==null || dataNova.compareTo(hoje)>=0)
            throw new IllegalArgumentException();
        this.dataNasc= dataNova;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email == null || email.equals(""))
            throw new IllegalArgumentException();
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        if(celular == null || celular.equals(""))
            throw new IllegalArgumentException();
        this.celular = celular;
    }
    public Cliente(String usuario, String senha, int codPerfil, String cpf, String rg, String nome, Date dataNasc, String email, String celular)throws IllegalArgumentException{
        this.usuario = usuario;
        this.celular = celular;
        this.senha = senha;
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.email = email;
        this.dataNasc = dataNasc;
        this.codPerfil = codPerfil;
    }
    
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.dataNasc, other.dataNasc)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.celular, other.celular);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.usuario);
        hash = 83 * hash + Objects.hashCode(this.senha);
        hash = 83 * hash + Objects.hashCode(this.cpf);
        hash = 83 * hash + Objects.hashCode(this.rg);
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.dataNasc);
        hash = 83 * hash + Objects.hashCode(this.email);
        hash = 83 * hash + Objects.hashCode(this.celular);
        return hash;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "usuario=" + usuario + ", senha=" + senha + ", cpf=" + cpf + ", rg=" + rg + ", nome=" + nome + ", dataNascimento=" + dataNasc + ", email=" + email + ", celular=" + celular + '}';
    }

}
