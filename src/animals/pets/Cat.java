package animals.pets;

import animals.AbsAnimal;

public class Cat extends AbsAnimal {

    @Override
    public void say() {
        System.out.println("Мяу!");
    }
}
