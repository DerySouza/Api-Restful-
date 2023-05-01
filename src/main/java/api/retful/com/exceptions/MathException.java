package api.retful.com.exceptions;

public class MathException extends RuntimeException {
    private  static final long serialVersionUID = 1L;
    public MathException(String mensagem) {super(mensagem);}
    public MathException(String mensagem, Throwable causa) {super(mensagem,causa);}
}
