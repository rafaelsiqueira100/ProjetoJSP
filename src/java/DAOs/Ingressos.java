/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import DBOs.Ingresso;
import java.sql.SQLException;

/**
 *
 * @author u16191
 */
public class Ingressos extends Dao {
    public Ingressos() throws Exception{
        super();
    }
    public boolean insereIngresso(Ingresso ing){
     try {
            String command = "INSERT INTO Ingresso VALUES (?,?,?,?)";
            this.getBd().prepareStatement(command);
            
            this.getBd().setString(1, ing.getUsuario());
            this.getBd().setInt(2, ing.getCodAssento());
            this.getBd().setDouble(3, ing.getPreco());
            this.getBd().setBoolean(4, ing.isInteira());
            this.getBd().executeQuery();
        } catch (SQLException e) {
            //System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
}
