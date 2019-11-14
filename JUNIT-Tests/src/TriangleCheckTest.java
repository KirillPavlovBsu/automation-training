import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TriangleCheckTest {
    @Test
    @DisplayName("Все стороны отрицательные")
    void testWithAllNegativeSideSizes() {
        Assertions.assertFalse(TriangleCheck.isTriangle(-100, -100, -100));
    }

    @Test
    @DisplayName("Одна сторона отрицательная")
    void testWithNegativeSideSize() {
        Assertions.assertFalse(TriangleCheck.isTriangle(3, 4.6, -100));
    }

    @Test
    @DisplayName("Проверка на прямой треугольник")
    void testWithSideSizesOfRightTriangle() {
        Assertions.assertTrue(TriangleCheck.isTriangle(4, 5, 3));
    }

    @Test
    @DisplayName("Тест на острый треугольник")
    void testWithSideSizesOfAcuteTriangle() {
        Assertions.assertTrue(TriangleCheck.isTriangle(2.87, 97.34, 95.961));
    }

    @Test
    @DisplayName("Тест с нулевыми сторонами")
    void testWithZeroSideSizes() {
        Assertions.assertFalse(TriangleCheck.isTriangle(0, 0, 0));
    }

    @Test
    @DisplayName("Тест со стороно, которая явлется суммой квадратов - 1")
    void testWithSideLessThanSumOfTheSquares() {
        Assertions.assertTrue(TriangleCheck.isTriangle(36, 17, 36*36 + 17*17-1));
    }

    @Test
    @DisplayName("Тест со слишком длинной стороной")
    void testWithLastTooLongSide() {
        Assertions.assertFalse(TriangleCheck.isTriangle(24, 12, 540));
    }

    @Test
    @DisplayName("Тест на равносторонний треугольник")
    void testWithEqualiteralTriangle() {
        Assertions.assertTrue(TriangleCheck.isTriangle(50, 50, 50));
    }

    @Test
    @DisplayName("Тест с одной нулевой стороной")
    void testWithOneZeroSideSize() {
        Assertions.assertFalse(TriangleCheck.isTriangle(30, 50, 0));
    }

    @Test
    @DisplayName("Тест с равнобедренным треугольником")
    void testWithIsoscelesTriangle() {
        Assertions.assertTrue(TriangleCheck.isTriangle(2,2,5));
    }
}