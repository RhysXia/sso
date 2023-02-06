package xyz._8910.sso.service

import xyz._8910.sso.model.User

interface UserService {
    suspend fun login(username: String, password: String): User

    suspend fun generateTicket(user: User): String
}