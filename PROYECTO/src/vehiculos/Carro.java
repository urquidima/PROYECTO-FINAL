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
public class Carro extends Vehiculo{
    private String estereo;
    private String ventilacion;

    public Carro() {
        Scanner input=new Scanner (System.in);
        System.out.println("Estereo del carro");
        estereo=input.next();
        System.out.println("Ventilacion del carro");
        ventilacion=input.next();
    }

    public Carro(String estereo, String ventilacion, int cilindros, String traccion, String transmision, int numVel, String color, String descripcion, String marca, String modelo, int pasajeros, double precio, String placas) {
        super(cilindros, traccion, transmision, numVel, color, descripcion, marca, modelo, pasajeros, precio, placas);
        this.estereo = estereo;
        this.ventilacion = ventilacion;
    }

    public String getEstereo() {
        return estereo;
    }

    public void setEstereo(String estereo) {
        this.estereo = estereo;
    }

    public String getVentilacion() {
        return ventilacion;
    }

    public void setVentilacion(String ventilacion) {
        this.ventilacion = ventilacion;
    }
    
    @Override
    public void escribirObj(Object obj){
        try {
            FileOutputStream abrirArch=new FileOutputStream("carro.txt");
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
            FileInputStream abrirArch=new FileInputStream("carro.txt");
            ObjectInputStream leerObj=new ObjectInputStream(abrirArch);
            ArrayList <Carro> miLista=(ArrayList<Carro>) leerObj.readObject();
            for (int i = 0; i<miLista.size(); i++) {
                Carro carro=miLista.get(i);
                System.out.println("Marca: "+carro.getMarca()+
                        "\nModelo: "+carro.getModelo()+
                        "\nColor: "+carro.getColor()+
                        "\nCilindros: "+carro.getCilindros()+
                        "\nNumero de Velocidades: "+carro.getNumVel()+
                        "\nNumemro de pasajeros: "+carro.getPasajeros()+
                        "\nTraccion: "+carro.getTraccion()+
                        "\nTransmision: "+carro.getTransmision()+
                        "\nPlacas: "+carro.getPlacas()+
                        "\nPrecio: "+carro.getPrecio()+
                        "\nDescripcion: "+carro.getDescripcion()+
                        "\nEstero: "+carro.getEstereo()+
                        "Ventilacion: "+carro.getVentilacion());
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
