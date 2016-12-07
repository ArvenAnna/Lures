package com.anna.lure.service;

import com.anna.lure.dto.LureDto;

import java.util.List;

public interface ILureService {
    Integer saveLure(LureDto lure);

    void deleteLure(Integer id);

    List<LureDto> findLures();

    LureDto findLure(Integer id);
}
