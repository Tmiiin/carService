package ru.vtb.hakaton.cars.service.Interface;

import ru.vtb.hakaton.cars.view.CarModel;
import ru.vtb.hakaton.cars.view.Offer.OfferProperties;

import java.util.List;

public interface CarService {
    List<OfferProperties> getInformation(CarModel car);
}
