package io.github.tandemdude.disjord.exceptions;

public class RequestFailedException extends DisjordException {
    public RequestFailedException(String errorMessage) {
        super(errorMessage);
    }
}
