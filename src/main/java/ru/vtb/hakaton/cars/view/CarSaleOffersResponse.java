package ru.vtb.hakaton.cars.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarSaleOffersResponse {

    private String countryTitle;

    private String companyLogo; //link of company logo

    private String model;

    private String title; // title like "Купе"

    private int minPrice;

    private String carType; //например - легковая

    private String carPhoto; //фотография машины

}
