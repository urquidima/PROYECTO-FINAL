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
public final class Vendedor extends Persona {
    private String Pertenencia;

    public Vendedor() {
        Scanner input=new Scanner(System.in);
        System.out.println("Ingrese su comprobante de pertenencia");
        Pertenencia=input.next();
    }

    public Vendedor(String Pertenencia, String nombre, String apellido, String celular, String direccion) {
        super(nombre, apellido, celular, direccion);
        this.Pertenencia = Pertenencia;
    }

    public String getPertenencia() {
        return Pertenencia;
    }

    public void setPertenencia(String Pertenencia) {
        this.Pertenencia = Pertenencia;
    }
    
    @Override
    public void escribirObj(Object obj){
        try {
            FileOutputStream abrirArch=new FileOutputStream("vendedor.txt");
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
            FileInputStream abrirArch=new FileInputStream("vendedor.txt");
            ObjectInputStream leerObj=new ObjectInputStream(abrirArch);
            ArrayList <Vendedor> miLista= (ArrayList <Vendedor>) leerObj.readObject();
            for (int i = 0; i<miLista.size(); i++) {
                Vendedor vendedor=miLista.get(i);
                System.out.println("Nombre: "+vendedor.getNombre()+
                        "\nApellido: "+vendedor.getApellido()+
                        "\nCelular: "+vendedor.getCelular()+
                        "\nDireccion: "+vendedor.getDireccion()+
                        "Pertenencia: "+vendedor.getPertenencia());
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
