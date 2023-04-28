package com.tailor.Shop.Payload;

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
}
