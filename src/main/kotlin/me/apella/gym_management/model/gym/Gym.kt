package me.apella.gym_management.model.gym

import jakarta.persistence.Entity
import me.apella.gym_management.model.common.BaseEntity

@Entity
class Gym : BaseEntity() {
    var name: String? = null
    var location: String? = null
    var contactInfo: String? = null
}