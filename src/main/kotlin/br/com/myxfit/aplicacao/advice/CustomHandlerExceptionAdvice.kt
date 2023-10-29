package br.com.myxfit.aplicacao.advice

import br.com.myxfit.dominio.exception.RecursoNoContentException
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.time.LocalDateTime

@ControllerAdvice
class CustomHandlerExceptionAdvice {
    @ExceptionHandler(value = [RecursoNoContentException::class])
    protected fun handleRecursoNoContentException(
        ex: RecursoNoContentException,
        request: WebRequest
    ): ResponseEntity<ApiErrorResponse> {
        return ResponseEntity(
            ApiErrorResponse(
                NO_CONTENT.value(),
                listOf("${ex.message}")
            ),
            NO_CONTENT
        )
    }

    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    protected fun handleMethodArgumentNotValidException(
        ex: MethodArgumentNotValidException,
        request: WebRequest
    ): ResponseEntity<ApiErrorResponse> {
        val errors = mutableListOf<String>().also { list ->
            ex.bindingResult.allErrors.forEach { error ->
                list.add("${((error as? FieldError)?.field)} ${error.defaultMessage}")
            }
        }

        return ResponseEntity(
            ApiErrorResponse(BAD_REQUEST.value(), errors),
            BAD_REQUEST
        )
    }

    @ExceptionHandler(value = [HttpMessageNotReadableException::class])
    protected fun handleHttpMessageNotReadableException(
        ex: HttpMessageNotReadableException,
        request: WebRequest
    ): ResponseEntity<ApiErrorResponse> {
        return ResponseEntity(
            ApiErrorResponse(
                BAD_REQUEST.value(),
                listOf("${ex.message}")
            ),
            BAD_REQUEST
        )
    }

    data class ApiErrorResponse(
        @Schema(description = "Error status code")
        val status: Int,
        @Schema(description = "List of erros that occurred")
        val errors: List<String>?,
        @Schema(description = "Date and time of the request")
        val timestamp: LocalDateTime = LocalDateTime.now()
    )

    companion object {
        private val BAD_REQUEST = HttpStatus.BAD_REQUEST
        private val NOT_FOUND = HttpStatus.NOT_FOUND
        private val NO_CONTENT = HttpStatus.NO_CONTENT
    }
}