/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOs;

import java.util.Objects;

/**
 *
 * @author u16191
 */
public class Setor {

    public int getCodSetor() {
        return codSetor;
    }

    public void setCodSetor(int codSetor) {
        this.codSetor = codSetor;
    }

    public int getCodTeatro() {
        return codTeatro;
    }

    public void setCodTeatro(int codTeatro) {
        this.codTeatro = codTeatro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    private int codSetor;
    private int codTeatro;
    private String nome;
    
    public Setor(int codS, int codT, String nome){
        this.nome = nome;
        this.codSetor = codS;
        this.codTeatro = codT;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.codSetor;
        hash = 13 * hash + this.codTeatro;
        hash = 13 * hash + Objects.hashCode(this.nome);
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
        final Setor other = (Setor) obj;
        if (this.codSetor != other.codSetor) {
            return false;
        }
        if (this.codTeatro != other.codTeatro) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
}
