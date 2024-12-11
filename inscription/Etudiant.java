package inscription; 
public class Etudiant {

    private String matricule;
    private String nom;
    private String prenom;
    private int age;

    public Etudiant(String matricule, String nom, String prenom, String classe) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public String getId() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "matricule=" + matricule +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", classe='" + age + '\'' +
                '}';
    }

    public Object getMatricule() {
        throw new UnsupportedOperationException("Unimplemented method 'getMatricule'");
    }   



}
