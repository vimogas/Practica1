/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;


import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author D3nGr
 */
public class Main {

    
    public static void main(String[] args) 
    {
        
        Scanner scanner = new Scanner(System.in);
        
        String opcion ;
        ArrayList<Moto> listaMotos ;
        ArrayList<Socio> listaSocios;
        ArrayList<Cesion> listaCesiones;
        
        listaMotos = InstanciaMotos();
        listaSocios = InstanciaSocios(listaMotos);
        listaCesiones = new ArrayList<>();
        
        float precio_max = 0;
        String precio;
        Boolean ok = false;
        
        do{
            
            try
            {
                ok = false;

                System.out.println("Introduce el valor límite de las motas por socio \n");
                precio = scanner.next();
                
                precio_max = Float.parseFloat(precio);
            }
            catch(Exception e)
            {
                System.err.println("Error: Valor inválido \n");
                ok = true;
            }

        }
        while (ok);
        while(true)
        {
        
            Menu();

            opcion = scanner.next();

            switch(opcion)
            {
                case "1" : // Registrar un nuevo socio
                    
                    listaSocios.add(RegistraSocio());

                    break;
                case "2" : // Registrar nueva moto

                    listaMotos.add(RegistroMoto(listaSocios, precio_max));

                    break;                
                case "3" : // Registrar cesión
                   
                    listaCesiones.add(RegistroCesion(listaSocios, precio_max));
                      
                    break;
                 case "4" : // Lista de miembros con motos
                     
                     MuestraSocios(listaSocios,0);
                     
                    break;               
                 case "5" : // Lista de todas las motos

                     MuestraMotos(listaMotos); 

                    break;                        
                 case "6" : // Cesiones realizadas 
                     
                     MuestraCesiones(listaCesiones);
                     
                    break;   
                 case "7" : // Incrementar gastos
                     
                     IncrementaGastos(listaMotos);
                     
                    break;
                 case "8" : // Eliminar miembro
                     
                     EliminaSocio(listaSocios, listaCesiones, precio_max);                     
                    
                     break;                     
                 case "9" : // Salir del programa
                     
                     crearFichero(listaSocios,listaCesiones);
                     System.exit(0);

                    break;        
                 default:
                     
                     System.err.println("Error: Entrada no identificada");
                     
                     break;
            }
        
        }
    
    }
    
    public static ArrayList<Moto> InstanciaMotos()
    {
        ArrayList<Moto> listaMotos = new ArrayList<>();
        
        listaMotos.add(new Moto("Vespa","primavera",125,2500,200,"1234ASD"));
        listaMotos.add(new Moto("Motobenae","Poney AG",70,2300,100,"4567QWE"));
        listaMotos.add(new Moto("Bultaco","",200,1200,300,"7542ERT"));
        listaMotos.add(new Moto("Guzzi","Cardelino 73", 75,1200,200,"4256JKL"));
        listaMotos.add(new Moto("Ducati","mini",49,4000,350,"7541FGH"));
        
        return listaMotos ;
    }
    
    public static ArrayList<Socio> InstanciaSocios(ArrayList<Moto> listaMotos)
    {
       ArrayList<Socio> listaSocios = new ArrayList<>() ; 
       
       listaSocios.add(new Socio("Carlos"));
       listaSocios.add(new Socio("Juan"));
       listaSocios.add(new Socio("Pepe"));
       listaSocios.add(new Socio("Manolo"));
       
       for(int i = 0 ; i < listaSocios.size(); i++)
       {
           
           listaSocios.get(i).setMoto(listaMotos.get(i));
           
           
       }
       listaSocios.get(2).setMoto(listaMotos.get(4));
        
       return  listaSocios;
    }
    
   
    
    public static void MuestraMotos(ArrayList<Moto> listaMotos)
    {
        for(Moto m : listaMotos)
           System.out.print(m.toString());
       
    }
    
    public static void MuestraSocios(ArrayList<Socio> listaSocio, int opcion)
    {
        if(opcion == 0)
        {    
            for(Socio s : listaSocio)
            {
                if(s.getNumMotos() > 0)
                {   
                    System.out.print(s.toString());
                    MuestraMotos(s.getMotos());
                }
            }
        }
        else if(opcion == 1)
            for(Socio s : listaSocio)
                System.out.print(s.toString());
        else
            for(Socio s : listaSocio)
            {
                if(s.getNumMotos() > 0)
                {   
                    System.out.print(s.toString());
                    
                }
            }
            
                
    }
    
    public static void MuestraCesiones(ArrayList<Cesion> listaCesiones)
    {
        for(Cesion c : listaCesiones)
        {
            System.out.print(c.toString());
            
        }
    }
    
    
    public static void Menu()
    {
        System.out.print("ACAMA CLUB: \n"+
                         " Pulsa... \n"+
                         "   1. Registrar un nuevo miembro \n"+
                         "   2. Registrar una nueva motocicleta \n"+
                         "   3. Registrar una cesión \n"+
                         "   4. Listar en pantalla los miembros con motos en posesión \n"+
                         "   5. Listar todas las motos \n"+
                         "   6. Mostrar las cesiones realizadas \n"+
                         "   7. Incrementar otros gastos de una motocicleta \n"+
                         "   8. Elimina un socio \n"+
                         "   9. Salir del programa \n");
        
        System.out.print("Opcion: ");
        
   }
    
   public static Socio RegistraSocio()
   {
       Scanner s = new Scanner(System.in);
       Socio so;
       String nombre ;
       
       System.out.print("Registrando socio: \n"+
                        "  Introduce los siguientes datos... \n");
       System.out.println("Nombre:");
       
       nombre = s.next();
      
       so = new Socio(nombre);
       
       return so ;
   }
    
    
   public static Moto RegistroMoto(ArrayList<Socio> listaSocios, float precio_max)
   {
       Moto m = new Moto() ;
       String cad;
       Boolean ok = true;
       int id = 1000;
       int i = 0 ;
       
       Scanner s = new Scanner(System.in);
       
       
       System.out.print("Registrando moto: \n"+
                        "  Introduce los siguientes datos... \n");
       
       System.out.print("Marca:");
       m.setMarca(s.next());
       
       System.out.print("Modelo:");
       m.setModelo(s.next());
       do
       {
            try
            {
                 System.out.print("Cilindrada:");
                 cad = s.next();
                 m.setCilindrada(Integer.parseInt(cad));
                 
                 ok = false;
            }
            catch(Exception e)
            {
                System.err.println("Cilindrada no valida"); 
            }
       }
       while(ok);
       
       ok = true;
       
       do
       {
            try
            {
                 System.out.print("Precio:");
                 cad = s.next();
                 m.setCoste(Float.parseFloat(cad));
                 ok = false;
            }
            catch(Exception e)
            {
                System.err.println("Precio incorrecto");
            }
       }
       while(ok);
       
       System.out.print("Matricula:");
       m.setMatricula(s.next());
       
       do
       {
           ok = false;
            MuestraSocios(listaSocios,1);
             do
            {
                try
                {
                     System.out.print("Introduce id del socio que recibe: ");
                     cad = s.next();
                     id = Integer.parseInt(cad);
                }
                catch(Exception e)
                {
                    System.err.println("Entrada Incorrecta");
                }
            }
            while(id > listaSocios.size());

            for(int j = 0 ; j < listaSocios.size();j++)
                if(listaSocios.get(j).getID() == id)
                    i = j ;
            
            if((listaSocios.get(i).getImporte()+ m.getCoste()) > precio_max)
            {
                ok = true;
                System.err.println("Error: El Socio  "+ listaSocios.get(i).getID()+" no puede adquir la moto");
            }
       }
       while(ok);
       
       listaSocios.get(i).setMoto(m);
       
       return m ;
   }
   public static Cesion RegistroCesion(ArrayList<Socio> listaSocios, float precio_max)
   {
       Cesion c ;
       int id1 = 1000, id2 = 1000 ;
       int x = 100, y = 100 , z = 100  ;
       Boolean ok = false;
       String matricula, cad ;
       Scanner scanner = new Scanner(System.in);
       
       // Obtenemos el Socio que cede
       
       System.out.print("Registro de cesión... \n");
       MuestraSocios(listaSocios,3);
       do
        {
             try
             {
                System.out.print("Introduce id del socio que cede: ");
                
                cad = scanner.next();
                id1 = Integer.parseInt(cad);
             }
             catch(Exception e)
             {
                 System.err.println("Entrada incorrecta");
             }
        }  
        while(id1 > listaSocios.size());

       // Buscamos el socio dentro de listaSocios
        for(int i = 0 ; i < listaSocios.size();i++)
            if(listaSocios.get(i).getID() == id1)
                x = i ;
      
       
       // Obtenemos la moto del socio que cede
        
       MuestraMotos(listaSocios.get(x).getMotos());
       
       do
       {    
            System.out.print("\n\nIntroduce la matricula de la moto a ceder: ");
            matricula = scanner.next();
            matricula = matricula.toUpperCase();

            for(int i = 0 ; i < listaSocios.get(x).getMotos().size(); i++)
                if(listaSocios.get(x).getMotos().get(i).getMatricula().equals(matricula))
                    y = i ;
       }
       while(y == 100);
       
       
       // Obtenemos el socio que recibe 
        do
        {
            ok = false;
            MuestraSocios(listaSocios,1);
            do
            {
                  try
                  {
                     System.out.print("Introduce id del socio que recibe: ");
                     cad = scanner.next();
                     id2 = Integer.parseInt(cad);
                  }
                  catch(Exception e)
                  {
                      System.err.println("Entrada Incorrecta");
                  }
            }
            while(id2 > listaSocios.size());

            for(int i = 0 ; i < listaSocios.size();i++)
                if(listaSocios.get(i).getID() == id2)
                    z = i ;
            
            if((listaSocios.get(z).getImporte()+ listaSocios.get(x).getMotos().get(y).getCoste()) > precio_max)
            {
                ok = true;
                System.err.println("Error: El socio excede el coste");
            }
        }
        while(ok);
       // Se crea la cesion
       
       c = new Cesion(listaSocios.get(x),listaSocios.get(z),listaSocios.get(x).getMotos().get(y));
       
       listaSocios.get(z).setMoto(listaSocios.get(x).getMotos().get(y));
       listaSocios.get(x).removeMoto(y);
       
       
       return c ;
   }
   
   
   public static void crearFichero(ArrayList<Socio> listaSocios,ArrayList<Cesion> listaCesiones)
   {
       FileWriter fichero = null;
       
       Scanner scanner = new Scanner(System.in);
       String nombre = "";
       
       System.out.print("Introduce el nombre del fichero: ");
       nombre = scanner.next();
       int i = 0 ;
       
	try {
                
		fichero = new FileWriter(nombre+".txt");

                for(Socio s : listaSocios)
                {
                    if(s.getNumMotos() > 0)
                    {   
                        fichero.write(s.toString()+"\n");
                        for(Moto m : listaSocios.get(i).getMotos())
                             fichero.write(m.toString()+"\n");
                    }
                    i++;
                }
                fichero.write("----Cesiones----"+"\n");
                for(Cesion c : listaCesiones)
                {
                    fichero.write(c.toString()+"\n");
                }
                
		fichero.close();

	} 
        catch (Exception ex) {
		System.out.println("Mensaje de la excepción: " + ex.getMessage());
	}
       
   }
   public static void IncrementaGastos(ArrayList <Moto> listaMotos){
       
       float gastos = 0;
       Scanner scanner = new Scanner(System.in);
       int y = 100;
       String matricula, gas;
       Boolean ok = false;
       
       MuestraMotos(listaMotos);
       
       do
       {    
            System.out.print("\n\nIntroduce la matricula de la moto a añadir gastos: ");
            matricula = scanner.next();
            matricula = matricula.toUpperCase();

            for(int i = 0 ; i < listaMotos.size(); i++)
                if(listaMotos.get(i).getMatricula().equals(matricula))
                    y = i ;
       }
       while(y == 100);
       
       do
       {
           ok = false;
           
           try 
           {
                System.out.println("Introduce los gastos a añadir");
                gas = scanner.next();
                
                gastos = Float.parseFloat(gas);
                
           } catch (Exception e)
           {
               ok = true;
               System.err.println("Error: Valor incorrecto \n");
           }
       }
       while (ok);
       
       listaMotos.get(y).setGastos(gastos);
      
   }
   
   public static void EliminaSocio(ArrayList<Socio> listaSocios, ArrayList<Cesion> listaCesiones, float precio_max)
   {
       Cesion c;
       int id1 = 1000, id2 = 1000 ;
       int x = 100, y = 100 , z = 100  ;
       Boolean ok = false;
       String matricula, cad ;
       Scanner scanner = new Scanner(System.in);
       
       //Obtenemos el socio que deseamos eliminar
       
       System.out.print("Elimina un miembro... \n");
       MuestraSocios(listaSocios,3);
       do
       {
            try
            {
               System.out.print("Introduce id del socio que desea abandonar la asociacion: ");
               
               cad = scanner.next();
               id1 = Integer.parseInt(cad);
            }
            catch(Exception e)
            {
                System.err.println("Entrada incorrecta");
            }
        }  
        while(id1 > listaSocios.size());
       
        // Buscamos el socio dentro de listaSocios
        for(int i = 0 ; i < listaSocios.size();i++)
            if(listaSocios.get(i).getID() == id1)
                x = i ;
       
        // Obtenemos la moto del socio que cede
        
        for(int k = 0 ; k <= listaSocios.get(x).getNumMotos(); k++)
        {  
            MuestraMotos(listaSocios.get(x).getMotos());
        
        
            do
            {    
                System.out.print("\n\nIntroduce la matricula de la moto a ceder: ");
                matricula = scanner.next();
                matricula = matricula.toUpperCase();

                for(int i = 0 ; i < listaSocios.get(x).getMotos().size(); i++)
                    if(listaSocios.get(x).getMotos().get(i).getMatricula().equals(matricula))
                        y = i ;
            }
            while(y == 100);
       
            // Obtenemos el socio que recibe   
            do
            {
                ok = false;
                MuestraSocios(listaSocios,1);
                do
                {
                    try
                    {
                        System.out.print("Introduce id del socio que recibe la moto: ");
                        cad = scanner.next();
                        id2 = Integer.parseInt(cad);
                    }
                    catch(Exception e)
                    {
                        System.err.println("Entrada Incorrecta");
                    }
                }
                while(id2 > listaSocios.size());

                for(int j = 0 ; j < listaSocios.size();j++)
                    if(listaSocios.get(j).getID() == id2)
                        z = j ;

                if((listaSocios.get(z).getImporte()+ listaSocios.get(x).getMotos().get(y).getCoste()+ listaSocios.get(x).getMotos().get(y).getGastos()) > precio_max)
                {
                    ok = true;
                    System.err.println("Error: El socio excede el coste");
                }
            }
            while(ok);

            // Se crea la cesion

            c = new Cesion(listaSocios.get(x),listaSocios.get(z),listaSocios.get(x).getMotos().get(y));
            
            listaSocios.get(z).setMoto(listaSocios.get(x).getMotos().get(y));
            listaSocios.get(x).removeMoto(y);

            listaCesiones.add(c);
        }
        //Se elimina el socio
	   
        listaSocios.remove(x);
   }
   
}