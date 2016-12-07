package com.anna.lure.converter;

import com.anna.lure.dto.ColorDto;
import com.anna.lure.persist.Color;
import com.anna.lure.persist.Lure;

public class ColorConverter {

    public static Color toColorEntity(ColorDto colorDto, Lure lure){
        Color color = new Color();
        color.setId(colorDto.getId());
        color.setName(colorDto.getName());
        color.setImg(colorDto.getImg());
        color.setLure(lure);
        return color;
    }

    public static ColorDto toColorDto(Color entity) {
        ColorDto colorDto = new ColorDto();
        colorDto.setId(entity.getId());
        colorDto.setImg(entity.getImg());
        colorDto.setName(entity.getName());
        return colorDto;
    }
}
