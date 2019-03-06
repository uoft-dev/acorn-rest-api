package dev.murad.acorn

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(code = HttpStatus.FORBIDDEN)
class AuthException(message: String) : RuntimeException(message)