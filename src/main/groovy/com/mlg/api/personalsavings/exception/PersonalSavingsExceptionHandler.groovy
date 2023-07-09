package com.mlg.api.personalsavings.exception

import com.mlg.api.personalsavings.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class PersonalSavingsExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AccountException)
    def handleEntityNotFoundException(AccountException ex) {

        buildResponse(HttpStatus.NOT_FOUND, ex.getMessage())
    }

    private static ErrorResponse buildResponse(HttpStatus status, String message) {
        [
                code: status.value(),
                message: message
        ]
    }
}
