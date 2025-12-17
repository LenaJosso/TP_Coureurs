import clavier.In;
import org.w3c.dom.ls.LSOutput;

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

/**
 * Trier la liste par nom croissant
 *
 * @return La liste dans l'ordre demandé (ordre croissant des noms) */
    public void trierParNomCroissant() {
        listeDesCoureurs.sort(Comparator.comparing (Coureur :: getNom));
        }

    /**
     * Trier la liste par nom decroissant
     *
     * @return La liste dans l'ordre demandé (ordre decroissant des noms) */
    public void trierParNomDecroissant() {
        listeDesCoureurs.sort(Comparator.comparing (Coureur :: getNom).reversed());
    }


    /**
     * Trier la liste par prenom croissant
     *
     * @return La liste dans l'ordre demandé (ordre croissant des prenoms) */
    public void trierParPrenomCroissant (){
        listeDesCoureurs.sort(Comparator.comparing(Coureur :: getPrenom));
    }


    /**
     * Trier la liste par prenom decroissant
     *
     * @return La liste dans l'ordre demandé (ordre decroissant des prenoms) */
    public void trierParPrenomDecroissant() {
        listeDesCoureurs.sort(Comparator.comparing (Coureur :: getPrenom).reversed());
    }


    /**
     * Trier la liste par categorie croissante
     *
     * @return La liste dans l'ordre demandé (ordre croissant des categories) */
    public void trierParCategorieCroissant (){
        listeDesCoureurs.sort(Comparator.comparing(Coureur :: getCategorie));
    }


    /**
     * Trier la liste par categorie decroissante
     *
     * @return La liste dans l'ordre demandé (ordre decroissant des categories) */
    public void trierParCategorieDecroissant() {
        listeDesCoureurs.sort(Comparator.comparing (Coureur :: getCategorie).reversed());
    }
    /**
     * Trier la liste par temps croissant
     *
     * @return La liste dans l'ordre demandé (ordre croissant des temps) */
    public void trierParTempsCroissant (){
        listeDesCoureurs.sort(Comparator.comparing(Coureur :: getTemps));
    }


    /**
     * Trier la liste par temps decroissant
     *
     * @return La liste dans l'ordre demandé (ordre decroissant des temps) */
    public void trierParTempsDecroissant (){
        listeDesCoureurs.sort(Comparator.comparing(Coureur :: getTemps).reversed());
    }


    public void ModifierUnCoureur (int valeur2, String prenom, Genre genre){
        do {
            System.out.println("Que voulez vous changer ?");
            System.out.println( """
                    1 : Le nom
                    2 : Le prenom
                    3 : La categorie
                    4 : Le temps
                    5 : Le genre
                    6 : Fin de la modification
                    """ );

            valeur2 = In.readInteger();
            switch (valeur2) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Fin de la modification");
                    break;
            }
        } while (valeur2 != 6);
    }


    /**
     * Trier la liste par nom croissant
     *
     * @return Supprime un coureur à la ligne demande */
    public void SupprimerUnCoureur (int numero){
        listeDesCoureurs.remove(numero-1);
    }


    public ArrayList<Coureur> getListeDesCoureurs() {
        return listeDesCoureurs;
    }

    public void setListeDesCoureurs(ArrayList<Coureur> listeDesCoureurs) {
        this.listeDesCoureurs = listeDesCoureurs;
    }
}
