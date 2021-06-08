
package com.tuanzili.lims.config.security


import com.fasterxml.jackson.annotation.JsonIgnore
import com.tuanzili.lims.config.common.Token
import com.tuanzili.lims.entity.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class JwtUser(
    @JsonIgnore
    val user: User,
    val id: String = user.id,
    val name: String = user.username,
    val nickname: String = user.nickname,
    val phone: String = user.phone,
    val avatar: String = user.avatar,
    val deleted: Boolean = user.deleted,
    val enable: Boolean = true,
    @JsonIgnore
    val pwd: String = user.password
) : UserDetails {
    fun signature(): String {
        return Token(userId = id, authorities = authorities.map { it.authority }).signature()
    }

    @JsonIgnore
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(GrantedAuthority {
            "USER"
        })
    }

    @JsonIgnore
    override fun isEnabled(): Boolean {
        return !deleted && enable
    }

    @JsonIgnore
    override fun getUsername(): String {
        return name
    }

    @JsonIgnore
    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    @JsonIgnore
    override fun getPassword(): String {
        return pwd
    }

    @JsonIgnore
    override fun isAccountNonExpired(): Boolean {
        return !deleted && enable
    }

    @JsonIgnore
    override fun isAccountNonLocked(): Boolean {
        return !deleted && enable
    }

    companion object {
        const val DEFAULT_PWD = "N/A"
    }
}