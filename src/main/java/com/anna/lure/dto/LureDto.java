package com.anna.lure.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class LureDto {
    private Integer id;
    private String name;
    private String producer;
    private Double price;
    private List<ColorDto> colors;
    private List<CommentDto> comments;
    private String description;
    private LureDetailsDto details;
}
