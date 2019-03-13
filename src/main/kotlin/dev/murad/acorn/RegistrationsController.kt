package dev.murad.acorn

import auth.Acorn
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException

@RestController
@RequestMapping("/registrations")
class RegistrationsController {


    @PostMapping("/eligible")
    fun eligible(account: Account): MutableList<String>? {
        val acorn = Acorn(account.utorid, account.password)

        try {
            acorn.doLogin()
        } catch (e: RuntimeException) {
            throw AuthException("Authentication Error")
        }

        return (acorn.registrationManager.eligibleRegistrations)
    }
}