package com.interes.consola;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Formatea valores monetarios con dos decimales.
 */
public final class FormatoMoneda {

    private FormatoMoneda() {
    }

    public static String formatear(BigDecimal valor) {
        DecimalFormat formato = new DecimalFormat("#,##0.00", DecimalFormatSymbols.getInstance(Locale.US));
        formato.setRoundingMode(RoundingMode.HALF_UP);
        return "$" + formato.format(valor);
    }
}