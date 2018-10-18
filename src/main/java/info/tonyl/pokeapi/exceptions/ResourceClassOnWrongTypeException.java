package info.tonyl.pokeapi.exceptions;

import java.lang.reflect.Field;

public class ResourceClassOnWrongTypeException extends RuntimeException {
	private static final long serialVersionUID = 6100928359856545038L;

	public ResourceClassOnWrongTypeException(Field f) {
		super(makeMsg(f));
	}

	private static String makeMsg(Field f) {
		StringBuilder sb = new StringBuilder();

		sb.append("Scanner failed to cast the value of the field. ");
		sb.append("Field ");
		sb.append(f.getName());
		sb.append(" on the class ");
		sb.append(f.getDeclaringClass().getName());
		sb.append(" was type ");
		sb.append(f.getType().getSimpleName());

		return sb.toString();
	}
}
