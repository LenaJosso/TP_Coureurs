import clavier.In;

import java.io.IOException;

public class Ihm {
    public static void main(String[] args) {
        try {
            GestionDesCoureurs laCourse = new GestionDesCoureurs();
            laCourse.lectureFichier();
            laCourse.affichage();
            int valeur;
            System.out.println("""
                    --> Les participants à la course <--
                    
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
                    """);

            do {
                System.out.print("Saisissez une valeur : ");
                valeur = In.readInteger();

                switch (valeur) {
                    case 1:
                        laCourse.trierParNomCroissant();
                        laCourse.affichage();
                        break;

                    case 2:
                        laCourse.trierParNomDecroissant();
                        laCourse.affichage();
                        break;

                    case 3:
                        laCourse.trierParPrenomCroissant();
                        laCourse.affichage();
                        break;
                    case 4:
                        laCourse.trierParPrenomDecroissant();
                        laCourse.affichage();
                        break;
                    case 5:
                        laCourse.trierParCategorieCroissant();
                        laCourse.affichage();
                        break;
                    case 6:
                        laCourse.trierParCategorieDecroissant();
                        laCourse.affichage();
                        break;
                    case 7:
                        laCourse.trierParTempsCroissant();
                        laCourse.affichage();
                        break;
                    case 8:
                        laCourse.trierParTempsDecroissant();
                        laCourse.affichage();
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
            } while (valeur != 11);
        } catch (IOException e) {
            System.err.println("Erreur de saisie.");
        }
    }}
