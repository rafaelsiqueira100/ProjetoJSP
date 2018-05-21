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
public class Ingresso {
    private int codIngresso;
    private int codAssento;
    private String usuario;
    private double preco;
    private boolean inteira;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.codIngresso;
        hash = 89 * hash + this.codAssento;
        hash = 89 * hash + Objects.hashCode(this.usuario);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        hash = 89 * hash + (this.inteira ? 1 : 0);
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
        final Ingresso other = (Ingresso) obj;
        if (this.codIngresso != other.codIngresso) {
            return false;
        }
        if (this.codAssento != other.codAssento) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (this.inteira != other.inteira) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
    
    public int getCodIngresso() {
        return codIngresso;
    }

    public void setCodIngresso(int codIngresso) {
        this.codIngresso = codIngresso;
    }

    public int getCodAssento() {
        return codAssento;
    }

    public void setCodAssento(int codAssento) {
        this.codAssento = codAssento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isInteira() {
        return inteira;
    }

    public void setInteira(boolean inteira) {
        this.inteira = inteira;
    }
   
    
}
