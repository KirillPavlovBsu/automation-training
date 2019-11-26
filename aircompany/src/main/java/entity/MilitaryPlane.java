package entity;

import java.util.Objects;

public class MilitaryPlane extends Plane {

    private MilitaryPlaneType militaryPlaneType;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryPlaneType militaryPlaneType) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryPlaneType = militaryPlaneType;
    }

    public void setMilitaryPlaneType(MilitaryPlaneType militaryPlaneType) {
        this.militaryPlaneType = militaryPlaneType;
    }

    public MilitaryPlaneType getMilitaryPlaneType() {
        return militaryPlaneType;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof MilitaryPlane) || !super.equals(object)) {
            return false;
        }
        return militaryPlaneType == ((MilitaryPlane) object).militaryPlaneType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryPlaneType);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + militaryPlaneType +
                        '}');
    }
}
