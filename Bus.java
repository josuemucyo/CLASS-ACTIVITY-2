public class Bus extends Vehicle implements Maintainable {
    private String busNum;
    private String driver;
    private boolean running;
    
    public Bus(String id, int cap, String route, String busNum, String driver) {
        super(id, cap, route);
        if (busNum.isEmpty()) throw new IllegalArgumentException("Bus number required");
        if (cap <= 0) throw new IllegalArgumentException("Capacity must be positive");
        this.busNum = busNum;
        this.driver = driver;
    }
    
    public String getBusNum() { return busNum; }
    
    @Override
    public void start() {
        if (running) throw new IllegalStateException("Bus already running");
        System.out.println(busNum + " starting");
        running = true;
    }
    
    @Override
    public void stop() {
        if (!running) throw new IllegalStateException("Bus already stopped");
        System.out.println(busNum + " stopping");
        running = false;
    }
    
    @Override
    public void display() {
        super.display();
        System.out.println("Bus: " + busNum + ", Driver: " + driver);
    }
    
    public void assignDriver(String d) {
        if (d.isEmpty()) throw new IllegalArgumentException("Driver name required");
        this.driver = d;
        System.out.println("Driver " + d + " assigned");
    }
    
    @Override
    public void maintain() { System.out.println("Maintenance done"); }
    
    @Override
    public void check() { System.out.println(busNum + " is " + (running ? "running" : "stopped")); }
}