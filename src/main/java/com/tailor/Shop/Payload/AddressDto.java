package com.tailor.Shop.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Integer id;
    private String street;
    private String area;
    private String pincode;
    private String city;
    private String district;
}
