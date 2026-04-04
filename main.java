import java.util.Scanner;

public class Main {
    static TransportSystem ts = new TransportSystem();
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        ts.loadData();
        
        int choice;
        do {
            System.out.println("\n=== TRANSPORT SYSTEM ===");
            System.out.println("1. Add Bus     2. Add Driver     3. Add Passenger");
            System.out.println("4. Add Money   5. Book Ticket    6. Cancel Booking");
            System.out.println("7. View Buses  8. View Drivers   9. View Passengers");
            System.out.println("10. View Tickets   11. Start Bus   12. Stop Bus");
            System.out.println("13. Assign Driver   14. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt(); 
            sc.nextLine();
            
            switch(choice) {
                case 1: addBus(); break;
                case 2: addDriver(); break;
                case 3: addPassenger(); break;
                case 4: addMoney(); break;
                case 5: book(); break;
                case 6: cancel(); break;
                case 7: ts.viewBuses(); break;
                case 8: ts.viewDrivers(); break;
                case 9: ts.viewPassengers(); break;
                case 10: ts.viewTickets(); break;
                case 11: startBus(); break;
                case 12: stopBus(); break;
                case 13: assignDriver(); break;
                case 14: System.out.println("Saving..."); break;
                default: System.out.println("Invalid");
            }
        } while(choice != 14);
        
        ts.saveData();
        System.out.println("Goodbye!");
    }
    
    static void addBus() {
        System.out.print("Bus Number: "); 
        String num = sc.nextLine();
        System.out.print("Capacity: "); 
        int cap = sc.nextInt(); 
        sc.nextLine();
        System.out.print("Route: "); 
        String route = sc.nextLine();
        System.out.print("Driver: "); 
        String driver = sc.nextLine();
        ts.addBus(new Bus("B"+num, cap, route, num, driver));
    }
    
    static void addDriver() {
        System.out.print("ID: "); 
        String id = sc.nextLine();
        System.out.print("Name: "); 
        String name = sc.nextLine();
        System.out.print("License: "); 
        String lic = sc.nextLine();
        ts.addDriver(new Driver(id, name, lic, 5));
    }
    
    static void addPassenger() {
        System.out.print("ID: "); 
        String id = sc.nextLine();
        System.out.print("Name: "); 
        String name = sc.nextLine();
        System.out.print("Phone: "); 
        String phone = sc.nextLine();
        ts.addPassenger(new Passenger(id, name, phone));
    }
    
    static void addMoney() {
        System.out.print("Passenger Name: "); 
        String name = sc.nextLine();
        Passenger p = ts.findPassenger(name);
        if(p == null) { 
            System.out.println("Not found"); 
            return; 
        }
        System.out.print("Amount: $"); 
        double amt = sc.nextDouble(); 
        sc.nextLine();
        p.addMoney(amt);
    }
    
    static void book() {
        System.out.print("Passenger Name: "); 
        String name = sc.nextLine();
        Passenger p = ts.findPassenger(name);
        if(p == null) { 
            System.out.println("Not found"); 
            return; 
        }
        System.out.print("Price: $"); 
        double price = sc.nextDouble(); 
        sc.nextLine();
        System.out.print("Route: "); 
        String route = sc.nextLine();
        ts.bookTicket(p, price, route);
    }
    
    static void cancel() {
        System.out.print("Passenger Name: "); 
        String name = sc.nextLine();
        Passenger p = ts.findPassenger(name);
        if(p == null) { 
            System.out.println("Not found"); 
            return; 
        }
        p.cancel();
    }
    
    static void startBus() {
        System.out.print("Bus Number: "); 
        String num = sc.nextLine();
        Bus b = ts.findBus(num);
        if(b == null) { 
            System.out.println("Not found"); 
            return; 
        }
        b.start();
    }
    
    static void stopBus() {
        System.out.print("Bus Number: "); 
        String num = sc.nextLine();
        Bus b = ts.findBus(num);
        if(b == null) { 
            System.out.println("Not found"); 
            return; 
        }
        b.stop();
    }
    
    static void assignDriver() {
        System.out.print("Driver Name: "); 
        String dName = sc.nextLine();
        Driver d = ts.findDriver(dName);
        if(d == null) { 
            System.out.println("Driver not found"); 
            return; 
        }
        System.out.print("Bus Number: "); 
        String bNum = sc.nextLine();
        d.assignBus(bNum);
        System.out.println("Driver " + dName + " assigned to bus " + bNum);
    }
}
