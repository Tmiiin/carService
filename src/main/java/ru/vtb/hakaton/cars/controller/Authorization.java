package ru.vtb.hakaton.cars.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.vtb.hakaton.cars.Util.JwtUtil;
import ru.vtb.hakaton.cars.exception.CarServiceException;
import ru.vtb.hakaton.cars.model.AuthenticationRequest;
import ru.vtb.hakaton.cars.model.AuthentificationResponse;
import ru.vtb.hakaton.cars.service.CarUserDetailsService;
import ru.vtb.hakaton.cars.view.UserModel;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth Service", description = "Контроллер для авторизации")
public class Authorization {
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(Authorization.class.getName());

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CarUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;

    @Operation(summary = "Получить токен по логину и паролю")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthentificationResponse> createAuthentificationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        log.info("Handle authenticate request...");
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password ", e);

        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(
                authenticationRequest.getUsername()
        );
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthentificationResponse(jwt));
    }

    @PutMapping("/addUserInfo")
    @Operation(summary = "Обновить информацию по юзеру")
    public ResponseEntity<?> registration(@RequestBody UserModel userModel, @RequestParam String username) {
        try {
            return ResponseEntity.ok(userDetailsService.updateUser(userModel, username));
        }
        catch(CarServiceException e){
            throw new ResponseStatusException(HttpStatus.FOUND, e.getMessage());
        }
    }

    @PostMapping("/registration")
    @Operation(summary = "Зарегистрировать юзера")
    public ResponseEntity<?> addUser(@RequestBody @Valid UserModel userModel) {
        return ResponseEntity.ok(userDetailsService.saveUser(userModel));
    }

}
