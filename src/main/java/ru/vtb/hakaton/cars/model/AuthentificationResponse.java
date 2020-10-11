package ru.vtb.hakaton.cars.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AuthentificationResponse {

    private final String jwt;
}
