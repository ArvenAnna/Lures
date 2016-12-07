package com.anna.lure.service.impl;

import com.anna.lure.converter.ColorConverter;
import com.anna.lure.converter.LureConverter;
import com.anna.lure.converter.LureDetailsConverter;
import com.anna.lure.dto.ColorDto;
import com.anna.lure.dto.LureDetailsDto;
import com.anna.lure.dto.LureDto;
import com.anna.lure.exception.Errors;
import com.anna.lure.exception.LureApplicationException;
import com.anna.lure.persist.Color;
import com.anna.lure.persist.Lure;
import com.anna.lure.persist.LureDetail;
import com.anna.lure.repository.ColorRepository;
import com.anna.lure.repository.CommentRepository;
import com.anna.lure.repository.LureDetailsRepository;
import com.anna.lure.repository.LureRepository;
import com.anna.lure.service.ILureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LureService implements ILureService {

    @Autowired
    LureRepository lureRepository;
    @Autowired
    LureDetailsRepository lureDetailsRepository;
    @Autowired
    ColorRepository colorRepository;
    @Autowired
    CommentRepository commentRepository;


    @Override
    public Integer saveLure(LureDto lure) {
        Assert.notNull(lure, "lure must not be null");
        Assert.isNull(lure.getId(), "id for new lure must be null");
        Assert.notNull(lure.getDetails(), "lure must have not empty details");
        return saveOrUpdate(lure);
    }

    private Integer saveOrUpdate(LureDto lure) {
        Lure lureEntity = LureConverter.toLureEntity(lure);
        List<Color> colors = lure.getColors().stream().map(color -> ColorConverter.toColorEntity(color, lureEntity)).collect(Collectors.toList());
        lureEntity.setColors(colors);
        LureDetail lureDetail = LureDetailsConverter.toDetailEntity(lure.getDetails(), lureEntity);
        lureEntity.setDetails(lureDetail);
        lureRepository.saveAndFlush(lureEntity);
        return lureEntity.getId();
    }

    @Override
    public void deleteLure(Integer id) {
        Assert.notNull(id, "id must not be null");
        lureRepository.delete(id);
    }

    @Override
    public List<LureDto> findLures() {
        return lureRepository.findAll().stream()
                .map(lure -> constructLureDto(lure)).collect(Collectors.toList());
    }

    private LureDto constructLureDto(Lure lure) {
        LureDto lureDto = LureConverter.toLureDto(lure);
        List<ColorDto> colorDtos = lure.getColors().stream().map(color -> ColorConverter.toColorDto(color)).collect(Collectors.toList());
        lureDto.setColors(colorDtos);
        LureDetailsDto detailsDto = LureDetailsConverter.toDetailDto(lure.getDetails());
        lureDto.setDetails(detailsDto);
        return lureDto;
    }

    @Override
    public LureDto findLure(Integer id) {
        Assert.notNull(id, "id must not be null");
        Lure lureEntity = lureRepository.findOne(id);
        if (lureEntity == null) {
            throw new LureApplicationException(Errors.LURE_NOT_FOUND);
        }
        return constructLureDto(lureEntity);
    }
}
