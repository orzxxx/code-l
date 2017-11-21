package test.boot.common.exception;

/**
 * 业务异常
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public String message;

	public BusinessException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
