package com.anna.lure.converter;

import com.anna.lure.dto.LureDto;
import com.anna.lure.persist.Lure;

public class LureConverter {

    public static Lure toLureEntity(LureDto lureDto) {
        Lure lure = new Lure();
        lure.setId(lureDto.getId());
        lure.setDescription(lureDto.getDescription());
        lure.setProducer(lureDto.getProducer());
        lure.setName(lureDto.getName());
        lure.setPrice(lureDto.getPrice());
        return lure;
    }

    public static LureDto toLureDto(Lure entity) {
        LureDto lureDto = new LureDto();
        lureDto.setId(entity.getId());
        lureDto.setDescription(entity.getDescription());
        lureDto.setName(entity.getName());
        lureDto.setProducer(entity.getProducer());
        lureDto.setPrice(entity.getPrice());
        return lureDto;
    }
}
