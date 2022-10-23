package kora.jtrekking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import kora.jtrekking.serviceImp.LoginUsuarioServiceImp;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginUsuarioServiceImp userDetailsService;

    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests()
                .antMatchers("/cargar/circuito").authenticated()
                .antMatchers("/editar/circuito/{id}").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin();
    }


    
    

}
