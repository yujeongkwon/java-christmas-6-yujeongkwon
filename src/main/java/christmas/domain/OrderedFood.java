package christmas.domain;


public class OrderedFood {
    private Food food;
    private int quantity;

    public OrderedFood(String orderedFood, int quantity) {
        this.food = validateOrder(orderedFood);
        this.quantity = validateQuantuty(quantity);
    }

    private int validateQuantuty(int quantity) {
        return quantity;
    }

    private Food validateOrder(String orderedFood) {
        return new Food("temp",1);
    }
}
