package com.tactfactory.javaniveau2.tps.tp1.entities;

import com.tactfactory.javaniveau2.tps.tp1.functionnalities.Carnivorus;
import com.tactfactory.javaniveau2.tps.tp1.functionnalities.Eatable;
import com.tactfactory.javaniveau2.tps.tp1.functionnalities.Terrestrial;

public class Hyena extends Animal implements Terrestrial, Carnivorus {

  public Hyena() {
    super();
  }

  public Hyena(Long id, String name, Float weight, Float height) {
    super(id, name, weight, height);
  }

@Override
public void move() {
	// TODO Auto-generated method stub
	System.out.println(super.getId() + " Your " + this.getClass().getSimpleName() + " named " + super.getName() + " just moved Walking " );
}

@Override
public void eat(Eatable eatable) {
	// TODO Auto-generated method stub
	if(eatable instanceof Vegetable ) {
		Vegetable vegetable = (Vegetable) eatable;
		System.out.println(super.getId() + " Your " + this.getClass().getSimpleName() + " named " + super.getName() + " cannot eat " + vegetable.getName());
	} else {
		Animal animal = (Animal) eatable;
		System.out.println(super.getId() + " Your " + this.getClass().getSimpleName() + " named " + super.getName() + " eat " + animal.getName());
	}
}
}
