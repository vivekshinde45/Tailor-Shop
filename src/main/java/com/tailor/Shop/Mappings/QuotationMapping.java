package com.tailor.Shop.Mappings;

import org.springframework.stereotype.Component;

import com.tailor.Shop.Entities.Quotation;
import com.tailor.Shop.Payload.QuotationDto;

@Component
public class QuotationMapping {
    public Quotation dtoToQuotation(QuotationDto quotationDto) {
        Quotation quotation = new Quotation();
        quotation.setPrice(quotationDto.getPrice());
        quotation.setDescription(quotationDto.getDescription());
        return quotation;
    }

    public QuotationDto quotationToDto(Quotation quotation) {
        QuotationDto quotationDto = new QuotationDto();
        quotationDto.setId(quotation.getId());
        quotationDto.setPrice(quotation.getPrice());
        quotationDto.setDescription(quotation.getDescription());
        return quotationDto;
    }
}
