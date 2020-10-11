package ru.vtb.hakaton.cars.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.vtb.hakaton.cars.view.UserModel;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

import static org.hibernate.cfg.AvailableSettings.USER;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Column
    @Size(min=2, message = "Не меньше 5 знаков")
    private String username;

    @Column
    @Size(min=2, message = "Не меньше 5 знаков")
    private String password;

    @Column
    private String email;

    @Column
    private int income; //доход

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(USER));
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User(UserModel userModel){
        this.username = userModel.getUsername();
    }
}
