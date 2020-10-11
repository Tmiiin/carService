package ru.vtb.hakaton.cars.view.Offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BodiesView {
    private String photo;
    private String title;

    public BodiesView(Bodies bodies){
        this.photo = bodies.getPhoto();
        this.title = bodies.getTitle();
    }

}
