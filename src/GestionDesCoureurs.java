import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;

public class GestionDesCoureurs {
    ArrayList<Coureur> listeDesCoureurs = new ArrayList();
    public void lectureFichier() throws IOException {
        Path chemin = Paths.get("courses.txt");
        BufferedReader lecture;
        lecture = Files.newBufferedReader(chemin);
        String line = null;
        while (lecture.ready()){
            line = lecture.readLine();
            if (line != null){
                String[] s = line.split(",");
                if (s.length == 5){
                    int duree = Integer.parseInt(s[4].trim());
                    Categorie categorie = Categorie.valueOf(s[3].trim().toString());
                    Coureur coureurs = new Coureur(s[1].trim(), s[2].trim(), Genre.valueOf(s[3].trim()), LocalTime.now(), Categorie.valueOf(s[5].trim()));
                    listeDesCoureurs.add(coureurs);
                }
            }
        }
    }
}
