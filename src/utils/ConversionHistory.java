package utils;

import schemas.ConversionData;

import java.util.ArrayList;
import java.util.List;

public class ConversionHistory {
    private final List<ConversionData> convertedValues = new ArrayList<>();

    public void add(ConversionData data) {
        convertedValues.add(data);
    }

    public List<ConversionData> getConvertedValues() {
        return convertedValues;
    }
}
