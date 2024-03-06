package fi.heusala.Bookstore.web;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableMethodSecurity(securedEnabled = true) // tämä vaaditaan @PreAuthorize("hasAuthority('ADMIN')") käyttöön
                                             // bookControllerissa

public class WebSecurityConfig {

        @Autowired
        public UserDetailServiceImpl userDetailsService;

        private static final AntPathRequestMatcher[] WHITE_LIST_URLS = {
                        new AntPathRequestMatcher("/h2-console/**"),
                        new AntPathRequestMatcher("/books**"), // rest rajapinnalle
                        new AntPathRequestMatcher("/book/**") }; // rest rajapinnalle

        @Bean
        public SecurityFilterChain configure(HttpSecurity http) throws Exception {

                http.authorizeHttpRequests(
                                authorize -> authorize
                                                .requestMatchers(antMatcher("/css/**")).permitAll()
                                                .requestMatchers(WHITE_LIST_URLS).permitAll()
                                                .anyRequest().authenticated())
                                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions
                                                .disable())) // h2consolea varten
                                .formLogin(formlogin -> formlogin
                                                // .loginPage("/login") // kustomoitavaa login sivua varten
                                                .defaultSuccessUrl("/booklist", true)
                                                .permitAll())
                                .logout(logout -> logout.permitAll())
                                .csrf(csrf -> csrf.disable()); // vain testiä varten, oikeassa sovelluksessa ei saa
                                                               // olla. Csfr ip osoitteiden tarkistus pois päältä asetus

                return http.build();
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        }

}
