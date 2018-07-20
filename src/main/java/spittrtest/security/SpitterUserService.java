package spittrtest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import spittrtest.model.Spitter;
import spittrtest.service.SpitterRepositoryImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpitterUserService implements UserDetailsService {
    private SpitterRepositoryImpl spitterRepository;

    @Autowired
    public SpitterUserService(SpitterRepositoryImpl spitterRepository){
        this.spitterRepository = spitterRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            Spitter spitter = spitterRepository.findUser(username);
            if(spitter != null){
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));

                return new User(spitter.getUsername(), spitter.getPassword(),authorities);
            }
            throw new UsernameNotFoundException("User "+ username +" not found.");
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
