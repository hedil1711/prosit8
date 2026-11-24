public class MainDepartement {
    public static void main(String[] args) {
        DepartementHashSet gestion = new DepartementHashSet();

        Departement d1 = new Departement(3, "Informatique", 12);
        Departement d2 = new Departement(1, "RH", 4);
        Departement d3 = new Departement(2, "Finance", 6);

        gestion.ajouterDepartement(d1);
        gestion.ajouterDepartement(d2);
        gestion.ajouterDepartement(d3);
        gestion.ajouterDepartement(new Departement(1, "RH", 9)); // doublon (même id + nom)

        System.out.println("--- Affichage ---");
        gestion.afficherDepartements();

        System.out.println("\n--- Recherche ---");
        System.out.println("Finance existe ? " + gestion.rechercherDepartement("Finance"));
        System.out.println("Marketing existe ? " + gestion.rechercherDepartement("Marketing"));
        System.out.println("d1 existe ? " + gestion.rechercherDepartement(d1));

        System.out.println("\n--- Tri par id ---");
        gestion.trierDepartementsParId();

        System.out.println("\n--- Tri par nom puis nombre d'employés ---");
        gestion.trierDepartementsParNomEtNombreEmployes();

        System.out.println("\n--- Suppression de d2 ---");
        gestion.supprimerDepartement(d2);
        gestion.afficherDepartements();
    }
}