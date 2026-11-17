import java.util.List;

public class MainSociete {
    public static void main(String[] args) {

        SocieteArrayList societe = new SocieteArrayList();

        Employe e1 = new Employe(3, "Ben Ali", "Sami", "Informatique", 2);
        Employe e2 = new Employe(1, "Trabelsi", "Aya", "RH", 3);
        Employe e3 = new Employe(2, "Gharbi", "Omar", "Informatique", 1);
        Employe e4 = new Employe(4, "Amri", "Nour", "Finance", 2);
        Employe e5 = new Employe(5, "Chaabane", "Yassine", "Informatique", 2);

        societe.ajouterEmploye(e1);
        societe.ajouterEmploye(e2);
        societe.ajouterEmploye(e3);
        societe.ajouterEmploye(e4);
        societe.ajouterEmploye(e5);
        societe.ajouterEmploye(new Employe(3, "Doublon", "Test", "RH", 1)); // même id

        System.out.println("--- Liste initiale ---");
        societe.displayEmploye();

        System.out.println("\n--- Recherche ---");
        System.out.println("Gharbi existe ? " + societe.rechercherEmploye("Gharbi"));
        System.out.println("Karray existe ? " + societe.rechercherEmploye("Karray"));
        System.out.println("e4 existe ? " + societe.rechercherEmploye(e4));

        System.out.println("\n--- Tri naturel (par id) ---");
        societe.trierEmployeParId();
        societe.displayEmploye();

        System.out.println("\n--- Tri personnalisé (département, grade, nom) ---");
        societe.trierEmployeParNomDepartementEtGrade();
        societe.displayEmploye();

        System.out.println("\n--- Recherche par département : Informatique ---");
        List<Employe> info = societe.rechercherParDepartement("Informatique");
        for (Employe e : info) {
            System.out.println(e);
        }

        System.out.println("\n--- Suppression de e2 ---");
        societe.supprimerEmploye(e2);
        societe.displayEmploye();
    }
}