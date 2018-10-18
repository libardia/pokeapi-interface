package info.tonyl.pokeapi.exceptions;

import info.tonyl.pokeapi.models.ApiResource;

public class UndefinedResourceClassException extends RuntimeException {
	private static final long serialVersionUID = 7641793669073849082L;

	public UndefinedResourceClassException(ApiResource<?> apiResource) {
		super(makeMsg(apiResource));
	}

	private static String makeMsg(ApiResource<?> apiResource) {
		StringBuilder sb = new StringBuilder();

		sb.append("ApiResource with name ");
		sb.append(apiResource.getName());
		sb.append(" has no associated resourceClass, but resolve was called without a class argument.");

		return sb.toString();
	}
}
