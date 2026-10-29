package com.interes;

import java.math.BigDecimal;

/**
 * Calcula el monto acumulado de una inversión con interés compuesto anual.
 *
 * <p>Modelo recursivo:
 * <ul>
 *   <li>Caso base: C(0) = m</li>
 *   <li>Caso recursivo: C(n) = C(n-1) * (1 + i), donde i = X/100</li>
 * </ul>
 */
public final class CalculadoraInteresCompuesto {

    /** Límite de años para evitar un StackOverflowError por recursión profunda. */
    public static final int MAX_ANIOS = 1000;

    private static final BigDecimal CIEN = BigDecimal.valueOf(100);

    private CalculadoraInteresCompuesto() {
        // Clase utilitaria: no se instancia.
    }

    /**
     * @param capital capital inicial (m), no negativo
     * @param tasa    tasa de interés anual en porcentaje (X), no negativa
     * @param anios   tiempo de la inversión (n), entre 0 y {@link #MAX_ANIOS}
     * @return monto acumulado C(n) sin redondear
     * @throws IllegalArgumentException si algún parámetro es inválido
     */
    public static BigDecimal calcularMontoFinal(BigDecimal capital, BigDecimal tasa, int anios) {
        validar(capital, tasa, anios);
        // La tasa se convierte internamente a su equivalente decimal (i = X/100)
        BigDecimal factorCrecimiento = BigDecimal.ONE.add(tasa.divide(CIEN));
        return montoEnAnio(capital, factorCrecimiento, anios);
    }

    private static BigDecimal montoEnAnio(BigDecimal capitalInicial, BigDecimal factorCrecimiento, int n) {
        // Caso base
        if (n == 0) {
            return capitalInicial;
        }
        // Caso recursivo: C(n) = C(n-1) * (1 + i)
        return montoEnAnio(capitalInicial, factorCrecimiento, n - 1).multiply(factorCrecimiento);
    }

    private static void validar(BigDecimal capital, BigDecimal tasa, int anios) {
        if (capital == null || tasa == null) {
            throw new IllegalArgumentException("El capital y la tasa son obligatorios.");
        }
        if (capital.signum() < 0) {
            throw new IllegalArgumentException("El capital no puede ser negativo.");
        }
        if (tasa.signum() < 0) {
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa.");
        }
        if (anios < 0) {
            throw new IllegalArgumentException("Los años no pueden ser negativos.");
        }
        if (anios > MAX_ANIOS) {
            throw new IllegalArgumentException("Los años no pueden superar " + MAX_ANIOS + ".");
        }
    }
}