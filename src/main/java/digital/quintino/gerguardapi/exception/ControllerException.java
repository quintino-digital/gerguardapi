package digital.quintino.gerguardapi.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import digital.quintino.gerguardapi.dto.ExceptionResponseDTO;
import digital.quintino.gerguardapi.utility.DateUtility;

@ControllerAdvice
public class ControllerException {
	
	@ExceptionHandler(NotFoundImplementationException.class)
	public ResponseEntity<ExceptionResponseDTO> notFoundImplementationException(NotFoundImplementationException notFoundImplementationException, WebRequest webRequest) {
		ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO();
			exceptionResponseDTO.setApi("GERGUARDAPI - Gerenciador de Acessos");
			exceptionResponseDTO.setData(DateUtility.formatarData(new Date()));
			exceptionResponseDTO.setErro(HttpStatus.NOT_FOUND.value());
			exceptionResponseDTO.setMensagem(notFoundImplementationException.getMessage());
		return new ResponseEntity<ExceptionResponseDTO>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
	}

}
