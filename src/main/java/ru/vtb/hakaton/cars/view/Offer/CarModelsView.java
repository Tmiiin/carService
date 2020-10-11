package ru.vtb.hakaton.cars.view.Offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CarModelsView {

    private int minPrice;
    private String title;
    private List<Bodies> bodies;
    private String titleRus;
    private String transportType;

    public CarModelsView(CarModels carModels){
        this.minPrice = carModels.getMinPrice();
        this.title = carModels.getTitle();
        bodies = carModels.getBodies();
        this.titleRus = carModels.getTitleRus();
        this.transportType = carModels.getTransportType().getTitle();
    }

}
