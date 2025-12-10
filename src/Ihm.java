import clavier.In;

import java.io.IOException;

public class Ihm {
    public static void main(String[] args) {
        try {
            GestionDesCoureurs laCourse = new GestionDesCoureurs();
            laCourse.lectureFichier();

            System.out.println(laCourse);
            int valeur;
            System.out.println("""
                    --> Les participants à la course <--
                    1 : Lire la liste
                    2 : Lister par ordre croissant du nom
                    3 : Lister par ordre decroissant du nom
                    4 : Lister par ordre croissant du prenom
                    5 : Lister par ordre decroissant du prenom
                    6 : Lister par ordre croissant de classement
                    7 : Lister par ordre decroissant de classement
                    8 : Ajouter un coureur
                    9 : Supprimer un coureur
                    10 : Modifier un coureur
                    11 : Sauvegarder et quitter
                    """);

            do {
                System.out.print("Saisissez une valeur : ");
                valeur = In.readInteger();

                switch (valeur) {
                    case 1:

                        break;
                    case 2:
                        for (Coureur coureur : laCourse.getListeDesCoureurs()) {
                            System.out.println(coureur.getNom());
                        }
                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                    case 9:

                        break;
                    case 10:

                        break;
                    case 11:
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
