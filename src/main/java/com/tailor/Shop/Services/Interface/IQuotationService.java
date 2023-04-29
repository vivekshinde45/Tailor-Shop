package com.tailor.Shop.Services.Interface;

import com.tailor.Shop.Payload.QuotationDto;

public interface IQuotationService {
    // CRUD
    QuotationDto create(QuotationDto quotationDto, Integer userId);

    QuotationDto update(QuotationDto quotationDto, Integer QuotationID);

    void delete(Integer quotationID);

    QuotationDto getByID(Integer quotationID);
}
