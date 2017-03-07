package net.yanrc.xpring.web.controllor;

import net.yanrc.xpring.exception.DataNotFoundException;
import net.yanrc.xpring.exception.ErrorInfo;
import net.yanrc.xpring.exception.StatusInfo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yanricheng on 2017/3/6.
 */
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Throwable.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorInfo handleDataNotFoundException(HttpServletRequest request, HttpServletResponse rsp, Throwable ex)
            throws IOException {
        if (ex instanceof DataNotFoundException) {
            return StatusInfo.DataNotFoundException.getErrorInfo();
        } else {
            return StatusInfo.DataNotFoundException.getErrorInfo();
        }
    }

    /**
     */
    private ResponseEntity<Object> getResponseEntity(RuntimeException ex, WebRequest request, String body) {
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.OK, request);
    }
}
