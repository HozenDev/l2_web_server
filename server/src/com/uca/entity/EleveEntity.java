import java.util.ArrayList;

public class Eleve {

    private ArrayList<GommetteAttribuee> listGommettes;
    private int id;
    private String lastname;
    private String firstname;
    
    public Eleve(String lastname, String firstname, int id) {
	this.lastname = lastname;
	this.firstname = firstname;
	this.id = id;
	this.listGommettes = new ArrayList<>();
    }

    public void setGommette(GommetteAttribuee src) {
	this.listGommettes.add(src);
    }    
}
