package lesson1;

import java.util.ArrayList;
import java.util.List;

abstract class Fruit<A> {

    List<Fruit> fruits = new ArrayList<Fruit>();
    private final float weight;

    public Fruit (float weight) {
        this.weight= weight;}

    public float getWeight() {
        final float weight = this.weight;
        return weight;
    }

    }



