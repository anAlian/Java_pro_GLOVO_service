public class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public void run(int obstacleLength){
        System.out.println(name + " пробіг "+ obstacleLength+ " м");

    }
    public void swim (int obstacleLength){
        System.out.println(name+ " проплив "+obstacleLength+ " m");

    }

}
