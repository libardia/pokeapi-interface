package info.tonyl.pokeapi.exceptions;

import java.lang.reflect.Field;

public class ApiResourceScannerException extends RuntimeException {
	private static final long serialVersionUID = 5095763027035725105L;

	public ApiResourceScannerException(Field f, Throwable t) {
		super(makeMsg(f), t);
	}

	private static String makeMsg(Field f) {
		StringBuilder sb = new StringBuilder();

		sb.append("Exception while performing ApiResource scanning. Field was ");
		sb.append(f.getName());
		sb.append(" on class ");
		sb.append(f.getDeclaringClass().getName());

		return sb.toString();
	}
}
