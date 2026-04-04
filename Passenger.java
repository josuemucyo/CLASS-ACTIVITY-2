import java.util.ArrayList;

public class Passenger extends Person implements Bookable {
    private ArrayList<String> bookings;
    private double money;
    
    public Passenger(String id, String name, String phone) {
        super(id, name, phone);
        bookings = new ArrayList<>();
        money = 0;
    }
    
    public void addMoney(double m) {
        if (m <= 0) throw new IllegalArgumentException("Amount must be positive");
        money += m;
        System.out.println("Wallet: $" + money);
    }

    public double getMoney() { return money; }
    
    @Override
    public void showInfo() {
        System.out.println(getName() + ", $" + money);
    }
    
    @Override
    public void book() {
        if (money < 50) throw new IllegalStateException("Insufficient funds");
        bookings.add("B" + (bookings.size()+1));
        money -= 50;
        System.out.println("Booked! Balance: $" + money);
    }
    
    @Override
    public void cancel() {
        if (bookings.isEmpty()) throw new IllegalStateException("No bookings");
        bookings.remove(bookings.size()-1);
        money += 50;
        System.out.println("Cancelled");
    }
    
    @Override
    public void view() {
        System.out.println("Bookings: " + bookings);
    }
}