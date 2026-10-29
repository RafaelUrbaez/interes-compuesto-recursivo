package com.interes.consola;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Lectura segura de datos por consola.
 * Los reintentos son recursivos para no usar estructuras iterativas.
 */
public final class EntradaConsola {

    private final Scanner scanner;

    public EntradaConsola(Scanner scanner) {
        this.scanner = scanner;
    }

    public BigDecimal leerDecimal(String mensaje) {
        System.out.print(mensaje);
        try {
            return new BigDecimal(scanner.nextLine().trim().replace(',', '.'));
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido. Escribe un número decimal (ej: 1500.50).");
            return leerDecimal(mensaje);
        }
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido. Escribe un número entero.");
            return leerEntero(mensaje);
        }
    }
}