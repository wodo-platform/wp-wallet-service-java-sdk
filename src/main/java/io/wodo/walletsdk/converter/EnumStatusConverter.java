package io.wodo.walletsdk.converter;

import io.wodo.walletsdk.enumtype.EnumStatus;
import io.wodo.walletsdk.util.EnumUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EnumStatusConverter implements AttributeConverter<EnumStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(EnumStatus enumStatus) {
        if (enumStatus == null) {
            return null;
        }
        return enumStatus.getValue();
    }

    @Override
    public EnumStatus convertToEntityAttribute(Integer value) {
        return EnumUtils.getValueEnum(EnumStatus.class, value);
    }
}