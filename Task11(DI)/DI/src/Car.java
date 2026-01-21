
public class Car {
    Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }
    void startCar(){
        System.out.println("Car with");
        engine.start();
    }

}
