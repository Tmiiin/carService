package ru.vtb.hakaton.cars.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/purchase")
@Tag(name = "Purchase Service", description = "Контроллер по осуществлению операций над заявками на покупку машин")
public class PurchaseController {

    @Operation(summary = "Калькулятор кредитной ставки")
    @GetMapping("/calculate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "успешная операция"),
            @ApiResponse(responseCode = "400", description = "неверный формат запроса"),
            @ApiResponse(responseCode = "500", description = "внутренняя ошибка сервера")
    })
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> calculateCredit(@Parameter(description = "Полная цена машины") @RequestParam double cost,
                                             @Parameter(description = "Первоначальный взнос") @RequestParam Double initialFee,
                                             @Parameter(description = "Остаточный платеж") @RequestParam Double residualPayment,
                                             @Parameter(description = "На какой срок берется кредит (лет)") @RequestParam int term) {
        return ResponseEntity.ok(new ArrayList<>(Arrays.asList()));
    }
}
