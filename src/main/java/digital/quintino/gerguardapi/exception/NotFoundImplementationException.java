package digital.quintino.gerguardapi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class NotFoundImplementationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NotFoundImplementationException(String erro) { 
		super(erro);
	}

}
