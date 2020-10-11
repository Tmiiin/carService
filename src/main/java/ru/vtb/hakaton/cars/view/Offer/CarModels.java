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
public class CarModels {

 private boolean absentee;
 private String alias;
 private List<Bodies> bodies;
 private Brand brand;
 private String carId;
 private int colorsCount;
 private  int count;
 private boolean hasSpecialPrice;
 private int id;
 private int metallicPay;
 private int minPrice;
 private Model model;
 private String ownTitle;
 private int pearlPay;
 private String photo;
 private String prefix;
 private List<String> premiumPriceSpecials;
 private RenderPhotos renderPhotos;
 private SizesPhotos sizesPhotos;
private int specmetallicPay;
private String title;
private String titleRus;
private TransportType transportType;
//3
}
