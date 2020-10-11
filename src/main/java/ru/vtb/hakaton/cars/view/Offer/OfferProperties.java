package ru.vtb.hakaton.cars.view.Offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OfferProperties {
    private boolean absentee;
    private String alias;
    private Country country;
    private int currentCarCount;
    private int currentModelsTotal;
    private List<String> generations;
    private int id;
    private boolean isOutOfBounds;
    private String logo;
    private List<CarModels> models;
    private String title;
    private String titleRus;
//2

}
