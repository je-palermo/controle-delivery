package br.com.palermo.delivery.exception;

public class DbException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DbException(String msg) {
        super(msg);
    }
}
