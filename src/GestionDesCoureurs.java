import clavier.In;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

public class GestionDesCoureurs {
    ArrayList<Coureur> listeDesCoureurs = new ArrayList();

    /**
     * Permet de lire le fichier texte et de "l'implanter" dans une array list
     * @throws IOException
     */
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


    public void ModifierUnCoureur (int numero2){

    }


    /**
     * Trier la liste par nom croissant
     *
     * @return Supprime un coureur à la ligne demande */
    public void SupprimerUnCoureur (int numero){
        listeDesCoureurs.remove(numero-1);
    }

    /**
     * Permet de sauvegarder la liste
     * @throws IOException
     *
     */
    public void SauvegargerCoureur() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("courseFinal.txt"));
        for (Coureur coureur : listeDesCoureurs ) {
            writer.write(coureur.getGenre() + ", " + coureur.getNom() + ", " + coureur.getPrenom() + ", " + coureur.getCategorie() + ", " + coureur.getTemps());
            writer.newLine();
        }
        writer.close();
    }
// Je n'ai pas réussi à finir le binaire mais je le laisse en commentaire
//    private static final Path path = Paths.get("course.bin");
//
//    private void lectureFichierBinaire() throws IOException, ClassNotFoundException {
//        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path));
//        if (Files.exists(path)) {
//            do {
//                Coureur coureur = (Coureur) ois.readObject();
//                listeDesCoureurs.add(coureur);
//            } while (true);
//        }
//    }


    public ArrayList<Coureur> getListeDesCoureurs() {
        return listeDesCoureurs;
    }

    public void setListeDesCoureurs(ArrayList<Coureur> listeDesCoureurs) {
        this.listeDesCoureurs = listeDesCoureurs;
    }
}
