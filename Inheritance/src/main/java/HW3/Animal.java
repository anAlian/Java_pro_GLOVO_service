package HW3;

public class Animal {
    public String name;
    private int maxLenRun=0;
    private int maxLenSw=0;


    public Animal(String name) {
        this.name = name;
    }
    public void run(int obstacleLength){

        System.out.println(obstacleLength<=getMaxLenRun()?
                name + " пробіг " + obstacleLength + " м": name+" не міг пробігти "+obstacleLength+ " м");

    }
    public void swim (int obstacleLength){
        System.out.println(obstacleLength<= getMaxLenSwim()?
                name+ " проплив "+obstacleLength+ " m": name+" не міг проплисти "+obstacleLength+ " м");
    }

    public int getMaxLenRun() {
        return maxLenRun;
    }

    public int getMaxLenSwim() {
        return maxLenSw;
    }



}