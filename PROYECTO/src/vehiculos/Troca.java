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
public class Troca extends Vehiculo{
    private String capCargaKg;

    public Troca() {
        Scanner input=new Scanner (System.in);
        System.out.println("Capacidad de carga en KG");
        capCargaKg=input.next();
    }

    public Troca(String capCargaKg, int cilindros, String traccion, String transmision, int numVel, String color, String descripcion, String marca, String modelo, int pasajeros, double precio, String placas) {
        super(cilindros, traccion, transmision, numVel, color, descripcion, marca, modelo, pasajeros, precio, placas);
        this.capCargaKg = capCargaKg;
    }

    public String getCapCargaKg() {
        return capCargaKg;
    }

    public void setCapCargaKg(String capCargaKg) {
        this.capCargaKg = capCargaKg;
    }
    
    @Override
    public void escribirObj(Object obj){
        try {
            FileOutputStream abrirArch=new FileOutputStream("troca.txt");
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
            FileInputStream abrirArch=new FileInputStream("troca.txt");
            ObjectInputStream leerObj=new ObjectInputStream(abrirArch);
            ArrayList <Troca> miLista=(ArrayList<Troca>) leerObj.readObject();
            for (int i = 0; i<miLista.size(); i++) {
                Troca troca=miLista.get(i);
                System.out.println("Marca: "+troca.getMarca()+
                        "\nModelo: "+troca.getModelo()+
                        "\nColor: "+troca.getColor()+
                        "\nCilindros: "+troca.getCilindros()+
                        "\nNumero de Velocidades: "+troca.getNumVel()+
                        "\nNumemro de pasajeros: "+troca.getPasajeros()+
                        "\nTraccion: "+troca.getTraccion()+
                        "\nTransmision: "+troca.getTransmision()+
                        "\nPlacas: "+troca.getPlacas()+
                        "\nPrecio: "+troca.getPrecio()+
                        "\nDescripcion: "+troca.getDescripcion()+
                        "Capacidad de carga en KG: "+troca.getCapCargaKg());
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
