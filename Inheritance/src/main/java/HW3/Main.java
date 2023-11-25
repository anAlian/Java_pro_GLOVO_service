package HW3;

import static java.lang.Integer.sum;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat ("Мурчик");
        cat.run(100);
        cat.swim();
        Dog dog = new Dog("Бобік");
        dog.run(501);
        dog.swim(10);


        System.out.println ("Створено тварин: " + sum(Dog.numberofobjectsDog,Cat.numberofobjectsCat));
        System.out.println ("Створено собак: " + Dog.numberofobjectsDog );
        System.out.println ("Створено котів: " + Cat.numberofobjectsCat);

    }



}
