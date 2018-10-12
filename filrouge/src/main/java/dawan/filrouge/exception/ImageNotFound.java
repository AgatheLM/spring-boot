package dawan.filrouge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class ImageNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ImageNotFound(String nom) {
		super("L'image " + nom + " n'a pas été trouvé.");
	}

}
