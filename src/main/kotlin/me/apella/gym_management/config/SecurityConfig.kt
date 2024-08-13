package me.apella.gym_management.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            authorizeHttpRequests {
                authorize("/api/v1/users/**", hasRole("GYM_OWNER"))
            }
            httpBasic { }
        }
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun testOnlyUsers(passwordEncoder: PasswordEncoder): UserDetailsService {
        val users: User.UserBuilder = User.builder()
        val user: UserDetails = users.username("user").password(passwordEncoder.encode("123456")).roles("USER").build();
        val gymOwner: UserDetails =
            users.username("gymOwner").password(passwordEncoder.encode("123456")).roles("GYM_OWNER").build();
        val trainer: UserDetails =
            users.username("trainer").password(passwordEncoder.encode("123456")).roles("TRAINER").build();

        return InMemoryUserDetailsManager(user, gymOwner, trainer)
    }
}