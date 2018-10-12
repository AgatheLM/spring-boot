package dawan.filrouge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class FormatExisteDeja extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public FormatExisteDeja(String nom) {
			super("Le format " + nom + " existe déjà");
		}

	}


