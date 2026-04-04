public class Driver extends Person {
    private String license;
    private String busId;
    
    public Driver(String id, String name, String license, int exp) {
        super(id, name, "");
        if (license.isEmpty()) throw new IllegalArgumentException("License required");
        this.license = license;
        busId = "None";
    }
    
    @Override
    public void showInfo() {
        System.out.println(getName() + ", Bus: " + busId);
    }
    
    public void assignBus(String b) {
        if (b.isEmpty()) throw new IllegalArgumentException("Invalid bus");
        busId = b;
        System.out.println(getName() + " assigned to bus " + b);
    }
}