/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;

import java.util.ArrayList;
import java.util.Scanner;
import personas.*;
import vehiculos.*;
/**
 *
 * @author alox1
 */
public class PROYECTO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input=new Scanner(System.in);
        int op;
        int pref;
        ArrayList<Comprador> listaComprador=new ArrayList();
        ArrayList<Vendedor> listaVendedor=new ArrayList();
        ArrayList<Carro> listaCarro=new ArrayList();
        ArrayList<Moto> listaMoto=new ArrayList();
        ArrayList<Troca> listaTroca=new ArrayList();
        
        do{
            System.out.println("""
                               Ingrese el numero con la accion deseada 
                               1.- Registrar un nuevo vehiculo 
                               2.- Vender un vehiculo 
                               3.- Ver lista de vehiculos 
                               4.- Terminar el programa""");
            op =input.nextInt();
            switch(op){
                case 1 -> {
                    System.out.println("""
                                       Que tipo de vehiculo se registrara
                                       1.- Carro
                                       2.- Moto
                                       3.- Troca
                                       """);
                    pref=input.nextInt();
                    switch(pref){
                        case 1->{
                            System.out.println("Primero ingresara los datos del carro");
                            listaCarro.add(new Carro());
                            Carro carro=listaCarro.get(listaCarro.size()-1);
                            carro.escribirObj(listaCarro);
                            System.out.println("Ahora ingresara los datos del vendedor");
                            listaVendedor.add(new Vendedor());
                        }
                        case 2->{
                            System.out.println("Primero ingresara los datos de la moto");
                            listaMoto.add(new Moto());
                            Moto moto=listaMoto.get(listaMoto.size()-1);
                            moto.escribirObj(listaMoto);
                            System.out.println("Ahora ingresara los datos del vendedor");
                            listaVendedor.add(new Vendedor());
                        }
                        case 3->{
                            System.out.println("Primero ingresara los datos de la troca");
                            listaTroca.add(new Troca());
                            Troca troca=listaTroca.get(listaTroca.size()-1);
                            troca.escribirObj(listaTroca);
                            System.out.println("Ahora ingresara los datos del vendedor");
                            listaVendedor.add(new Vendedor());
                        }
                    }
                }
                case 2->{
                    String cel="";
                    int compradorOP;
                    String placas;
                    Comprador comprActual=new Comprador(0,"","","","");
                    boolean celOP=false;
                    do {
                        System.out.println("""
                                       Registro de comprador
                                       1.- Nuevo comprador
                                       2.- Ya estoy registrado
                                       """);      
                        compradorOP=input.nextInt();
                        if (compradorOP==1) {
                            listaComprador.add(new Comprador());
                            comprActual=listaComprador.get(listaComprador.size()-1);
                            comprActual.escribirObj(listaComprador);
                        }else{
                            System.out.println("Ingrese su Celular");
                            cel=input.next();
                            for (int i = 0; i <  listaComprador.size(); i++) {
                                Comprador comprador=listaComprador.get(i);
                                if (comprador.getCelular().equals(cel)) {
                                    comprActual=comprador;
                                }else{
                                    System.out.println("No se encontro el comprador");
                                }
                            }
                        }
                    } while (celOP==true);
                    if (comprActual.getApellido()=="" || (listaMoto.size()==0 && listaCarro.size()==0 && listaTroca.size()==0)) {
                        System.out.println("Sera regresado al menu");
                    }else{
                        System.out.println("Ingrese las placas del vehiculo que desea comprar");
                        placas=input.next(); 
                        for (int i = 0; i < listaCarro.size(); i++) {
                            Carro carro=listaCarro.get(i);
                            if (carro.getPlacas().equals(placas)) {
                                if (comprActual.getPresupuestoMXM()<carro.getPrecio()) {
                                    System.out.println("El presupuesto no es suficiente para comprar el vehiculo");
                                }else{
                                    System.out.println("Felicidades por su compra");
                                    listaCarro.remove(i);
                                }
                            }else{
                                System.out.println("No se encontraron las placas");
                            }
                        }
                        for (int i = 0; i < listaMoto.size(); i++) {
                            Moto moto=listaMoto.get(i);
                            if (moto.getPlacas().equals(placas)) {
                                if (comprActual.getPresupuestoMXM()<moto.getPrecio()) {
                                    System.out.println("El presupuesto no es suficiente para comprar el vehiculo");
                                }else{
                                    System.out.println("Felicidades por su compra");
                                    listaMoto.remove(i);
                                }
                            }else{
                                System.out.println("No se encontraron las placas");
                            }
                        }
                        for (int i = 0; i < listaTroca.size(); i++) {
                            Troca troca=listaTroca.get(i);
                            if (troca.getPlacas().equals(placas)) {
                                if (comprActual.getPresupuestoMXM()<troca.getPrecio()) {
                                    System.out.println("El presupuesto no es suficiente para comprar el vehiculo");
                                }else{
                                    System.out.println("Felicidades por su compra");
                                    listaTroca.remove(i);
                                }
                            }else{
                                System.out.println("No se encontraron las placas");
                            }
                        }
                    }
                    if (listaMoto.size()==0 && listaCarro.size()==0 && listaTroca.size()==0) {
                        System.out.println("No hay vehiculos registrados");
                     }
                }
                case 3->{
                    if (listaCarro.size()!=0) {
                        Carro carro=listaCarro.get(listaCarro.size()-1);
                        carro.leerObj(listaCarro);
                    }
                    if (listaMoto.size()!=0) {
                        Moto  moto=listaMoto.get(listaMoto.size()-1);
                        moto.leerObj(listaMoto);
                    }
                    if (listaTroca.size()!=0) {
                        Troca troca=listaTroca.get(listaTroca.size()-1);
                        troca.leerObj(listaTroca);
                    }
                    
                    if (listaMoto.size()==0 && listaCarro.size()==0 && listaTroca.size()==0) {
                        System.out.println("No hay vehiculos registrados");
                    }
                    
                }
                
            }
            
        }while(op!=4);
       
    }
    
}
