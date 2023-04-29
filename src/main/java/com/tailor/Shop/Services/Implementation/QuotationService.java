package com.tailor.Shop.Services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tailor.Shop.Entities.Quotation;
import com.tailor.Shop.Entities.User;
import com.tailor.Shop.Exceptions.ResourceNotFoundException;
import com.tailor.Shop.Mappings.QuotationMapping;
import com.tailor.Shop.Payload.QuotationDto;
import com.tailor.Shop.Repositories.QuotationRepository;
import com.tailor.Shop.Repositories.UserRepository;
import com.tailor.Shop.Services.Interface.IQuotationService;

@Service
public class QuotationService implements IQuotationService {
    @Autowired
    private QuotationRepository _quotationRepository;

    @Autowired
    private QuotationMapping _quotationMapping;

    @Autowired
    private UserRepository _userRepository;

    @Override
    public QuotationDto create(QuotationDto quotationDto, Integer userId) {
        User user = this._userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User",
                        "User Id",
                        userId + ""));
        Quotation quotation = this._quotationMapping.dtoToQuotation(quotationDto);
        quotation.setUser(user);
        Quotation savedQuotation = this._quotationRepository.save(quotation);
        return this._quotationMapping.quotationToDto(savedQuotation);
    }

    @Override
    public QuotationDto update(QuotationDto quotationDto, Integer quotationID) {
        Quotation quotation = this._quotationRepository.findById(quotationID)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Quotation",
                        "Id",
                        quotationID + ""));
        quotationDto.setId(quotation.getId());
        Quotation mappedQuotation = this._quotationMapping.dtoToQuotation(quotationDto);
        mappedQuotation.setUser(quotation.getUser());
        Quotation updatedQuotation = this._quotationRepository.save(mappedQuotation);
        return this._quotationMapping.quotationToDto(updatedQuotation);
    }

    @Override
    public void delete(Integer quotationID) {
        Quotation quotation = this._quotationRepository.findById(quotationID)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Quotation",
                        "Id",
                        quotationID + ""));
        this._quotationRepository.delete(quotation);
    }

    @Override
    public QuotationDto getByID(Integer quotationID) {
        Quotation quotation = this._quotationRepository.findById(quotationID)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Quotation",
                        "Id",
                        quotationID + ""));
        return this._quotationMapping.quotationToDto(quotation);
    }

}
