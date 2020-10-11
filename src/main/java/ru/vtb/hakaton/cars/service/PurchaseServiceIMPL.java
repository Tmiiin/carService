package ru.vtb.hakaton.cars.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.vtb.hakaton.cars.service.Interface.PurchaseService;

@Component
public class PurchaseServiceIMPL implements PurchaseService {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseService.class);


    public Page getOffers(String car_model, String car_brand, int pageSize, int page) {
        Pageable sortedPage;
        sortedPage = PageRequest.of(
                page,
                pageSize,
                Sort.by(Sort.Direction.ASC, "brand"));
        return null;//carRepository.findAll(sortedPage);
    }

}
