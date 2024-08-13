package me.apella.gym_management.model.user

import jakarta.persistence.Entity
import jakarta.persistence.Table
import me.apella.gym_management.model.common.BaseEntity

@Entity
@Table(name = "users")
class User : BaseEntity() {
    var firstName: String? = null
    var lastName: String? = null
    var email: String? = null
    var password: String? = null
}