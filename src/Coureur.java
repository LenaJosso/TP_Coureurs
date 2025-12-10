import java.time.LocalTime;

public class Coureur extends Personne {
    LocalTime temps;
    Categorie categorie;

    public Coureur() {
    }

    public Coureur(String nom, String prenom, Genre genre, LocalTime temps, Categorie categorie) {
        super(nom, prenom, genre);
        this.temps = temps;
        this.categorie = categorie;
    }

    public LocalTime getTemps() {
        return temps;
    }

    public void setTemps(LocalTime temps) {
        this.temps = temps;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Coureur(LocalTime temps, Categorie categorie) {
        this.temps = temps;
        this.categorie = categorie;
    }
@Override
    public String toString() {
        return getNom() + " " + getPrenom() + " " + getGenre() + " " + getTemps() + " " + getCategorie() + "\n";
}


}
