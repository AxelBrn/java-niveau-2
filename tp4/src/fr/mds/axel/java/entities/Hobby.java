package fr.mds.axel.java.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Hobby {

  COOKING("Cuisine"),
  SPORTS("Sport"),
  SWIMMING("Natation"),
  MOTO_CROSS("Moto cross"),
  BIKING("Cyclisme"),
  VIDEO_GAMES("Jeux vidéo"),
  PROGRAMMMING("Programmation");
	
	private static final List<Hobby> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	private String abreviation;
	
	private Hobby(String abreviation) {  
        this.abreviation = abreviation ;  
    }
	
	
	public String getAbreviation() {  
        return  this.abreviation ;  
    }

	public static void printList() {
		System.out.println("Liste des Hobby(s) :");
		for(int i = 0; i < SIZE; i++) {
			System.out.println(VALUES.get(i).getAbreviation());
		}
		System.out.println();
	}
	
	public static Hobby getRandom() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
	
	public static List<Hobby> getRandoms() {
		List<Hobby> hobbys = new ArrayList<>();
		int nbHobby = RANDOM.nextInt(SIZE);
		
		for(int i = 0; i < nbHobby; i++) {
			Hobby hobby = getRandom();
			if(i == 0) {
				hobbys.add(hobby);
			} else {
				while(hobbys.contains(hobby)) {
					hobby = getRandom();
				}
				hobbys.add(hobby);
			}
		}
		
		return hobbys;
	}
}
