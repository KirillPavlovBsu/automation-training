package entity;

import java.util.Objects;

public abstract class Plane {
    public String model;
    private int maxSpeed;
    private int maxFlightDistance;
    private int maxLoadCapacity;

    public Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxFlightDistance(int maxFlightDistance) {
        this.maxFlightDistance = maxFlightDistance;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public void setMaxLoadCapacity(int maxLoadCapacity) {
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public int getMaxLoadCapacity() {
        return this.maxLoadCapacity;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Plane)) {
            return false;
        }
        Plane plane = (Plane) object;
        return maxSpeed == plane.maxSpeed &&
                maxFlightDistance == plane.maxFlightDistance &&
                maxLoadCapacity == plane.maxLoadCapacity &&
                Objects.equals(model, plane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "airport='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }
}
