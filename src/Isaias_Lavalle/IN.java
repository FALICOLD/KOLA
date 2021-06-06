/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Isaias_Lavalle;

import java.io.FileWriter;
import java.util.Scanner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author FALI
 */



public class IN extends Inventario{
    
public IN(){
    this.Producto="";
    this.Cantidad=0;
    this.Precio=0.0; 
    this.IVA=0.0;
    this.Cantidad_C=0;
    this.SIVA=0.0;
    this.Venta=false;
    
}
    private void Alta_Venta(){
         Scanner Entrada = new Scanner (System.in);
        IN in = new IN(); 
       IN I[] = new IN [100];
      
       int c=0, i=0, N=0, OP=0, CP=0, CR=0, D=0, B=0, op=0, Op=0, n=0; 
       double PT=0, IVA=0, T=0;
       
       n=I.length;
      try{ 
            for(i=0; i<n; i++){   
                    I[i] = new IN();
                   
                    System.out.println("Ingrese el nombre del producto");
                    String P=Entrada.nextLine();

                    System.out.println("Ingrese la cantidad disponible");
                    int C=Entrada.nextInt();

                    System.out.println("Ingrese el precio del producto");
                    double PR=Entrada.nextDouble();

                    I[i].setProducto(P);
                    I[i].setCantidad(C);
                    I[i].setPrecio(PR);
                    try{
                        System.out.println("¿Agregar otro producto? 1-Si 2-No");
                        c=Entrada.nextInt();
                        P=Entrada.nextLine();
                       do{ 
                        if(c>2){
                            System.out.println("Ingrese solamente 1 o 2 correspondiente a su decisión"); 
                            c=Entrada.nextInt();
                        }    
                       }while(c>2);
                    }
                     catch (java.util.InputMismatchException ex){
                            System.out.println("No ingrese texto"); 
                     }
                    N++;
               
               
                if (c==2){
                    break;
                }    
            }
            
     
     
       System.out.println("Iniciando ventas...");
      do{ 
       System.out.println("Articulos  Disponibles");
      
        for (int J=0;J<N; J++){   
        System.out.println(J+"-"+"Producto = "+I[J].getProducto()+" Cantidad= "+I[J].getCantidad()+" Precio= "+I[J].getPrecio()  ); 
        }
       
       do{
        System.out.println("Seleccione el articulo a vender (Si no realizara ventas, presione una letra)");
         OP=Entrada.nextInt();
         if(I[OP].getCantidad()==0){
             System.out.println("Este articulo no tiene disponibilidad");
             B=1;
         }
         if(I[OP].getCantidad()!=0){
             B=0;
         }
       }while(B==1);
       
       I[OP].setVenta(true);
       
        System.out.println("Ingrese la cantidad de productos  a vender " );
        CP=Entrada.nextInt();
        
     
       
       if(CP>I[OP].getCantidad()){
          CR=0;
          I[OP].setCantidad(CR);
       }
       I[OP].setCantidad_C(I[OP].getCantidad_C()+CP);
       
       PT=I[OP].getPrecio()*CP;
       if (CP>I[OP].getCantidad()){
           I[OP].setCantidad(0);
           
       }else{
           CR=I[OP].getCantidad()-CP;
       }
        
       I[OP].setCantidad(CR);
       try{
           do{
                System.out.println("¿Cuánto tiempo tiene el producto almacenado? (1-Días, 2-Semanas)");
                 T=Entrada.nextInt();
           }while(T>3);     
       }
       catch(Exception ex){
           
           
       }
        if(T==1){
           try{
                System.out.println("¿Cuántos días tiene el producto almacenado (Ingresar de 1 a 6 días)");
                D=Entrada.nextInt();
                do{
                    if(D>6){
                        System.out.println("No ingrese mas de 6 días");  
                        D=Entrada.nextInt();
                    }
                }while(D>6);
                
                double DD=in.DDescuentos(PT, D);
                 IVA=in.IVA(DD);
                PT=in.DDescuentos(PT, D);
                I[OP].setIVA(I[OP].getIVA()+IVA);
                I[OP].setSIVA(I[OP].getSIVA()+PT);
                
                
           }
           catch(Exception ex){
               
           }
        }
         
        if(T==2){
           try{
                System.out.println("¿Cuántas semanas tiene el producto almacenado?");
                D=Entrada.nextInt();
               double DS=in.SDescuentos(PT, D);
                IVA=in.IVA(DS);
                PT=in.SDescuentos(PT, D);
                 I[OP].setIVA(I[OP].getIVA()+IVA);
                I[OP].setSIVA(I[OP].getSIVA()+PT);
                
           }
           catch(Exception ex){
               
           }
           
           
        }
        
        System.out.println("¡Producto vendido!");
       
        
        
       
            
        
        
       try{
            System.out.println("¿Vender otro producto? (1-Si o 2-No)");
            op=Entrada.nextInt();
            
       }
       catch(Exception ex){
           System.out.println("No introduzca letras/simbolos");
       }
       
        if (op==2){
                System.out.println("¿Facturar las ventas? (1-Si o 2-No)");
                Op=Entrada.nextInt();
                if (Op==1){
                    in.Guardar(I);
                }else{
                        
                }
                  
        }
             
      
      do{
          if(OP>3){
              System.out.println("Ingrese solamente 1 o 2 correspondiente a su decisión");  
          }
      }while(OP>3);  
    
      }while(op==1); 
      in.Gráfico_Inventario(I);
      in.Gráfico_Ventas(I);
    }
       
     catch (java.util.InputMismatchException ex){
        System.out.println("Evite introducir cantidades mayores de 16"+"\n"+"No ingrese texto, Al menos que quiera  salir del programa"); 
        in.Gráfico_Inventario(I);
     } 
      
     
finally {
    System.out.println("Ha finalizado el programa");
        Entrada.close();
       
    }
   
     
     
}
    
    
    
    public void Guardar(IN I[]){
       String NL=System.getProperty("line.separator");
       FileWriter AR = null;
       
        
       
       
       try{
           AR= new FileWriter("Inventario.txt");
          for(IN R: I){
             for(int J=0; J<I.length; J++){
               if (I[J].isVenta()){
                    AR.write(I[J].getProducto()+NL+"Se compro "+I[J].getCantidad_C()+NL+"Pago con IVA $"+I[J].getIVA()+"MX"+NL+"Sin IVA $"+I[J].getSIVA()+"MX"+NL);
                    AR.write(" "+NL);
              }
           }
          
               
           }
           
               
       }
       catch(Exception ex){
           
       }
       
       System.out.println("¡Archivo guardado y generado!");
       try {
           if (null != AR)
               AR.close();
       } catch (Exception e2) {
           e2.printStackTrace();
       }
   
    } 
    
    protected double IVA(double a) {
       double V=a+(a*.16);
       return V;
    }

    
    protected double DDescuentos(double P, double D) {
      double DD= P-(D*(P*.02));
        
      return DD;
    }
    protected double SDescuentos(double P, double S) {
      double DS= P-(S*(P*.05));
        
      return DS;
    }
    
    private void  Gráfico_Inventario(IN I[]){
        
        
            try{
                DefaultCategoryDataset DS= new DefaultCategoryDataset();
      
                
                JFreeChart JF= ChartFactory.createBarChart3D("", "Inventario actual ", "", DS);
                ChartFrame CF=  new ChartFrame("Cantidad de productos actuales", JF);
                CF.setSize(600,400);
                CF.setLocationRelativeTo(null);
                CF.setVisible(true);
                       
                int R=I.length;
        
                
                for(int i=0;i<R; i++){
                 String P=I[i].getProducto();
                 int C=I[i].getCantidad();

                 DS.addValue(C, P, "");
                 
                } 
                
            }
            catch(Exception e){
                System.out.println("Se ha producido un error "+e);
            }
            
            
        }
      private void  Gráfico_Ventas(IN I[]){
         
        
            try{
                DefaultCategoryDataset DS= new DefaultCategoryDataset();
      
                
                JFreeChart JF= ChartFactory.createBarChart3D("", "Ventas de productos realizadas", "", DS);
                ChartFrame CF=  new ChartFrame("Cantidad de productos vendidos", JF);
                CF.setSize(600,400);
                CF.setLocationRelativeTo(null);
                CF.setVisible(true);
                       
                int R=I.length;
        
                
                for(int i=0;i<R; i++){
                 String P=I[i].getProducto();
                 int C=I[i].getCantidad_C();
                    
                 if (I[i].isVenta()){
                  DS.addValue(C, P, "");
                 }
                } 
            }
            catch(Exception e){
                System.out.println("Se ha producido un error "+e);
            }
        }
            
    public static void main(String[] args) {
      IN I = new IN();
      
      
      I.Alta_Venta();
      
      
      
        
        
    }

    public void IVA() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
   

   
    
    
}
