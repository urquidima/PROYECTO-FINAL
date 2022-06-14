/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personas;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alox1
 */
public final class  Comprador extends Persona {
    private double presupuestoMXM;

    public Comprador() {
        Scanner input=new Scanner(System.in);
        System.out.println("Ingrese el presupuesto");
        presupuestoMXM=input.nextDouble();
    }

    public Comprador(double presupuestoMXM, String nombre, String apellido, String celular, String direccion) {
        super(nombre, apellido, celular, direccion);
        this.presupuestoMXM = presupuestoMXM;
    }

    public double getPresupuestoMXM() {
        return presupuestoMXM;
    }

    public void setPresupuestoMXM(double presupuestoMXM) {
        this.presupuestoMXM = presupuestoMXM;
    }
    
    @Override
    public void escribirObj(Object obj){
        try {
            FileOutputStream abrirArch=new FileOutputStream("comprador.txt");
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
            FileInputStream abrirArch=new FileInputStream("comprador.txt");
            ObjectInputStream leerObj=new ObjectInputStream(abrirArch);
            ArrayList <Comprador> miLista= (ArrayList <Comprador>) leerObj.readObject();
            for (int i = 0; i<miLista.size(); i++) {
                Comprador comprador=miLista.get(i);
                System.out.println("Nombre: "+comprador.getNombre()+
                        "\nApellido: "+comprador.getApellido()+
                        "\nCelular: "+comprador.getCelular()+
                        "\nDireccion: "+comprador.getDireccion()+
                        "Presupuesto: "+comprador.presupuestoMXM);
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
