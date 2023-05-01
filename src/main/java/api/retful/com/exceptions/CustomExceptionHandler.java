package api.retful.com.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@Data
@AllArgsConstructor
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

}
