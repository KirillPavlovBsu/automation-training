package airport;

import entity.*;


import java.util.*;

public class Airport {

    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public void setPlanes(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane plane : this.planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) plane);
            }
        }
        return passengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : this.planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }


    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = getPassengerPlanes().get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if (militaryPlane.getMilitaryPlaneType() == MilitaryPlaneType.TRANSPORT) {
                transportMilitaryPlanes.add(militaryPlane);
            }
        }
        return transportMilitaryPlanes;
    }


    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if (militaryPlane.getMilitaryPlaneType() == MilitaryPlaneType.BOMBER) {
                bomberMilitaryPlanes.add(militaryPlane);
            }
        }
        return bomberMilitaryPlanes;
    }


    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : this.planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }


    public Airport sortByMaxDistance() {
        Collections.sort(planes, Comparator.comparingInt(object -> object.getMaxFlightDistance()));
        return this;
    }


    public Airport sortByMaxSpeed() {
        Collections.sort(planes, Comparator.comparingInt(object -> object.getMaxSpeed()));
        return this;
    }


    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, Comparator.comparingInt(object -> object.getMaxLoadCapacity()));
        return this;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }
}