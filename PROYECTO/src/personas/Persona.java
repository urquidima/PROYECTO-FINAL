/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personas;

import interfaces.MuestraPedirDatos;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alox1
 */
public class Persona implements MuestraPedirDatos, Serializable {
    private String nombre;
    private String apellido;
    private String celular;
    private String direccion;

    public Persona() {
        Scanner input=new Scanner(System.in);
        System.out.println("Ingresa el nombre");
        this.nombre = input.next();
        System.out.println("Ingresa el apellido");
        this.apellido = input.next();
        System.out.println("Ingresa el celular");
        this.celular = input.next();
        System.out.println("Ingresa la direccion");
        this.direccion = input.next();
    }

    public Persona(String nombre, String apellido, String celular, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    

    @Override
    public void escribirObj(Object obj){
        try {
            FileOutputStream abrirArch=new FileOutputStream("persona.txt");
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
            FileInputStream abrirArch=new FileInputStream("persona.txt");
            ObjectInputStream leerObj=new ObjectInputStream(abrirArch);
            ArrayList <Persona> miListaPersona= (ArrayList <Persona>) leerObj.readObject();
            for (int i = 0; i<miListaPersona.size(); i++) {
                Persona persona=miListaPersona.get(i);
                System.out.println("Nombre: "+persona.getNombre()+
                        "Apellido: "+persona.getApellido()+
                        "Celular: "+persona.getCelular()+
                        "Direccion: "+persona.getDireccion());
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
