package org.example.simpleapp.service

import org.example.simpleapp.datamodel.User
import org.example.simpleapp.datamodel.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun createUser(name: String, email: String) {
        userRepository.createUser(name, email)
    }

    fun getUserById(id: Long): User? {
        return userRepository.getUserById(id)
    }

    fun getAllUsers(): List<User> {
        return userRepository.getAllUsers()
    }

    fun deleteUserById(id: Long) {
        userRepository.deleteUserById(id)
    }
}
