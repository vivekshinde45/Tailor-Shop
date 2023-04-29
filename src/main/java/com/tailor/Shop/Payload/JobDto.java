package com.tailor.Shop.Payload;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {
    private Integer id;
    private String imgname;
    private String description;
    private boolean isActive;
    private String budget;
    private UserDto user;
    private List<QuotationDto> quotations;
}
