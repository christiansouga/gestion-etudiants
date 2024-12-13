package examen.semestre1;

public class Note {
    private String etudiant;
    private Matiere matiere;
    private double valeur;

    public Note(String etudiant, Matiere matiere, double valeur) {
        this.etudiant = etudiant;
        this.matiere = matiere;
        this.valeur = valeur;
    }

    public String getEtudiant() {
        return etudiant;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return etudiant + " - " + matiere + ": " + valeur;
    }
}

