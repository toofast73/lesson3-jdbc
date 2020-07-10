package lesson1;

import java.util.List;


public class BoxTest {
    public void getWeight (){

    Box<Apple> box = new Box<>(List.of(new Apple()));
    box.getWeight();
    }
}

