import java.util.Objects;

public class Departement implements Comparable<Departement> {
    private int id;
    private String nomDepartement;
    private int nombreEmployes;

    public Departement() {}

    public Departement(int id, String nomDepartement, int nombreEmployes) {
        this.id = id;
        this.nomDepartement = nomDepartement;
        this.nombreEmployes = nombreEmployes;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNomDepartement() { return nomDepartement; }
    public void setNomDepartement(String nomDepartement) { this.nomDepartement = nomDepartement; }

    public int getNombreEmployes() { return nombreEmployes; }
    public void setNombreEmployes(int nombreEmployes) { this.nombreEmployes = nombreEmployes; }

    // Tri naturel : par id
    @Override
    public int compareTo(Departement autre) {
        return Integer.compare(this.id, autre.id);
    }

    // Égalité selon l'id et le nom
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departement)) return false;
        Departement d = (Departement) o;
        return id == d.id && Objects.equals(nomDepartement, d.nomDepartement);
    }

    // Indispensable pour un HashSet : cohérent avec equals()
    @Override
    public int hashCode() {
        return Objects.hash(id, nomDepartement);
    }

    @Override
    public String toString() {
        return "Departement{id=" + id + ", nom='" + nomDepartement
                + "', nombreEmployes=" + nombreEmployes + "}";
    }
}