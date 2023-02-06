package xyz._8910.sso.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant


enum class UserStatus {
    /**
     * 待激活
     */
    WAIT_ACTIVATE,

    /**
     * 已激活，正常处于此状态
     */
    ACTIVATED,

    /**
     * 过期，长时间未使用等情况，需要重新激活
     */
    EXPIRED,

    /**
     * 禁用，禁止登陆
     */
    FORBIDDEN,

    /**
     * 注销，账号不可用
     */
    LOGOUT
}

@Table
data class User(@Id val id: Long?, val username: String, val password: String, val createdAt: Instant, val updatedAt: Instant, val avatar: String?, val email: String?, val lastLoginAt: Instant?, val status: UserStatus)
