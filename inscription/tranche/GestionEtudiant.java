package inscription.tranche;
import java.util.ArrayList;
import java.util.List;  

public class GestionEtudiant {
    private List<Etudiant> etudiants;

    public GestionEtudiant() {
        this.etudiants = new ArrayList<>();
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
        System.out.println("Étudiant ajouté avec succès : " + etudiant);
    }

    public void listerEtudiants() {
        if (etudiants.isEmpty()) {
            System.out.println("Aucun étudiant inscrit.");
        } else {
            System.out.println("Liste des étudiants inscrits :");
            for (Etudiant etudiant : etudiants) {
                System.out.println(etudiant);
            }
        }
    }

    public void supprimerEtudiant(String matriculeASupprimer) {
        Etudiant etudiantASupprimer = null;
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getMatricule().equals(matriculeASupprimer)) {
                etudiantASupprimer = etudiant;
                break;
            }
        }

        if (etudiantASupprimer != null) {
            etudiants.remove(etudiantASupprimer);
            System.out.println("Étudiant supprimé avec succès : " + etudiantASupprimer);
        } else {
            System.out.println("Étudiant avec le matricule " + matriculeASupprimer + " non trouvé.");
        }
    }

}
