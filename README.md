# Acorn REST API
![Made with Java](https://img.shields.io/badge/Made%20with-Java-green.svg?style=flat-square&logo=Java)
![Made with Kotlin](https://img.shields.io/badge/-Kotlin-green.svg?style=flat-square&logo=kotlin)
![Version](https://img.shields.io/badge/Version-1.0.1-green.svg?style=flat-square)
[![Test Here](https://img.shields.io/badge/Test-Here-informational.svg?style=flat-square)](https://acorn-rest.herokuapp.com/auth)

A REST API to fetch currently enrolled courses for UofT Acorn Students.

Uses [this](https://github.com/LesterLyu/AcornAPI) acorn API, written in java


`endpoint`: `/auth`

`method`: `POST`

----------

`utorid`: the utorid to log in with

`password`: the password to log in with

----------

`response`: list of all currently enrolled courses for this `utorid`, or a `FORBIDDEN` error. 
