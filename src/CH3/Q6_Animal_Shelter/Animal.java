package CH3.Q6_Animal_Shelter;

public abstract class Animal {

    private int order;
    protected String name;

    public abstract String name();

    public Animal(String n) {
        name = n;
    }

    public int getOrder() {
        return order;
    }

    public Animal setOrder(int order) {
        this.order = order;
        return this;
    }

    public boolean isOrderThan(Animal a) {
        return this.order < a.getOrder();
    }
}
