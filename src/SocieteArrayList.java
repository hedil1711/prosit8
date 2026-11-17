import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SocieteArrayList implements IGestion<Employe>, IRechercheAvancee<Employe> {

    private ArrayList<Employe> employes = new ArrayList<>();

    @Override
    public void ajouterEmploye(Employe e) {
        if (employes.contains(e)) {                 // basé sur equals (id)
            System.out.println("Employé déjà présent : " + e.getNom());
            return;
        }
        employes.add(e);
    }

    @Override
    public boolean rechercherEmploye(String nom) {
        for (Employe e : employes) {
            if (e.getNom().equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherEmploye(Employe e) {
        return employes.contains(e);
    }

    @Override
    public void supprimerEmploye(Employe e) {
        if (!employes.remove(e)) {
            System.out.println("Suppression impossible : employé introuvable.");
        }
    }

    @Override
    public void displayEmploye() {
        for (Employe e : employes) {
            System.out.println(e);
        }
    }

    // Tri naturel (Comparable) : par id
    @Override
    public void trierEmployeParId() {
        Collections.sort(employes);
    }

    // Tri personnalisé (Comparator) : département, puis grade, puis nom
    @Override
    public void trierEmployeParNomDepartementEtGrade() {
        Comparator<Employe> comparateur = Comparator
                .comparing(Employe::getNomDepartement)
                .thenComparingInt(Employe::getGrade)
                .thenComparing(Employe::getNom);
        employes.sort(comparateur);
    }

    @Override
    public List<Employe> rechercherParDepartement(String nomDepartement) {
        List<Employe> resultat = new ArrayList<>();
        for (Employe e : employes) {
            if (e.getNomDepartement().equalsIgnoreCase(nomDepartement)) {
                resultat.add(e);
            }
        }
        return resultat;
    }
}