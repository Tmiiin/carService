package ru.vtb.hakaton.cars.view.Offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferPropertiesResponseView {

  //  private String photo;
private List<CarModelsView> carModels;
    private String country;
    private String titleRus;

    public  OfferPropertiesResponseView(OfferPropertiesResponse offerPropertiesResponse){
    //    this.photo = offerPropertiesResponse.getPhoto();
        this.carModels = offerPropertiesResponse.getCarModels();
        this.country = offerPropertiesResponse.getCountry().getTitle();
        this.titleRus = offerPropertiesResponse.getTitleRus();
    }
}
