package me.apella.gym_management.controller

import me.apella.gym_management.model.user.User
import me.apella.gym_management.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(private val userRepository: UserRepository) {
    @GetMapping
    fun findAll(): Iterable<User> = userRepository.findAll()
}