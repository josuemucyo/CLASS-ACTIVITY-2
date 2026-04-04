import java.util.*;
import java.io.*;

public class TransportSystem {
    private ArrayList<Bus> buses = new ArrayList<>();
    private ArrayList<Driver> drivers = new ArrayList<>();
    private ArrayList<Passenger> passengers = new ArrayList<>();
    private ArrayList<Ticket> tickets = new ArrayList<>();
    
    public void addBus(Bus b) { buses.add(b); System.out.println("Bus added: " + b.getBusNum()); }
    public void addDriver(Driver d) { drivers.add(d); System.out.println("Driver added: " + d.getName()); }
    public void addPassenger(Passenger p) { passengers.add(p); System.out.println("Passenger added: " + p.getName()); }
    
    public void viewBuses() { for(Bus b : buses) b.display(); }
    public void viewDrivers() { for(Driver d : drivers) d.showInfo(); }
    public void viewPassengers() { for(Passenger p : passengers) p.showInfo(); }
    public void viewTickets() { for(Ticket t : tickets) t.display(); }
    
    public Bus findBus(String num) { for(Bus b : buses) if(b.getBusNum().equals(num)) return b; return null; }
    public Passenger findPassenger(String name) { for(Passenger p : passengers) if(p.getName().equals(name)) return p; return null; }
    public Driver findDriver(String name) { for(Driver d : drivers) if(d.getName().equals(name)) return d; return null; }
    
    public void bookTicket(Passenger p, double price, String route) {
        try {
            p.book();
            Ticket t = new Ticket("T" + (tickets.size()+1), p.getName(), route, price);
            t.generate();
            tickets.add(t);
            System.out.println("Booked!");
        } catch(Exception e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }
    
    public void saveData() {
        try {
            // Save buses
            FileWriter busWriter = new FileWriter("buses.txt");
            for(Bus b : buses) {
                busWriter.write(b.getId() + "," + b.getCapacity() + "," + b.getRoute() + "," + b.getBusNum() + "\n");
            }
            busWriter.close();
            System.out.println("Saved " + buses.size() + " buses to buses.txt");
            
            // Save passengers
            FileWriter passWriter = new FileWriter("passengers.txt");
            for(Passenger p : passengers) {
                passWriter.write(p.getId() + "," + p.getName() + "," + p.getPhone() + "," + p.getMoney() + "\n");
            }
            passWriter.close();
            System.out.println("Saved " + passengers.size() + " passengers to passengers.txt");
            
        } catch(IOException e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }
    
    public void loadData() {
        try {
            // Load buses
            File busFile = new File("buses.txt");
            if(busFile.exists()) {
                BufferedReader br = new BufferedReader(new FileReader("buses.txt"));
                String line;
                while((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    Bus b = new Bus(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3], "unknown");
                    buses.add(b);
                }
                br.close();
                System.out.println("Loaded " + buses.size() + " buses");
            } else {
                System.out.println("No buses file found. Starting fresh.");
            }
        } catch(IOException e) {
            System.out.println("Load buses error: " + e.getMessage());
        }
        
        try {
            // Load passengers
            File passFile = new File("passengers.txt");
            if(passFile.exists()) {
                BufferedReader br = new BufferedReader(new FileReader("passengers.txt"));
                String line;
                while((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    Passenger p = new Passenger(parts[0], parts[1], parts[2]);
                    p.addMoney(Double.parseDouble(parts[3]));
                    passengers.add(p);
                }
                br.close();
                System.out.println("Loaded " + passengers.size() + " passengers");
            } else {
                System.out.println("No passengers file found. Starting fresh.");
            }
        } catch(IOException e) {
            System.out.println("Load passengers error: " + e.getMessage());
        }
    }
}
