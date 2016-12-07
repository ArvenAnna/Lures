package com.anna.lure.converter;

import com.anna.lure.dto.LureDetailsDto;
import com.anna.lure.persist.Lure;
import com.anna.lure.persist.LureDetail;

public class LureDetailsConverter {

    public static LureDetail toDetailEntity(LureDetailsDto detailDto, Lure lure){
        LureDetail detail = new LureDetail();
        detail.setId(detailDto.getId());
        detail.setDepth(Double.valueOf(detailDto.getDepth()));
        detail.setLength(Double.valueOf(detailDto.getLeng()));
        detail.setWeight(Double.valueOf(detailDto.getWeight()));
        detail.setType(detailDto.getType());
        detail.setLure(lure);
        return detail;
    }

    public static LureDetailsDto toDetailDto(LureDetail entity) {
        LureDetailsDto detailDto = new LureDetailsDto();
        detailDto.setId(entity.getId());
        detailDto.setDepth(entity.getDepth().toString());
        detailDto.setLeng(entity.getLength().toString());
        detailDto.setWeight(entity.getWeight().toString());
        detailDto.setType(entity.getType());
        return detailDto;
    }
}
