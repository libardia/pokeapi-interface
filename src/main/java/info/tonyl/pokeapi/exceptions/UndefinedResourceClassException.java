package info.tonyl.pokeapi.exceptions;

import info.tonyl.pokeapi.models.utility.ApiResource;

public class UndefinedResourceClassException extends RuntimeException {
	private static final long serialVersionUID = 7641793669073849082L;

	public UndefinedResourceClassException(ApiResource<?> apiResource) {
		super(makeMsg(apiResource));
	}

	private static String makeMsg(ApiResource<?> apiResource) {
		StringBuilder sb = new StringBuilder();

		sb.append("ApiResource with name ");
		sb.append(apiResource.getName());
		sb.append(" has no associated resourceClass, but resolve was called without ");
		sb.append("a class argument. Use one of the resolve methods that takes a class ");
		sb.append("argument.");

		return sb.toString();
	}
}
