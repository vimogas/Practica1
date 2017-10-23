/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.ArrayList;


public class Socio 
{
    private int id_socio;
    private static int total = 1 ;
    private String nombre ;
    private  int numero_motos = 0 ; ;
    private float importe = 0  ;
    private ArrayList<Moto> motos = new ArrayList<>() ;
    
    public Socio(String nom)
    {
        nombre = nom ;
        
        id_socio = total ;
        total++;
        
    }
    
    @Override
    public String toString()
    {
        
        String c_id = String.format("%03d",id_socio);
        
        String c = c_id +"\t" + nombre + "\t" + numero_motos + "\t" + importe + "\n";
                          
         return c  ;
    }
    
    public void setNombre(String nom)
    {
        nombre = nom ;
    }
    
    public void setMoto(Moto m)
    {
        numero_motos++;
        
        importe += m.getCoste();
        
        motos.add(m);
       
    }
    public void removeMoto(int i)
    {
        numero_motos--;
        
        importe -= motos.get(i).getCoste();
        
        motos.remove(i);
        
    }
    public int getID()
    {
        return id_socio;
    }
    public String getNombre()
    {
        return nombre ;
    }
    public int getNumMotos()
    {
        return numero_motos ;   
    }
    public float getImporte()
    {
        return importe ;
    }
    public ArrayList<Moto> getMotos()
    {
        return motos;
    }
       
}
