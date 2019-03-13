package dev.murad.acorn

import auth.Acorn

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.RuntimeException


@RestController
@RequestMapping("/grades")
class GradesController {

    @PostMapping("/transcript")
    fun transcript(account: Account): String? {
        val acorn = Acorn(account.utorid, account.password)

        try {
            acorn.doLogin()
        } catch (e: RuntimeException) {
            throw AuthException("Authentication Error")
        }

        return (acorn.gradeManager.gradeHtml)
    }


}