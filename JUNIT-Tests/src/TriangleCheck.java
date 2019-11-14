public class TriangleCheck {
    public static boolean isTriangle(double sideA, double sideB, double sideC) {
        return sideA > 0 && sideB > 0 && sideC > 0
                && sideA < sideB + sideC
                && sideB < sideA + sideC
                && sideC < sideB + sideA;
    }
}