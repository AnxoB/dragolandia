package com.example.interfaz;

import java.util.Scanner;

import com.example.model.Mago;
import com.example.model.Monstruo;

public class Interfaz {
    private Scanner sc = new Scanner(System.in);

    public Mago crearMago(){
        System.out.print("Nombre del mago: ");
        String nombre = sc.nextLine();
        System.out.print("Vida del mago: ");
        int vida = sc.nextInt();
        sc.nextLine();
        System.out.print("Nivel de magia del mago: ");
        int magia = sc.nextInt();
        sc.nextLine();

        return new Mago(nombre, vida, magia);
    }

    public Monstruo crearMonstruo(){
        System.out.print("Nombre del monstruo: ");
        String nombre = sc.nextLine();
        System.out.print("Vida del monstruo: ");
        int vida = sc.nextInt();
        sc.nextLine();
        System.out.print("Fuerza del monstruo: ");
        int fuerza = sc.nextInt();
        sc.nextLine();
        System.out.println("Tipo del monstruo(ogro, troll o espectro)");
        String tipo = sc.nextLine();

        return new Monstruo(nombre, vida, fuerza, tipo);

    }
}
