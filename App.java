import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import examen.Matiere;
import examen.Note;
import inscription.Etudiant;
import inscription.GestionEtudiant;

public class App {
    public static void main(String[] args) throws Exception {
      System.out.println("Hello, World!");

        GestionEtudiant gestionEtudiant = new GestionEtudiant();
        Scanner scanner = new Scanner(System.in);
        List<Matiere> matieres = Arrays.asList(
            new Matiere("Maths"),
            new Matiere("Génie Logiciel"),
            new Matiere("Réseau"),
            new Matiere("Architecture des Ordinateurs")
        );

        Map<String, List<Note>> notesParEtudiant = new HashMap<>();
        int choix;

        do {
            System.out.println("\n=== Menu de Gestion des Étudiants ===");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Lister les étudiants");
            System.out.println("3. Supprimer un étudiant");
            System.out.println("4. Saisir les notes des étudiants");
            System.out.println("5. Calculer la moyenne de la classe");
            System.out.println("6. Afficher la liste des admis");
            System.out.println("7. Afficher le premier et le dernier");
            System.out.println("8. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1: // Ajouter un étudiant
                    System.out.print("Matricule : ");
                    String matricule = scanner.nextLine();
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Classe : ");
                    String classe = scanner.nextLine();

                    Etudiant etudiant = new Etudiant(matricule, nom, prenom, classe);
                    gestionEtudiant.ajouterEtudiant(etudiant);
                    notesParEtudiant.put(matricule, new ArrayList<>());
                    break;

                case 2: // Lister les étudiants
                    gestionEtudiant.listerEtudiants();
                    break;

                case 3: // Supprimer un étudiant
                    System.out.print("Matricule de l'étudiant à supprimer : ");
                    String matriculeASupprimer = scanner.nextLine();
                    gestionEtudiant.supprimerEtudiant(matriculeASupprimer);
                    notesParEtudiant.remove(matriculeASupprimer);
                    break;

                case 4: // Saisir les notes des étudiants
                    for (String etudiantMatricule : notesParEtudiant.keySet()) {
                        System.out.println("Saisir les notes pour l'étudiant avec le matricule " + etudiantMatricule);
                        List<Note> notes = notesParEtudiant.get(etudiantMatricule);
                        for (Matiere matiere : matieres) {
                            System.out.print("Note en " + matiere.getNom() + ": ");
                            double valeur = scanner.nextDouble();
                            notes.add(new Note(etudiantMatricule, matiere, valeur));
                        }
                        scanner.nextLine(); // Consommer la ligne restante
                    }
                    break;

                case 5: // Calculer la moyenne de la classe
                    double somme = 0;
                    int totalNotes = 0;
                    for (List<Note> notes : notesParEtudiant.values()) {
                        for (Note note : notes) {
                            somme += note.getValeur();
                            totalNotes++;
                        }
                    }
                    System.out.println("Moyenne de la classe : " + (totalNotes > 0 ? somme / totalNotes : 0));
                    break;

                case 6: // Afficher la liste des admis
                    System.out.println("Liste des admis (moyenne >= 10) :");
                    for (Map.Entry<String, List<Note>> entry : notesParEtudiant.entrySet()) {
                        double moyenne = calculerMoyenne(entry.getValue());
                        if (moyenne >= 10) {
                            System.out.println(entry.getKey() + " avec une moyenne de " + moyenne);
                        }
                    }
                    break;

                case 7: // Afficher le premier et le dernier
                    Map.Entry<String, Double> premier = null, dernier = null;
                    Map<String, Double> moyennes = new HashMap<>();
                    for (Map.Entry<String, List<Note>> entry : notesParEtudiant.entrySet()) {
                        moyennes.put(entry.getKey(), calculerMoyenne(entry.getValue()));
                    }

                    for (Map.Entry<String, Double> entry : moyennes.entrySet()) {
                        if (premier == null || entry.getValue() > premier.getValue()) {
                            premier = entry;
                        }
                        if (dernier == null || entry.getValue() < dernier.getValue()) {
                            dernier = entry;
                        }
                    }

                    if (premier != null) {
                        System.out.println("Premier : " + premier.getKey() + " avec une moyenne de " + premier.getValue());
                    }
                    if (dernier != null) {
                        System.out.println("Dernier : " + dernier.getKey() + " avec une moyenne de " + dernier.getValue());
                    }
                    break;

                case 8: // Quitter
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 8);

        scanner.close();
    }

    private static double calculerMoyenne(List<Note> notes) {
        double somme = 0;
        for (Note note : notes) {
            somme += note.getValeur();
        }
        return notes.size() > 0 ? somme / notes.size() : 0;
    } 
    }

