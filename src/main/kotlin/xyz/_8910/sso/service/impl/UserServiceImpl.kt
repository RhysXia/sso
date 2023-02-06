package xyz._8910.sso.service.impl

import org.springframework.stereotype.Service
import xyz._8910.sso.model.User
import xyz._8910.sso.service.UserService

@Service
class UserServiceImpl: UserService {
    override suspend fun login(username: String, password: String): User {
        TODO("Not yet implemented")
    }

    override suspend fun generateTicket(user: User): String {
        TODO("Not yet implemented")
    }
}