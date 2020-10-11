package ru.vtb.hakaton.cars.view.Offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    private boolean absentee;
    private String alias;
    private Country country;
}

