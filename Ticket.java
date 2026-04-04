public class Ticket {
    private String id;
    private String passenger;
    private double price;
    private boolean paid;
    
    public Ticket(String id, String p, String r, double price) {
        if (id.isEmpty()) throw new IllegalArgumentException("Ticket ID required");
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.id = id;
        passenger = p;
        this.price = price;
    }
    
    public void generate() {
        if (paid) throw new IllegalStateException("Ticket already generated");
        paid = true;
        System.out.println("Ticket " + id + " generated");
    }
    
    public void display() {
        System.out.println(id + ": " + passenger + ", $" + price);
    }
    
    public double calcFare() {
        if (price <= 0) throw new ArithmeticException("Invalid price");
        return price + (price * 0.1);
    }
}