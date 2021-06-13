package m2.miage.gestionpiscines.exceptions;

public class ForbiddenException extends Exception{
    private static final long serialVersionUID = 659733065540443376L;

    public ForbiddenException(String s) { super(s);}

    public ForbiddenException(Throwable t) {super(t);}
}
