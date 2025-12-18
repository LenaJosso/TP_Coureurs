import clavier.In;

import java.io.IOException;
import java.time.LocalTime;

public class Ihm {
    public static void main(String[] args) {
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
                        Coureur NouveauCoureur = new Coureur();
                        System.out.println("Quel est le nouveau nom du coureur ?");
                        String newNom2 = In.readString().trim().toUpperCase();
                        NouveauCoureur.setNom(newNom2);
                        System.out.println("Quel est le nouveau prenom du coureur ?");
                        String newPrenom2 = In.readString().trim();
                        newPrenom2 = newPrenom2.substring(0, 1).toUpperCase() + newPrenom2.substring(1).toLowerCase();
                        NouveauCoureur.setPrenom(newPrenom2);
                        System.out.println(newPrenom2);
                        System.out.println("Quel est le nouveau genre du coureur ? --> 1 = F, 2 = M)");
                        String genre3;
                        int nvGenre2 = In.readInteger();
                        switch (nvGenre2) {
                            case 1:
                                genre3 = "F";
                                break;
                            case 2:
                                genre3 = "M";
                                break;
                            default:
                                genre3 = "F";
                        }
                        NouveauCoureur.setGenre(Genre.valueOf(genre3));
                        System.out.println("Quel est la nouvelle catégorie de coureur ?");
                        System.out.println("""
                                               1 = M1
                                               2 =  M2
                                               3 = M3
                                               4 = M4
                                               5 = M5
                                               6 = M6
                                               7 = M7
                                               8 = M8
                                               9 = M9
                                               10 = ELITE_1
                                               11 = ELITE_2
                                            """);
                        String categorie3;
                        int nvCategorie2 = In.readInteger();
                        switch (nvCategorie2) {
                            case 1:
                                categorie3 = "M1";
                                break;
                            case 2:
                                categorie3 = "M2";
                                break;
                            case 3:
                                categorie3 = "M3";
                                break;
                            case 4:
                                categorie3 = "M4";
                                break;
                            case 5:
                                categorie3 = "M5";
                                break;
                            case 6:
                                categorie3 = "M6";
                                break;
                            case 7:
                                categorie3 = "M7";
                                break;
                            case 8:
                                categorie3 = "M8";
                                break;
                            case 9:
                                categorie3 = "M9";
                                break;
                            case 10:
                                categorie3 = "ELITE_1";
                                break;
                            case 11:
                                categorie3 = "ELITE_2";
                                break;
                            default:
                                categorie3 = "M1";
                        }
                        NouveauCoureur.setCategorie(Categorie.valueOf(categorie3));
                        System.out.println("Quel est le nouveau temps en seconde ?");
                        int nvTemps2 = In.readInteger();
                        NouveauCoureur.setTemps(LocalTime.ofSecondOfDay(nvTemps2));
                        break;

                    case 10:
                        System.out.println("Quel numéro voulez vous supprimer (selon la liste de base) ?");
                        int numero = In.readInteger();
                        laCourse.SupprimerUnCoureur(numero);
                        affichage(laCourse);
                        break;

                    case 11 :
                        Coureur modifCoureur = new Coureur();
                        System.out.println("Quel numéro voulez vous modifier (selon la liste de base) ?");
                        int numero2 = In.readInteger();
                        do {
                            System.out.println("Que voulez vous changer ?");
                            System.out.println( """
                    1 : Le nom
                    2 : Le prenom
                    3 : Le genre
                    4 : La catégorie
                    5 : Le temps
                    6 : Fin de la modification
                    """ );
                            int numero3 = In.readInteger();
                            switch (numero3) {
                                case 1:
                                    System.out.println("Quel est le nouveau nom du coureur ?");
                                    String newNom = In.readString().trim().toUpperCase();
                                    modifCoureur.setNom(newNom);
                                    break;
                                case 2:
                                    System.out.println("Quel est le nouveau prenom du coureur ?");
                                    String newPrenom = In.readString().trim();
                                    newPrenom = newPrenom.substring(0, 1).toUpperCase() + newPrenom.substring(1).toLowerCase();
                                    modifCoureur.setPrenom(newPrenom);
                                    System.out.println(newPrenom);
                                    break;
                                case 3:
                                    System.out.println("Quel est le nouveau genre du coureur ? --> 1 = F, 2 = M)");
                                    String genre2;
                                    int nvGenre = In.readInteger();
                                    switch (nvGenre) {
                                        case 1:
                                            genre2 = "F";
                                            break;
                                        case 2:
                                            genre2 = "M";
                                            break;
                                        default:
                                            genre2 = "F";
                                    }
                                    modifCoureur.setGenre(Genre.valueOf(genre2));
                                    break;
                                case 4:
                                    System.out.println("Quel est la nouvelle catégorie de coureur ?");
                                    System.out.println("""
                                               1 = M1
                                               2 =  M2
                                               3 = M3
                                               4 = M4
                                               5 = M5
                                               6 = M6
                                               7 = M7
                                               8 = M8
                                               9 = M9
                                               10 = ELITE_1
                                               11 = ELITE_2
                                            """);
                                    String categorie2;
                                    int nvCategorie = In.readInteger();
                                    switch (nvCategorie) {
                                        case 1:
                                            categorie2 = "M1";
                                            break;
                                        case 2:
                                            categorie2 = "M2";
                                            break;
                                        case 3:
                                            categorie2 = "M3";
                                            break;
                                        case 4:
                                            categorie2 = "M4";
                                            break;
                                        case 5:
                                            categorie2 = "M5";
                                            break;
                                        case 6:
                                            categorie2 = "M6";
                                            break;
                                        case 7:
                                            categorie2 = "M7";
                                            break;
                                        case 8:
                                            categorie2 = "M8";
                                            break;
                                        case 9:
                                            categorie2 = "M9";
                                            break;
                                        case 10:
                                            categorie2 = "ELITE_1";
                                            break;
                                        case 11:
                                            categorie2 = "ELITE_2";
                                            break;
                                        default:
                                            categorie2 = "M1";
                                    }
                                    modifCoureur.setCategorie(Categorie.valueOf(categorie2));
                                    break;
                                case 5:
                                    System.out.println("Quel est le nouveau temps en seconde ?");
                                    int nvTemps = In.readInteger();
                                    modifCoureur.setTemps(LocalTime.ofSecondOfDay(nvTemps));
                                    break;
                                case 6:
                                    System.out.println("Fin de la modification");
                                    break;
                                default:
                                    System.out.println("Valeur incorrecte.\n");
                            }
                        } while (numero2 != 6);
                        break;

                    case 12:
                        laCourse.SauvegargerCoureur();
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
