public abstract class Vehicle {
    private String id;
    private int capacity;
    private String route;
    
    public Vehicle(String id, int capacity, String route) {
        this.id = id;
        this.capacity = capacity;
        this.route = route;
    }
    
    public String getId() { return id; }
    public int getCapacity() { return capacity; }
    public String getRoute() { return route; }
    
    public abstract void start();
    public abstract void stop();
    
    public void display() {
        System.out.println("ID: " + id + ", Cap: " + capacity + ", Route: " + route);
    }
}
