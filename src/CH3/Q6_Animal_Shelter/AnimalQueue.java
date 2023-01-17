package CH3.Q6_Animal_Shelter;

import java.util.LinkedList;

public class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0;

    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;
        if(a instanceof Dog) {
            dogs.addLast((Dog) a);
        } else if (a instanceof Cat) {
            cats.addLast((Cat) a);
        }
    }

    public Animal dequeueAny(Animal a) {
        if(dogs.size() == 0) {
            return cats.poll();
        } else if (cats.size() == 0) {
            return dogs.poll();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if(dog.isOrderThan(cat)) {
            return dogs.poll();
        } else {
            return cats.poll();
        }
    }

    public int size() {
        return dogs.size() + cats.size();
    }

    public Dog dequeueDogs() {
        return dogs.poll();
    }

    public Dog peekDog() {
        return dogs.peek();
    }

    public Cat dequeueCats() {
        return cats.poll();
    }

    public Cat peekCat() {
        return cats.peek();
    }
}
