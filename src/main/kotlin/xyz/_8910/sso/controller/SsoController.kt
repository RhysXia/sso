package xyz._8910.sso.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.buildAndAwait
import org.springframework.web.reactive.function.server.json
import org.springframework.web.util.UriComponentsBuilder
import xyz._8910.sso.model.User
import xyz._8910.sso.service.UserService

@RestController
@RequestMapping("/")
class SsoController(private val userService: UserService) {
    @GetMapping("/login")
    suspend fun login(
            @RequestParam("redirect") redirect: String,
            @SessionAttribute("user", required = false) user: User?,
    ): ResponseEntity<Any> {

        if (user !== null) {
            val ticket = userService.generateTicket(user)
            val uri = UriComponentsBuilder.fromUriString(redirect)
                    .queryParam("ticket", ticket)
                    .build()
                    .toUri()
            return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT).location(uri).build<Any>()
        }

        println("=====")

        return ResponseEntity.ok("hello world")

    }
}