package com.interes;

import com.interes.consola.EntradaConsola;
import com.interes.consola.FormatoMoneda;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Punto de entrada: cálculo de interés compuesto de forma recursiva.
 */
public class Main {

    public static void main(String[] args) {
        EntradaConsola entrada = new EntradaConsola(new Scanner(System.in));

        System.out.println("=== Interés compuesto ===");
        BigDecimal capital = entrada.leerDecimal("Capital inicial: ");
        BigDecimal tasa = entrada.leerDecimal("Tasa de interés anual (%): ");
        int anios = entrada.leerEntero("Tiempo en años: ");

        try {
            BigDecimal resultado = CalculadoraInteresCompuesto.calcularMontoFinal(capital, tasa, anios);
            System.out.println("Monto acumulado después de " + anios + " año(s): "
                    + FormatoMoneda.formatear(resultado));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}