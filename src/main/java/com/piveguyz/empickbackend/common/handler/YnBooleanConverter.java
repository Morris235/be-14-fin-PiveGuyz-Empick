package com.piveguyz.empickbackend.common.handler;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class YnBooleanConverter implements AttributeConverter<Boolean, String> {

	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		return Boolean.TRUE.equals(attribute) ? "Y" : "N";
	}

	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		return "Y".equalsIgnoreCase(dbData);
	}
}