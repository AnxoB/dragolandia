package com.example;

import com.example.controlador.BosqueControlador;
import com.example.controlador.MagoControlador;
import com.example.controlador.MonstruoControlador;
import com.example.interfaz.Interfaz;
import com.example.model.Bosque;
import com.example.model.Mago;
import com.example.model.Monstruo;

public class Main {
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        MagoControlador magoCtrl = new MagoControlador();
        MonstruoControlador monstruoCtrl = new MonstruoControlador();
        BosqueControlador bosqueCtrl = new BosqueControlador();

        // 1. Crear mago y monstruo por teclado
        Mago mago = interfaz.crearMago();
        Monstruo monstruo = interfaz.crearMonstruo();

        // 2. Crear bosque con monstruo jefe
        Bosque bosque = interfaz.crearBosque(monstruo);

        // 3. Guardar los objetos en la base de datos (opcional)
        magoCtrl.guardarMago(mago);
        monstruoCtrl.guardarMonstruo(monstruo);
        bosqueCtrl.guardarBosque(bosque);

        System.out.println("\n¡Comienza la batalla en el bosque " + bosque.getNombre() + "!\n");

        // 4. Simular batalla por turnos
        while (mago.getVida() > 0 && monstruo.getVida() > 0) {
            // Mago lanza hechizo
            mago.lanzarHechizo(monstruo);
            System.out.println("El mago lanza un hechizo. Vida del monstruo: " + monstruo.getVida());

            if (monstruo.getVida() <= 0) break;

            // Monstruo ataca
            monstruo.atacar(mago);
            System.out.println("El monstruo ataca. Vida del mago: " + mago.getVida());
        }

        // 5. Mostrar resultado final
        System.out.println("\nBatalla terminada.");
        if (mago.getVida() > 0) {
            System.out.println("El mago sobrevive y domina el bosque.");
        } else {
            System.out.println("El monstruo sobrevive y domina el bosque.");
        }
    }
}
