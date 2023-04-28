package com.tailor.Shop.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuotationDto {
    private Integer id;
    private double price;
    private String description;
}
