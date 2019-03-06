package dev.murad.acorn

import auth.Acorn
import entity.enrol.EnrolledCourse
import exception.LoginFailedException
import org.springframework.web.bind.annotation.*
import java.lang.NullPointerException
import java.lang.RuntimeException

@RestController
class AcornController {

    @PostMapping("/auth")
    fun auth(account: Account): MutableList<EnrolledCourse>? {
        val acorn = Acorn(account.utorid, account.password)

        try {
            acorn.doLogin()
        } catch (e: RuntimeException) {
            throw AuthException("Authentication Error")
        }

        return (acorn.courseManager.appliedCourses)
    }

}