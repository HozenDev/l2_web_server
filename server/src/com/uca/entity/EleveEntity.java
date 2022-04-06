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

    // Getters //
    
    public String getGommette(int index) {
	return this.listGommettes.get(index);
    }

    public int getId() {
	return this.id;
    }

    public String getLastName() {
	return this.lastname;
    }

    public String getFirstName() {
	return this.firstname;
    }

    // Setters //

    public void setGommette(GommetteAttribuee src) {
	this.listGommettes.add(src);
    }

    public void setLastName(String lastname) {
	this.lastname = lastname;
    }

    public void setFirstName(String firstname) {
	this.firstname = firsname;
    }

    public void setId(int id) {
	this.id = id;
    }
}
