package utils;

import schemas.ConversionData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConversionLog {
    public static void log(ConversionData conversionData) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.printf("\n[Log de Conversão. Moeda de origem: %s Moeda desejada: %s Data e Horário: %s]\n", conversionData.getOriginCurrency(), conversionData.getTargetCurrency(), formatter.format(time));
    }
}
