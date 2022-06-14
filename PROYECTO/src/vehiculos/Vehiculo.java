/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculos;

import interfaces.MuestraPedirDatos;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alox1
 */
public class Vehiculo implements MuestraPedirDatos, Serializable {
   private int cilindros;
   private String traccion;
   private String transmision;
   private int numVel;
   private String color;
   private String descripcion;
   private String marca;
   private String modelo;
   private int pasajeros;
   private double precio;
   private String placas;

    public Vehiculo() {
        Scanner input=new Scanner (System.in);
        System.out.println("Ingrese la marca del vehiculo");
        marca=input.next();
        System.out.println("Ingrese el modelo del vehiculo");
        modelo=input.next();
        System.out.println("Ingrese el color del vehiculo");
        color=input.next();
        System.out.println("Ingrese la cantidad de cilindros");
        cilindros=input.nextInt();
        System.out.println("Ingrese el numero de velocidades");
        numVel=input.nextInt();
        System.out.println("Ingrese la cantidad de pasajeros");
        pasajeros=input.nextInt();
        System.out.println("Ingrese el tipo de traccion");
        traccion=input.next();
        System.out.println("Ingrese el tipo de transmision");
        transmision=input.next();
        System.out.println("Ingrese las placas del vehiculo");
        placas=input.next();
        System.out.println("Ingrese el precio del vehiculo");
        precio=input.nextDouble();
        System.out.println("Ingrese una descripcion sobre el vehiculo");
        descripcion=input.next();
    }

    public Vehiculo(int cilindros, String traccion, String transmision, int numVel, String color, String descripcion, String marca, String modelo, int pasajeros, double precio, String placas) {
        this.cilindros = cilindros;
        this.traccion = traccion;
        this.transmision = transmision;
        this.numVel = numVel;
        this.color = color;
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.pasajeros = pasajeros;
        this.precio = precio;
        this.placas = placas;
    }

    public int getCilindros() {
        return cilindros;
    }

    public void setCilindros(int cilindros) {
        this.cilindros = cilindros;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public int getNumVel() {
        return numVel;
    }

    public void setNumVel(int numVel) {
        this.numVel = numVel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    @Override
    public void escribirObj(Object obj){
        try {
            FileOutputStream abrirArch=new FileOutputStream("vehiculo.txt");
            ObjectOutputStream guardarObj=new ObjectOutputStream(abrirArch);
            guardarObj.writeObject(obj);
            guardarObj.flush();
            guardarObj.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void leerObj(Object obj){
        try {
            FileInputStream abrirArch=new FileInputStream("vehiculo.txt");
            ObjectInputStream leerObj=new ObjectInputStream(abrirArch);
            ArrayList <Vehiculo> miLista=(ArrayList<Vehiculo>) leerObj.readObject();
            for (int i = 0; i<miLista.size(); i++) {
                Vehiculo vehi=miLista.get(i);
                System.out.println("Marca: "+vehi.getMarca()+
                        "Modelo: "+vehi.getModelo()+
                        "Color: "+vehi.getColor()+
                        "Cilindros: "+vehi.getCilindros()+
                        "Numero de Velocidades: "+vehi.getNumVel()+
                        "Numemro de pasajeros: "+vehi.getPasajeros()+
                        "Traccion: "+vehi.getTraccion()+
                        "Transmision: "+vehi.getTransmision()+
                        "Placas: "+vehi.getPlacas()+
                        "Precio: "+vehi.getPrecio()+
                        "Descripcion: "+vehi.getDescripcion());
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
    }
   
}
