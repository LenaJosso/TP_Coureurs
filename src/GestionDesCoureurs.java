import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

public class GestionDesCoureurs {
    ArrayList<Coureur> listeDesCoureurs = new ArrayList();
    public void lectureFichier() throws IOException {
        Path chemin = Paths.get("course.txt");
        BufferedReader lecture = Files.newBufferedReader(chemin);

        while (lecture.ready()){
            String ligne = null;
            ligne = lecture.readLine();
            if (ligne != null){
                String[] split = ligne.split(",");
                if (split.length == 5){
                    int duree = Integer.parseInt(split[4].trim());
                    Categorie categorie = Categorie.valueOf(split[3].trim().toString());
                    Coureur coureurs = new Coureur(split[1].trim().toUpperCase(), split[2].trim(), Genre.valueOf(split[0].trim()), LocalTime.ofSecondOfDay(duree), categorie);
                    listeDesCoureurs.add(coureurs);
                }
            }
        }
    }
    public void affichage(){
        listeDesCoureurs.forEach(System.out::println);
    }

    public void trierParNomCroissant() {
        listeDesCoureurs.sort(Comparator.comparing (Coureur :: getNom));
        }

    public void trierParNomDecroissant() {
        listeDesCoureurs.sort(Comparator.comparing (Coureur :: getNom).reversed());
    }

    public void trierParPrenomCroissant (){
        listeDesCoureurs.sort(Comparator.comparing(Coureur :: getPrenom));
    }

    public void trierParPrenomDecroissant() {
        listeDesCoureurs.sort(Comparator.comparing (Coureur :: getPrenom).reversed());
    }

    public void trierParCategorieCroissant (){
        listeDesCoureurs.sort(Comparator.comparing(Coureur :: getCategorie));
    }

    public void trierParCategorieDecroissant() {
        listeDesCoureurs.sort(Comparator.comparing (Coureur :: getCategorie).reversed());
    }

    public void trierParTempsCroissant (){
        listeDesCoureurs.sort(Comparator.comparing(Coureur :: getTemps));
    }

    public void trierParTempsDecroissant (){
        listeDesCoureurs.sort(Comparator.comparing(Coureur :: getTemps).reversed());
    }

    public void AjouterUnCoureur (){
        System.out.println("Rentrez le nom");
    }


    public ArrayList<Coureur> getListeDesCoureurs() {
        return listeDesCoureurs;
    }

    public void setListeDesCoureurs(ArrayList<Coureur> listeDesCoureurs) {
        this.listeDesCoureurs = listeDesCoureurs;
    }
}
