package ru.vtb.hakaton.cars.view.Offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransportType {
    private String alias;
    private int id;
    private String title;
}
