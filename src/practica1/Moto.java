/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author D3nGr
 */
public class Moto 
{
    
    private String marca ;
    private String modelo ;
    private int cilindrada ;
    private float coste ;
    private String matricula;
    
    public Moto(String ma , String mo, int ci , float co, String matri )
    {
        
        marca = ma ;
        modelo = mo ;
        cilindrada = ci ;
        coste = co ;
        matricula = matri ;
        
    }
    
    public Moto(){}
    
    @Override
    public String toString()
    {
        String c;
        
        c = " ----------------------------- \n"+
              "| "+marca +"  " + modelo +"\n| \n"+
              "| "+cilindrada+" CC"+"\n| \n"+
             "| "+ coste + " €" + "\n|\n"+
             "| "+ matricula + "\n" +
            " ----------------------------- \n";
        
        return c ;
    }
    
    // setters
    
    public void setMarca(String ma)
    {
        marca = ma;
    }
    public void setModelo(String mo)
    {
        modelo = mo ;
    }
    public void setCilindrada(int ci)
    {
        cilindrada = ci ;
    }
    
    public void setCoste(float co)
    {
        coste = co ;
    }
    
    public void setMatricula(String matri)
    {
        matricula = matri ;
    }
    
    // getters
    
    public String getMarca()
    {
        return marca ;
    }
    
    public String getModelo()
    {
        return modelo ;
    }
    public int getCilindrada()
    {
        return cilindrada ;
    }
    public float getCoste()
    {
        return coste ;
    }
    public String getMatricula()
    {
        return matricula ;
        
    }
}
