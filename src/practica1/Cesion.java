/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author alumno
 */
public class Cesion 
{
    private Socio cede , recibe;
    private Moto moto ;
    
    public Cesion(Socio c , Socio r , Moto m)
    {
        cede = c ;
        recibe = r ;
        moto = m ;
        
    }
    
    
    @Override
    public String toString()
    {
        String c = "Cesión: \n"
                +  "    Cede:\n"
                +  "     " + cede.toString()
                +  "    Recibe: \n"
                +  "     " + recibe.toString()
                +  "    Moto: \n "
                +   moto.toString();
        return c ;
    }
    
}
