/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOs;

/**
 *
 * @author u16191
 */
public class Assento {
    private int codAssento;
    private int codSetor;
    public Assento(int codA, int codS){
        this.codAssento = codA;
        this.codSetor = codS;
    }
    
     public int getCodAssento() {
        return codAssento;
    }

    public void setCodAssento(int codAssento) {
        this.codAssento = codAssento;
    }

    public int getCodSetor() {
        return codSetor;
    }

    public void setCodSetor(int codSetor) {
        this.codSetor = codSetor;
    }
    @Override
    public String toString() {
        return "Assento{" + "codAssento=" + codAssento + ", codSetor=" + codSetor + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.codAssento;
        hash = 71 * hash + this.codSetor;
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
        final Assento other = (Assento) obj;
        if (this.codAssento != other.codAssento) {
            return false;
        }
        if (this.codSetor != other.codSetor) {
            return false;
        }
        return true;
    } 
}
