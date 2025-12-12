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

        // 1. Crear mago
        Mago mago = interfaz.crearMago();
        magoCtrl.guardarMago(mago);

        // 2. Crear bosque (incluye creación de monstruos)
        Bosque bosque = interfaz.crearBosque();

        // 3. Guardar cada monstruo del bosque
        for (Monstruo m : bosque.getMonstruosJefe()) {
            monstruoCtrl.guardarMonstruo(m);
        }

        // 4. Guardar el bosque completo
        bosqueCtrl.guardarBosque(bosque);

        // 5. Seleccionar el primer monstruo para la batalla
        if (bosque.getMonstruosJefe().isEmpty()) {
            System.out.println("El bosque no tiene monstruos jefe. No hay batalla.");
            return;
        }

        Monstruo monstruo = bosque.getMonstruosJefe().get(0);

        System.out.println("\n¡Comienza la batalla en el bosque " + bosque.getNombre() + "!\n");

        // 6. Simular batalla
        while (mago.getVida() > 0 && monstruo.getVida() > 0) {
            mago.lanzarHechizo(monstruo);
            System.out.println("El mago lanza un hechizo. Vida del monstruo: " + monstruo.getVida());

            if (monstruo.getVida() <= 0) break;

            monstruo.atacar(mago);
            System.out.println("El monstruo ataca. Vida del mago: " + mago.getVida());
        }

        // 7. Resultado final
        System.out.println("\nBatalla terminada.");
        if (mago.getVida() > 0) {
            System.out.println("El mago sobrevive y domina el bosque.");
        } else {
            System.out.println("El monstruo sobrevive y domina el bosque.");
        }
    }
}
