package dev.murad.acorn.auth

import auth.Acorn
import dev.murad.acorn.crypt.Encryption
import entity.enrol.EnrolledCourse
import exception.LoginFailedException
import org.springframework.web.bind.annotation.*

@RestController
class AcornController {

    private var enc: Encryption = Encryption()

    @PostMapping("/auth")
    fun auth(account: Account): MutableList<EnrolledCourse>? {

        val password = enc.decrypt(account.password)

        val acorn = Acorn(account.utorid, password)
        try {
            acorn.doLogin()
        } catch (e: LoginFailedException) {
            error(e.localizedMessage)
        }

        return (acorn.courseManager.appliedCourses)
    }

    @GetMapping("/auth/key")
    fun authKey(): String {
        return "-----BEGIN PUBLIC KEY-----\n${enc.pubkey}\n-----END PUBLIC KEY-----"


    }
}