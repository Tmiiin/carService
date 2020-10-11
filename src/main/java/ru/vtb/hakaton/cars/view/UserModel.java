package ru.vtb.hakaton.cars.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private String username;
    private String password;
    private String email;
    private Integer income;
}
