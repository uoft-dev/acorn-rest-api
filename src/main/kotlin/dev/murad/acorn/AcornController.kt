package dev.murad.acorn

import auth.Acorn
import entity.enrol.EnrolledCourse
import exception.LoginFailedException
import org.springframework.web.bind.annotation.*

@RestController
class AcornController {

    @PostMapping("/auth")
    fun auth(@RequestBody account: Account): MutableList<EnrolledCourse>? {
        val acorn = Acorn(account.utorid, account.password)
        try {
            acorn.doLogin()
        } catch (e: LoginFailedException) {
            error(e.localizedMessage)
        }
        return (acorn.courseManager.appliedCourses)
    }

}