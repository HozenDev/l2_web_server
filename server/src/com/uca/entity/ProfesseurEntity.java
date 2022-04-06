import java.util.ArrayList;

public class Professeur {

    private int id;
    private String lastname;
    private String firstname;
    private String classe;
    private ArrayList<GommetteAttribuee> listGomette;

    public Professeur(String lastname, String firstname, int id) {
	this.lastname = lastname;
	this.firstname = firstname;
	this.id = id;
    }
}
