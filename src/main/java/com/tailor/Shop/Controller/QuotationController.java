package com.tailor.Shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tailor.Shop.Payload.QuotationDto;
import com.tailor.Shop.Services.Implementation.QuotationService;

@RestController
@RequestMapping("/api/v1/quotation")
public class QuotationController {
    @Autowired
    private QuotationService _quotationService;

    // CRUD
    @PostMapping("/user/{userId}/job/{jobId}")
    public ResponseEntity<QuotationDto> create(@RequestBody QuotationDto quotationDto,
            @PathVariable Integer userId,
            @PathVariable Integer jobId) {
        QuotationDto quotation = this._quotationService.create(quotationDto, userId, jobId);
        return new ResponseEntity<QuotationDto>(quotation, HttpStatus.CREATED);
    }

    @PutMapping("/{quotationId}")
    public ResponseEntity<QuotationDto> update(@RequestBody QuotationDto quotationDto,
            @PathVariable Integer quotationId) {
        QuotationDto quotation = this._quotationService.update(quotationDto, quotationId);
        return new ResponseEntity<QuotationDto>(quotation, HttpStatus.OK);
    }

    @DeleteMapping("/{quotationId}")
    public ResponseEntity<String> delete(@PathVariable Integer quotationId) {
        this._quotationService.delete(quotationId);
        return new ResponseEntity<String>("Quotation deleted successfuly of ID: " + quotationId, HttpStatus.OK);
    }

    @GetMapping("/{quotationId}")
    public ResponseEntity<QuotationDto> getByID(@PathVariable Integer quotationId) {
        QuotationDto quotation = this._quotationService.getByID(quotationId);
        return new ResponseEntity<QuotationDto>(quotation, HttpStatus.OK);
    }
}
