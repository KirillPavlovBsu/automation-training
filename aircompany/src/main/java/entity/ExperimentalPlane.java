package entity;

public class ExperimentalPlane extends Plane {

    private ExperimentalPlaneType experimentalPlaneType;
    private ExperimentalPlaneClassificationLevel experimentalPlaneClassificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalPlaneType experimentalType, ExperimentalPlaneClassificationLevel classificationLevelType) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalPlaneType = experimentalType;
        this.experimentalPlaneClassificationLevel = classificationLevelType;
    }

    public ExperimentalPlaneType getExperimentalPlaneType() {
        return experimentalPlaneType;
    }

    public void setExperimentalPlaneType(ExperimentalPlaneType experimentalPlaneType) {
        this.experimentalPlaneType = experimentalPlaneType;
    }

    public ExperimentalPlaneClassificationLevel getExperimentalPlaneClassification() {
        return experimentalPlaneClassificationLevel;
    }

    public void setExperimentalPlaneClassificationLevel(ExperimentalPlaneClassificationLevel experimentalPlaneClassificationLevel) {
        this.experimentalPlaneClassificationLevel = experimentalPlaneClassificationLevel;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" +
                "airport='" + model + '\'' +
                '}';
    }
}
