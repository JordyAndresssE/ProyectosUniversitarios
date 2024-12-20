/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prototype;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebas
 */
public abstract class FiguraGeometrica implements Cloneable{
    private String tipoFigura;
    
    abstract void dibujar();
    
    String getTipo(){
        return tipoFigura;
    }

    public void setTipo(String tipoFigura) {
        this.tipoFigura = tipoFigura;
    }

    @Override
    protected FiguraGeometrica clone() throws CloneNotSupportedException {
        try {
            return (FiguraGeometrica) super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(FiguraGeometrica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    
    
}
