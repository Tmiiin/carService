package ru.vtb.hakaton.cars.view.Offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {
    private String alias;
    private boolean absentee;
    private int id;
    private String prefix;
    private String title;
    private String titleRus;
}
