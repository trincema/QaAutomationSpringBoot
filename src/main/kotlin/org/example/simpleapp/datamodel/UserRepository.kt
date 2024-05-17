package org.example.simpleapp.datamodel

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.sql.ResultSet
import java.util.*

@Repository
class UserRepository(private val jdbcTemplate: JdbcTemplate) {

    fun createUser(name: String, email: String) {
        val sql = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)"
        jdbcTemplate.update(sql, UUID.randomUUID().toString(), name, email)
    }

    fun getUserById(id: Long): User? {
        val sql = "SELECT * FROM users WHERE id = ?"
        return jdbcTemplate.queryForObject(sql, arrayOf(id), UserRowMapper())
    }

    fun getAllUsers(): List<User> {
        val sql = "SELECT * FROM users"
        return jdbcTemplate.query(sql, UserRowMapper())
    }

    fun deleteUserById(id: Long) {
        val sql = "DELETE FROM users WHERE id = ?"
        jdbcTemplate.update(sql, id)
    }

    private class UserRowMapper : RowMapper<User> {
        override fun mapRow(rs: ResultSet, rowNum: Int): User {
            return User(
                id = rs.getLong("id"),
                name = rs.getString("name"),
                email = rs.getString("email")
            )
        }
    }
}
