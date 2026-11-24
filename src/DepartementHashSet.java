import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class DepartementHashSet implements IDepartement<Departement> {

    private HashSet<Departement> departements = new HashSet<>();

    @Override
    public void ajouterDepartement(Departement d) {
        if (!departements.add(d)) {      // add() renvoie false si equals/hashCode trouve un doublon
            System.out.println("Département déjà présent : " + d.getNomDepartement());
        }
    }

    @Override
    public boolean rechercherDepartement(String nomDepartement) {
        for (Departement d : departements) {
            if (d.getNomDepartement().equalsIgnoreCase(nomDepartement)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherDepartement(Departement d) {
        return departements.contains(d);
    }

    @Override
    public void supprimerDepartement(Departement d) {
        if (!departements.remove(d)) {
            System.out.println("Suppression impossible : département introuvable.");
        }
    }

    @Override
    public void afficherDepartements() {
        for (Departement d : departements) {
            System.out.println(d);
        }
    }

    // Un HashSet n'est pas ordonné : on trie une copie sous forme de liste
    @Override
    public void trierDepartementsParId() {
        List<Departement> liste = new ArrayList<>(departements);
        Collections.sort(liste);
        liste.forEach(System.out::println);
    }

    @Override
    public void trierDepartementsParNomEtNombreEmployes() {
        List<Departement> liste = new ArrayList<>(departements);
        liste.sort(Comparator.comparing(Departement::getNomDepartement)
                .thenComparingInt(Departement::getNombreEmployes));
        liste.forEach(System.out::println);
    }
}