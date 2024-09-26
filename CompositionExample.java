// Computer System Composition Example

// Component classes
class CPU {
    private String model;
    private double clockSpeed;

    public CPU(String model, double clockSpeed) {
        this.model = model;
        this.clockSpeed = clockSpeed;
    }

    public void processData() {
        System.out.println("CPU " + model + " processing data at " + clockSpeed + " GHz");
    }
}

class RAM {
    private String type;
    private int capacityGB;

    public RAM(String type, int capacityGB) {
        this.type = type;
        this.capacityGB = capacityGB;
    }

    public void loadData() {
        System.out.println("Loading data into " + capacityGB + "GB " + type + " RAM");
    }
}

class Storage {
    private String type;
    private int capacityGB;

    public Storage(String type, int capacityGB) {
        this.type = type;
        this.capacityGB = capacityGB;
    }

    public void storeData() {
        System.out.println("Storing data on " + capacityGB + "GB " + type);
    }
}

class GPU {
    private String model;
    private int memoryGB;

    public GPU(String model, int memoryGB) {
        this.model = model;
        this.memoryGB = memoryGB;
    }

    public void renderGraphics() {
        System.out.println("Rendering graphics using " + model + " with " + memoryGB + "GB memory");
    }
}

// Main class using composition
class Computer {
    private CPU cpu;
    private RAM ram;
    private Storage storage;
    private GPU gpu;

    public Computer(CPU cpu, RAM ram, Storage storage, GPU gpu) {
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.gpu = gpu;
    }

    public void bootUp() {
        System.out.println("Booting up the computer...");
        cpu.processData();
        ram.loadData();
        storage.storeData();
        gpu.renderGraphics();
        System.out.println("Computer is ready to use!");
    }

    public void shutDown() {
        System.out.println("Shutting down the computer...");
        storage.storeData();  // Saving data before shutdown
        System.out.println("Computer has been shut down.");
    }

    // Getter methods for components
    public CPU getCpu() { return cpu; }
    public RAM getRam() { return ram; }
    public Storage getStorage() { return storage; }
    public GPU getGpu() { return gpu; }
}

// Example usage
public class CompositionExample {
    public static void main(String[] args) {
        CPU cpu = new CPU("Intel i7", 3.6);
        RAM ram = new RAM("DDR4", 16);
        Storage storage = new Storage("SSD", 512);
        GPU gpu = new GPU("NVIDIA RTX 3070", 8);

        Computer myComputer = new Computer(cpu, ram, storage, gpu);

        myComputer.bootUp();
        System.out.println("\nPerforming some operations...");
        myComputer.getCpu().processData();
        myComputer.getGpu().renderGraphics();
        System.out.println();
        myComputer.shutDown();
    }
}