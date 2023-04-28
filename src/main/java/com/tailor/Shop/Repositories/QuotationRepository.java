package com.tailor.Shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tailor.Shop.Entities.Quotation;

public interface QuotationRepository extends JpaRepository<Quotation, Integer> {

}
