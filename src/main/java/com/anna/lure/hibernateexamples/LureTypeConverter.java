package com.anna.lure.hibernateexamples;

import com.anna.lure.dto.LureType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LureTypeConverter implements AttributeConverter<LureType, String> {

    @Override
    public String convertToDatabaseColumn(LureType attribute) {
        return attribute.toString().toUpperCase();
    }

    @Override
    public LureType convertToEntityAttribute(String dbData) {
        return LureType.valueOf(dbData);
    }
}
