package ru.vtb.hakaton.cars.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vtb.hakaton.cars.service.Interface.CarService;
import ru.vtb.hakaton.cars.view.CarModel;
import ru.vtb.hakaton.cars.view.CarModelView;
import ru.vtb.hakaton.cars.view.Offer.OfferProperties;
import ru.vtb.hakaton.cars.view.Offer.OfferPropertiesResponse;
import ru.vtb.hakaton.cars.view.Offer.OfferPropertiesResponseView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
@Tag(name = "Car Service", description = "Контроллер по осуществлению операций над машинами")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    /* @ApiResponses(value = {
             @ApiResponse(responseCode = "200", description = "успешная операция"),
             @ApiResponse(responseCode = "400", description = "неверный формат запроса"),
             @ApiResponse(responseCode = "404", description = "изображение не распознано", content = @Content(mediaType = "application/json")),
             @ApiResponse(responseCode = "500", description = "внутренняя ошибка сервера")
     })*/
    @Operation(summary = "Получение информации о предложениях продажи машины по номеру и марке")
    @GetMapping(value = "/info")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> aboutCar(@RequestBody CarModelView cars)  {
        List<OfferPropertiesResponseView> offerProperties = new ArrayList<>();
        for(CarModel car: cars.getCars()){
            offerProperties.addAll(carService.getInformation(car).stream().map(x -> createResponse(x,car.getModel())).collect(Collectors.toList()));
        }
        return ResponseEntity.ok(offerProperties);
    }


    public OfferPropertiesResponseView createResponse(OfferProperties offerProperties, String model){
        return new OfferPropertiesResponseView(new OfferPropertiesResponse(offerProperties, model));
    }
}
