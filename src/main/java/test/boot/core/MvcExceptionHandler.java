package test.boot.core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import test.boot.common.exception.BusinessException;

@ControllerAdvice
public class MvcExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public void defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Throwable ex) {
    	if (ex instanceof BusinessException) {
    		responseError(response, HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
		} else {
			responseError(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "系统错误");
		}
    }

   /* private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }*/

    public static void responseError(HttpServletResponse response, int status, String msg) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		response.setStatus(status);
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.append(msg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}