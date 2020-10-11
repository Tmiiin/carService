package ru.vtb.hakaton.cars.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vtb.hakaton.cars.exception.CarServiceException;
import ru.vtb.hakaton.cars.model.User;
import ru.vtb.hakaton.cars.repository.UserRepository;
import ru.vtb.hakaton.cars.service.Interface.PurchaseService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CarUserDetailsService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ru.vtb.hakaton.cars.model.User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        return user.get();
    }

    public ru.vtb.hakaton.cars.model.User findUserById(UUID userId) {
        Optional<ru.vtb.hakaton.cars.model.User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new ru.vtb.hakaton.cars.model.User());
    }

    public List<ru.vtb.hakaton.cars.model.User> allUsers() {
        return userRepository.findAll();
    }

    public boolean saveUser(ru.vtb.hakaton.cars.view.UserModel userModel) {
        Optional<User> userFromDB = userRepository.findByUsername(userModel.getUsername());
        if (userFromDB.isPresent()) {
            return false;
        }
        User newUser = new User(userModel);
        if (!userModel.getEmail().isEmpty()) {
            newUser.setEmail(userModel.getEmail());
        }
        if (userModel.getIncome() != null) {
            newUser.setIncome(userModel.getIncome());
        }
        newUser.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
        userRepository.save(newUser);
        return true;
    }

    public boolean deleteUser(UUID userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public User updateUser(ru.vtb.hakaton.cars.view.UserModel userModel, String username) {
        Optional<User> userFromDB = userRepository.findByUsername(username);
        if (!userFromDB.isPresent()) {
            throw new CarServiceException("User with this username is already exist");
        }
        logger.info("было: " + userFromDB.get().toString());
        if (!userModel.getUsername().isEmpty())
            userFromDB.get().setUsername(userModel.getUsername());
        if (!userModel.getEmail().isEmpty()) {
            userFromDB.get().setEmail(userModel.getEmail());
        }
        if (userModel.getIncome() != null) {
            userFromDB.get().setIncome(userModel.getIncome());
        }
        userFromDB.get().setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
        userRepository.save(userFromDB.get());
        logger.info("стало: " + userFromDB.get().toString());
        return userFromDB.get();
    }
}
