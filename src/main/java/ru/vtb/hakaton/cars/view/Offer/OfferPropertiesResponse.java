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
public class OfferPropertiesResponse {

    private Country country;
    private String titleRus;
    private String titleCoupe;
    List<CarModelsView> carModels;

    public OfferPropertiesResponse(OfferProperties offerProperties, String model){
        this.country = offerProperties.getCountry();
        this.titleRus = offerProperties.getTitleRus();
        this.carModels = new ArrayList<>();
        List<CarModels> carModels = offerProperties.getModels();
        List<CarModelsView> listModels = new ArrayList<>();
        for(CarModels carModels1: carModels){
            listModels.add(new CarModelsView(carModels1));
        }
        for(CarModelsView carModelsView: listModels)
            if(carModelsView.getTitle().equals(model))
                this.carModels.add(carModelsView);
        if(this.carModels.isEmpty())
                this.carModels = listModels;
    }
}
