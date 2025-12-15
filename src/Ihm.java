import clavier.In;

import java.io.IOException;

public class Ihm {
    public static void main(String[] args) {
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_GREEN_BOLD = "\u001B[32;1m";
        try {
            GestionDesCoureurs laCourse = new GestionDesCoureurs();
            laCourse.lectureFichier();
            System.out.println(laCourse.getListeDesCoureurs());

            int valeur;
            System.out.println(ANSI_GREEN_BOLD +" --> Les participants à la course <--"+ ANSI_RESET);
                    
            System.out.println( """
                    1 : Lister par ordre croissant du nom
                    2 : Lister par ordre decroissant du nom
                    3 : Lister par ordre croissant du prenom
                    4 : Lister par ordre decroissant du prenom
                    5 : Lister par ordre croissant de categorie
                    6 : Lister par ordre decroissant de categorie
                    7 : Lister par ordre croissant de temps
                    8 : Lister par ordre decroissant de temps
                    9 : Ajouter un coureur
                    10 : Supprimer un coureur
                    11 : Modifier un coureur
                    12 : Sauvegarder et quitter
                    """ );

            do {
                System.out.print("Saisissez une valeur : ");
                valeur = In.readInteger();

                switch (valeur) {
                    case 1:
                        laCourse.trierParNomCroissant();
                        affichage(laCourse);
                        break;

                    case 2:
                        laCourse.trierParNomDecroissant();
                        affichage(laCourse);
                        break;

                    case 3:
                        laCourse.trierParPrenomCroissant();
                        affichage(laCourse);
                        break;

                    case 4:
                        laCourse.trierParPrenomDecroissant();
                        affichage(laCourse);
                        break;

                    case 5:
                        laCourse.trierParCategorieCroissant();
                        affichage(laCourse);
                        break;

                    case 6:
                        laCourse.trierParCategorieDecroissant();
                        affichage(laCourse);
                        break;

                    case 7:
                        laCourse.trierParTempsCroissant();
                        affichage(laCourse);
                        break;

                    case 8:
                        laCourse.trierParTempsDecroissant();
                        affichage(laCourse);
                        break;

                    case 9:

                        break;

                    case 10:

                        break;

                    case 11 :
                        break;

                    case 12:
                        System.out.println("Fin du programme.");
                        break;
                    default:
                        System.out.println("Valeur incorrecte.\n");
                }
            } while (valeur != 12);
        } catch (IOException e) {
            System.err.println("Erreur de saisie.");
        }
    }
    public static void affichage(GestionDesCoureurs laCourse) {
        int compteur = 0;
        for (Coureur coureur : laCourse.getListeDesCoureurs() ) {
            compteur ++;
            System.out.println(compteur + " " + coureur.getNom() + " " + coureur.getPrenom() + " " +  coureur.getGenre() + " " + coureur.getCategorie() + " " + coureur.getTemps() + "\n");
        }
    }
}
