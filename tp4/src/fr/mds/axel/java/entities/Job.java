package fr.mds.axel.java.entities;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Job {

  DEVELOPER("Développeur"),
  MANAGER("Manageur"),
  ACCOUNTING("Comptable"),
  HUMAN_RESOURCES("RH");
	
	private static final List<Job> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	private String abreviation;
	
	private Job(String abreviation) {  
        this.abreviation = abreviation ;  
    }
	
	public String getAbreviation() {  
        return  this.abreviation ;  
    }
	
	public static void printList() {
		System.out.println("Liste des Job(s) :");
		for(int i = 0; i < SIZE; i++) {
			System.out.println(VALUES.get(i).getAbreviation());
		}
		System.out.println();
	}
	
	public static Job getRandom() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
