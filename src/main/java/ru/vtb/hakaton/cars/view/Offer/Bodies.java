package ru.vtb.hakaton.cars.view.Offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bodies {
    private String alias;
    private int doors;
    private String photo;
    private String title;
    private String type;
    private  String typeTitle;
}
