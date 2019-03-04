package dev.murad.acorn
import com.fasterxml.jackson.annotation.JsonCreator


data class Account @JsonCreator constructor(
        val utorid: String,
        val password: String
)

