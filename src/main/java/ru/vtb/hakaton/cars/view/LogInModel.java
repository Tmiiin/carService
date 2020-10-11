package ru.vtb.hakaton.cars.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogInModel {

    private String login;
    private String password;

    private String email;

    private int income; //доход

}
