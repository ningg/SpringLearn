package top.ningg.spring.ioc;

/**
 * Created by guoning on 15/9/19.
 */
public class Car {

    private String brand;
    private String color;
    private int maxSpeed;

    Car() {
    }

    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public String introduce(){
        return String.format("brand:%s, color:%s, maxSpeed:%d", brand, color, maxSpeed);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
