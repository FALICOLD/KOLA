/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Isaias_Lavalle;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

abstract class  Inventario{

   public String Producto;
   public int Cantidad;
   public double Precio;
   public double IVA;
   public double SIVA;
   public int Cantidad_C;
   public boolean Venta;

    public boolean isVenta() {
        return Venta;
    }

    public void setVenta(boolean Venta) {
        this.Venta = Venta;
    }
    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public double getSIVA() {
        return SIVA;
    }

    public void setSIVA(double SIVA) {
        this.SIVA = SIVA;
    }

    public int getCantidad_C() {
        return Cantidad_C;
    }

    public void setCantidad_C(int Cantidad_C) {
        this.Cantidad_C = Cantidad_C;
    }
   
   
  protected abstract double IVA(double a);
  protected abstract double DDescuentos(double P, double D); 
  protected abstract double SDescuentos(double P, double S); 
  
      
  
      


   
   

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
}

