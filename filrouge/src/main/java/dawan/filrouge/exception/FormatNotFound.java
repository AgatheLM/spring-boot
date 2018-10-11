package dawan.filrouge.exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class FormatNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FormatNotFound(String nom) {
		super("Le format " + nom + " n'a pas été trouvé.");
	}

}
