/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alox1
 */
public class Moto extends Vehiculo{
    private String proteccion;

    public Moto() {
        Scanner input=new Scanner (System.in);
        System.out.println("Proteccion con la que cuenta");
        proteccion=input.next();
    }

    public Moto(String proteccion, int cilindros, String traccion, String transmision, int numVel, String color, String descripcion, String marca, String modelo, int pasajeros, double precio, String placas) {
        super(cilindros, traccion, transmision, numVel, color, descripcion, marca, modelo, pasajeros, precio, placas);
        this.proteccion = proteccion;
    }

    public String getProteccion() {
        return proteccion;
    }

    public void setProteccion(String proteccion) {
        this.proteccion = proteccion;
    }
    
    @Override
    public void escribirObj(Object obj){
        try {
            FileOutputStream abrirArch=new FileOutputStream("moto.txt");
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
            FileInputStream abrirArch=new FileInputStream("moto.txt");
            ObjectInputStream leerObj=new ObjectInputStream(abrirArch);
            ArrayList <Moto> miLista=(ArrayList<Moto>) leerObj.readObject();
            for (int i = 0; i<miLista.size(); i++) {
                Moto moto=miLista.get(i);
                System.out.println("Marca: "+moto.getMarca()+
                        "\nModelo: "+moto.getModelo()+
                        "\nColor: "+moto.getColor()+
                        "\nCilindros: "+moto.getCilindros()+
                        "\nNumero de Velocidades: "+moto.getNumVel()+
                        "\nNumemro de pasajeros: "+moto.getPasajeros()+
                        "\nTraccion: "+moto.getTraccion()+
                        "\nTransmision: "+moto.getTransmision()+
                        "\nPlacas: "+moto.getPlacas()+
                        "\nPrecio: "+moto.getPrecio()+
                        "\nDescripcion: "+moto.getDescripcion()+
                        "Proteccion: "+moto.getProteccion());
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
