package dev.murad.acorn.auth
import com.fasterxml.jackson.annotation.JsonCreator


data class Account @JsonCreator constructor(
        val utorid: String,
        val password: String
)

