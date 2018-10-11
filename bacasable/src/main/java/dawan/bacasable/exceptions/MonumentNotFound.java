package dawan.bacasable.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class MonumentNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MonumentNotFound(int id) {
		super("Le monument " + id + " n'a pas été trouvé.");
	}

}
