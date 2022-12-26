package animals.pets;

import animals.AbsAnimal;

public class Dog extends AbsAnimal {
    @Override
    public void say() {
        System.out.println("Гав!");
    }
}
