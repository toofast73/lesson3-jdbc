package lesson1;

import java.util.List;

public class Box<A extends Fruit> {
    private float weight;
    private List <A> box;


    public Box(List<A> box) {
    }


    public static void main(String[] args) {
        Object[] objects = {new Orange(), new Apple()};
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] instanceof Box)
                System.out.println(((Box<Fruit>) objects[i]).getWeight());

        }

    }

    public float getWeight() {

        return box.size() * this.getWeight();

    }

   public void compare (Fruit dif) {
       if (this.getWeight() == dif.getWeight())
           return;
   }


   public void addBox (List<A> dif){
        dif.addAll(this.box);
        this.box = null;
   }
}