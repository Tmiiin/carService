package ru.vtb.hakaton.cars.view.Offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CarModelsView {

    private int minPrice;
    private String title;
    private List<BodiesView> bodies;
    private String titleRus;
    private String transportType;

    public CarModelsView(CarModels carModels){
        this.minPrice = carModels.getMinPrice();
        this.title = carModels.getTitle();
        bodies = carModels.getBodies().stream().map(BodiesView::new).collect(Collectors.toList());
        this.titleRus = carModels.getTitleRus();
        this.transportType = carModels.getTransportType().getTitle();
    }

}
