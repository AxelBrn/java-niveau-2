package fr.mds.axel.java;

import java.util.ArrayList;
import java.util.List;

import fr.mds.axel.java.entities.Hobby;
import fr.mds.axel.java.entities.Job;
import fr.mds.axel.java.entities.User;

/**
*
* @author tactfactory
*
*  - Cr�er un programme qui permet de g�rer l'utilisation des �num�rations "Hobby" et "Job", attention Tp4.main devra
*     �tre modifi�.
*    - 1 : Hobby
*       - 1 : La fonction printList() doit permettre d'afficher tous les "Hobby" disponibles en fran�ais.
*       - 2 : La fonction getRandom() doit permettre de r�cup�rer un "Hobby" parmis tous les "Hobby" possibles.
*       - 3 : La fonction getRandoms() doit permettre de r�cup�rer une liste de "Hobby" parmis tous les "Hobby"
*               possibles sans avoir deux fois le m�me "Hobby" pour une m�me liste.
*       - 4 : La fonction showUsing() doit permettre de voir le nombre de fois o� un "Hobby" a �t� utilis�.
*           - Pour ce point il faudrat utiliser la variable statique de type "Map" mise � disposition dans "Hobby"
*           - Afin de pouvoir compter les �l�ments il ne faut plus pouvoir directement acc�der � la liste de "Hobby"
*               d'un utilisateur mais utiliser des fonctions d�di�es � l'ajout et la suppression d'�l�ment de la liste.
*    - 2 : Job
*       - 1 : La fonction printList() doit permettre d'afficher tous les "Job" disponibles en fran�ais.
*       - 2 : La fonction getRandom() doit permettre de r�cup�rer un "Job" parmis tous les "Job" possibles.
*
*    - Un exemple de sortie est disponible dans le fichier "possibleOutput"
*/
public class Application {

  public static void main(String[] args) {
    Hobby.printList();
    Job.printList();

    User u1 = new User();
    u1.setId(1);
    u1.setFirstname("zae");
    u1.setLastname("tre");
    u1.setMainHobby(Hobby.BIKING);
    u1.setJob(Job.ACCOUNTING);
    u1.getHobbies().add(Hobby.SPORTS);
    u1.getHobbies().add(Hobby.VIDEO_GAMES);

    System.out.println(u1);

    List<User> users = new ArrayList<User>();

    for (int i = 2; i < 12; i++) {
      User user = new User();
      user.setId(i);
      user.setFirstname("f"+i);
      user.setLastname("l"+i);
      user.setMainHobby(Hobby.getRandom());
      user.setJob(Job.getRandom());
      user.getHobbies().addAll(Hobby.getRandoms());

      users.add(user);
    }

    for (User user : users) {
      System.out.println(user);
    }

//    Hobby.showUsing();
  }

}
