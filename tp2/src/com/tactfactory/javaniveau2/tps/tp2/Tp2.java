package com.tactfactory.javaniveau2.tps.tp2;

import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.tactfactory.javaniveau2.tps.tp2.entities.Car;
import com.tactfactory.javaniveau2.tps.tp2.entities.User;
import com.tactfactory.javaniveau2.tps.tp2.utils.ItemsGenerator;

/**
 *
 * @author tactfactory
 *
 *  - Créer un programme qui permet, en utilisant la fonction "stream()" sur la variable users,
 *      d'afficher les informations suivantes :
 *    - 1 : Le nombre d'utilisateur
 *    - 2 : Le nombre d'utilisateur dans la première lettre du prénom commence par "a"
 *    - 3 : Le nombre d'utilisateur dont le nom et le prénom contienent exactement 5 caractères
 *    - 4 : Le nombre d'utilisateur dont le full name contient entre 13 et 16 caractères
 *    - 5 : Les utilisateurs possédant une voiture de la marque "marque1"
 *    - 6 : La première voiture avec le plus haut kilométrage
 *    - 7 : La liste des voitures avec le plus haut kilométrage
 *    - 8 : La marque possédant le plus de voiture avec le nombre de voiture possédé
 *    - 9 : Les marques possédant le moins de voiture avec chacune des voitures pour chaque marque
 *    -10 : La liste des utilisateurs triée par nom puis par prénom
 */
public class Tp2 {

  public static void main(String[] args) {
    List<User> users = ItemsGenerator.generateUsers();

    for (User user : users) {
      System.out.println(user);
    }

    // 1 : Le nombre d'utilisateur
    long nbUsers = users.stream().count();
    System.out.println(String.format("%s %d", "Nombre d'utilisateur", nbUsers));

    // 2 : Le nombre d'utilisateur dans la première lettre du prénom commence par "a"
    long nbUsersA = users.stream().filter(user -> user.getFirstname().charAt(0) == 'a').count();
    System.out.println(
        String.format("%s %d", "Nombres d'utilisateur dans la premi�re lettre du pr�nom commence par \"a\"", nbUsersA));

    // 3 : Le nombre d'utilisateur dont le nom et le prénom contienent exactement 5 caractères
    long nbUsersFLName5 = users.stream().filter(user -> user.getFirstname().length() == 5 
    		&& user.getLastname().length() == 5).count();
    System.out.println(String.format("%s %d",
        "Les utilisateurs dont le nom et le pr�nom contienent exactement 5 caract�res", nbUsersFLName5));

    // 4 : Le nombre d'utilisateur dont le full name contient entre 13 et 16 caractères
    long nbUsersFullname1316 = users.stream().filter(user -> user.getFullName().length() >= 13 
    		&& user.getFullName().length() <= 16).count();
    System.out.println(String.format("%s %d", "Les utilisateurs dont le full name contient entre 13 et 16 caract�res",
        nbUsersFullname1316));

    // 5 : Les utilisateurs possédant une voiture de la marque "marque1"
    List<User> usersCarMarque1 = users.stream()
    		.filter(user -> user.getCar().getCarType().getMark().equals("marque1"))
    		.collect(Collectors.toList());
    System.out.println("Les utilisateurs poss�dant une voiture de la marque \"marque1\"");
    for (User user : usersCarMarque1) {
      System.out.println(String.format("\t%s", user));
    }

    // 6 : La première voiture avec le plus haut kilométrage
    Car carMaxMileage = users.stream() .collect(Collectors.maxBy(Comparator.comparingLong(user -> user.getCar().getMileage()))).get().getCar();
    System.out.println(String.format("%s %s", "La voiture avec le plus haut kilom�trage", carMaxMileage));

    // 7 : La liste des voitures avec le plus haut kilométrage
    List<Car> carMaxMileages = users.stream().filter(user -> user.getCar().getMileage() == carMaxMileage.getMileage()).map(User::getCar).collect(Collectors.toList());
    System.out.println("La liste des voitures avec le plus haut kilom�trage");
    for (Car car : carMaxMileages) {
      System.out.println(String.format("\t%s", car));
    }

    // 8 : La marque possédant le plus de voiture avec le nombre de voiture possédé
//    Entry<String, List<User>> markMaxCar = users.stream().collect(Collectors.groupingBy(user -> user.getCar().getCarType().getMark()));
//    System.out.println(String.format("%s est %s avec %d voitures", "La marque poss�dant le plus de voiture",
//        markMaxCar.getKey(), markMaxCar.getValue().size()));

    // 9 : Les marques possédant le moins de voiture avec chacune des voitures pour chaque marque
//    int minCars = users.stream();
//    List<Entry<String, List<Car>>> markMinCars = users.stream();
//    System.out.println("Les marques possédant le moins de voiture avec chacune des voitures pour chaque marque");
//    for (Entry<String, List<Car>> entry : markMinCars) {
//      System.out.println("\t" + entry.getKey() + " :");
//      for (Car car : entry.getValue()) {
//        System.out.println("\t\t" + car);
//      }
//    }

    // 10 : La liste des utilisateurs triée par nom puis par prénom
    List<User> sortedUsers = users.stream().sorted(Comparator.comparing(User::getFirstname).thenComparing(User::getLastname)).collect(Collectors.toList());
    System.out.println("La liste des utilisateurs tri�e par nom puis par pr�nom");
    for (User user : sortedUsers) {
      System.out.println("\t" + user);
    }
  }

}
