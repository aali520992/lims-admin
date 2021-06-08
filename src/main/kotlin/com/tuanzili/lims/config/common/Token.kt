package com.tuanzili.lims.config.common

import com.fasterxml.jackson.annotation.JsonIgnore
import com.jxpanda.common.encrypt.toPrivateKey
import com.jxpanda.common.encrypt.toPublicKey
import com.jxpanda.common.utils.CodeUtil
import com.jxpanda.common.utils.JacksonUtil
import com.jxpanda.common.utils.fromJson
import com.jxpanda.common.utils.toJson
import com.tuanzili.lims.entity.User
import io.jsonwebtoken.Jwts
import java.time.LocalDateTime
import io.jsonwebtoken.*

data class Token(
    /**
     * token的ID
     * */
    val id: String = CodeUtil.nextIdString(),
    /**
     * 签发token的userId
     * */
    val userId: String = "",
    /**
     * 用户的权限
     * */
    val authorities: List<String> = emptyList(),

    /**
     * token有效期（默认1天）
     * */
    val duration: Int = DURATION_1_DAYS,
    /**
     * token签发日期
     * */
    val signTime: LocalDateTime = LocalDateTime.now(),
    /**
     * token过期时间
     * */
    val expireTime: LocalDateTime = signTime.plusSeconds(duration.toLong()),
    /**
     * token有效性的标识
     * */
    @JsonIgnore
    var effective: Boolean = userId.isNotBlank() && LocalDateTime.now().isBefore(expireTime)
) {

    fun signature(): String {
        return Jwts.builder()
            .setPayload(JacksonUtil.JACKSON.writeValueAsString(this))
            .signWith(SignatureAlgorithm.RS256, PRIVATE_KEY)
            .compact()
    }

    fun toUser(): User {
        return User().apply {
            this.id = userId
        }
    }

    companion object {
        const val DURATION_1_DAYS = 365 * 24 * 60 * 60

        /**
         * 验证签名
         * */
        fun validate(token: String): Token {
            return try {
                Jwts.parser().setSigningKey(PUBLIC_KEY).parse(token, Handler())
            } catch (ex: Exception) {
                Token()
            }
        }

    }

    internal class Handler : JwtHandlerAdapter<Token>() {
        override fun onClaimsJws(jws: Jws<Claims>): Token {
            return jws.body.toJson().fromJson()
        }
    }

}
private val PUBLIC_KEY = """
                MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgK
                CAQEAhn4f5Fgn9cmtFOLz2chaMnX3ds4KHEFi7k
                t/DONkSFx+PZn+bMo+7nQRfCjno/g6OtBHr0IKV
                Qm3qPUR2wbvolFgqPLc0dqWvPFCM9kx93Cv4GzR
                hZMhFKTyXJdEuVwlToLG36GihWLuc0nyMY82xJ7
                F2tudJHhbIWg6V1JAR0rCDMwvbYiltwZyhwMqqe
                11tw7D8h5jH25ZlEuyqaWmwwz2rtaS1LXa7CFag
                HdadyCflBMOrFVis8ImK5dIh00jvQOSKwGGx5Qy
                WjGacszLE8YH8aDdLnyA2sZLz7F+qYVIXKd5Fpz
                YYY6DWGtQX3r4Qlc+28rPO2HzjgOeG4iwWQIDAQ
                AB
            """.trimIndent().replace("\n", "").toPublicKey()

private val PRIVATE_KEY = """
                MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggS
                iAgEAAoIBAQCGfh/kWCf1ya0U4vPZyFoydfd2zg
                ocQWLuS38M42RIXH49mf5syj7udBF8KOej+Do60
                EevQgpVCbeo9RHbBu+iUWCo8tzR2pa88UIz2TH3
                cK/gbNGFkyEUpPJcl0S5XCVOgsbfoaKFYu5zSfI
                xjzbEnsXa250keFshaDpXUkBHSsIMzC9tiKW3Bn
                KHAyqp7XW3DsPyHmMfblmUS7KppabDDPau1pLUt
                drsIVqAd1p3IJ+UEw6sVWKzwiYrl0iHTSO9A5Ir
                AYbHlDJaMZpyzMsTxgfxoN0ufIDaxkvPsX6phUh
                cp3kWnNhhjoNYa1BfevhCVz7bys87YfOOA54biL
                BZAgMBAAECggEAMmlSIPAeQlXO55ZOGuKrVGC9W
                i3OwlqL75Ai1jzhmPH6a7KuGC8SuaSN7UET2nUv
                tl3dkMarQsa6rbz2bWfDKM9h8NHfjVVmzPmNfAu
                8W+hENFX1jyDf9HIDWktk+imc3jnMu4RFe8PiZx
                pfis4IlFiDBw7sbwAiAHql65cr+sxyYP0/D42CH
                af/U/kzqpO2gu+44LvfIRmX2icMeidbMZxXt5bl
                lDENHC9zS08OWCRiS0b8BJTERybaVXSB9q5gKRb
                NgC5YWIWs62mNPwicvXrmcprwNPkgUhjzuLE5Po
                BR39S+yBwic50uWqRGirvIqEl37Jcrj6EtBiARh
                AhLAQKBgQDFnnufmXi+7poeyNFUlV8pEPHoWxy+
                sFwMkh29M24oE9nK+PBZUM9nOXLqjNEQP6zcnQ2
                Phc3STgehx63+gRHOsuE6MzmzkwuTvGFzWVVUUD
                wkoHtfQ/22MFIC5tFud/1V8gqk/GOZ357pL0XFi
                QwQQVfrC+HchHfUGd4OMuVBIQKBgQCuOYYt1rQF
                I3Z08hOzlobY5HNgql8yL2O+d9u1BksdVszxyhw
                8lq7sh+VfomwMd9kywhFaY3nJ3IfH8tTBOLg2cA
                4evpmvLhfTLkTICljGhG5IWLVUO0nT0D04apm9o
                3jVBCzFoPOSXDbtFcmlJsHoeNy583TE/4slfrPb
                1mcwOQKBgFL33dk8+vfWfzhrgY9sgx5fseCm2CO
                rMYpJkljMDfSfmPHhoC8vgVRKR1f4NRIIWc/p1D
                asq6QfBI9EoWVX1R0d9veTaCdflh25moRuPif+4
                7FQ+1sc1Zk3Ikd7lvQ1RlReIV/xYvPIchRet4Fe
                r4TnmjzhqTsHFrQjBBqb/aphAoGAVODBdeN7oGU
                +eIrW/k7/MvtZGmbmKdTcixZpey+tuIVpIwKL7x
                iZ77HlFUpTyV85+XiCa766vpUpsUekTt4LILpGp
                sPEq4uRH9kSuUIRLeWmtKhC7t5TgVWZ/boxXCof
                2+dEyKM5BrzWJXrP2h2fqln3bsAkyzST3Zh0l01
                EyEECgYBQHOBrCwPVXVbh8Wt2DjIWqvQInM3aKi
                La68g++cDzulCA+vwR2GoPaVQnifO1Z5KShrz7k
                KAe66RsSCUsWixi8YibJ1Tx6Bh2AfNy45c4AYIm
                hkDVslIWgvgp4yeO7tOP4UXJiK9xw08oruo0rep
                38k5jHrbkytyI1SrzB2nerA==
            """.trimIndent().toPrivateKey()