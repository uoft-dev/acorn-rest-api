package dev.murad.acorn

import auth.Acorn
import entity.enrol.EnrolledCourse
import exception.LoginFailedException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    @GetMapping("/auth")
    fun greeting(@RequestParam(value = "utorid") utorid: String,
                 @RequestParam(value = "password") password: String): MutableList<EnrolledCourse>? {
        val acorn = Acorn(utorid, password)
        try {
            acorn.doLogin()
        } catch (e: LoginFailedException) {
            error(e.localizedMessage)
        }
        return (acorn.courseManager.appliedCourses)
    }

}