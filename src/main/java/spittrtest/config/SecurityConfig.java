package spittrtest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import spittrtest.security.SpitterUserService;
import spittrtest.service.SpitterRepositoryImpl;

@Configuration
@EnableWebSecurity
@ComponentScan("spittrtest")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    SpitterRepositoryImpl spitterRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder)throws Exception{
        authenticationManagerBuilder.userDetailsService(new SpitterUserService(spitterRepository));
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .formLogin().loginPage("/login")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")).logoutSuccessUrl("/")
                .and()
//                .httpBasic().realmName("spittrtest")
                .rememberMe().tokenValiditySeconds(2419200).key("spittrKey")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/addSpittle").authenticated()
                .antMatchers("/spitter/**").authenticated()
                .anyRequest().permitAll()
                .and().requiresChannel().antMatchers("/").requiresInsecure();
//                .requiresChannel().antMatchers("/register").requiresSecure()

//        httpSecurity.csrf().disable();
    }
}
