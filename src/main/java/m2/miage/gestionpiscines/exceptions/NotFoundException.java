package m2.miage.gestionpiscines.exceptions;

public class NotFoundException extends Exception{

    private static final long serialVersionUID = 2072764419774593801L;

    public NotFoundException(String s) { super(s);}

    public NotFoundException(Throwable t) {super(t);}
}
