import ShippingCost.DeliveryCostCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleTest {


    @Test
    @Tag("Smoke")
    @DisplayName("Расстояние 1 км, большой груз, хрупкий, загруженность очень высокая")
    void testCalculateDeliveryCost2() {
        double cost2 = DeliveryCostCalculator.calculateDeliveryCost(1, "large", true, "very_high");
        assertEquals(880, cost2, "Стоимость для данных условий должна быть 880");
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Расстояние 8 км, маленький груз, хрупкий, загруженность высокая")
    void testCalculateDeliveryCost3() {
        double cost3 = DeliveryCostCalculator.calculateDeliveryCost(8, "small", true, "high");
        assertEquals(700, cost3, "Стоимость для данных условий должна быть 700");
    }

    @ParameterizedTest
    @Tag("Smoke")
    @CsvSource({
            "40, small, false, increased, 480.0",  // Пример 1: 40 км, маленький груз, не хрупкий, повышенная загруженность
            "15, large, true, very_high, 1120.0",   // Пример 2: 15 км, большой размер, хрупкий, очень высокая загруженность
            "2, small, true, high, 630.0",        // Пример 3: 2 км, малый размер, хрупкий, высокая загруженность
            "10, small, false, normal, 400.0",     // Пример 4: 10 км, малый размер, не хрупкий, нормальная загруженность
    })
    void testDifferentParameters(int distance, String size, boolean isFragile, String workload, String expected) {
        if (expected.equals("Exception")) {
            assertThrows(IllegalArgumentException.class, () -> {
                DeliveryCostCalculator.calculateDeliveryCost(distance, size, isFragile, workload);
            });
        } else {
            double expectedCost = Double.parseDouble(expected);
            assertEquals(expectedCost, DeliveryCostCalculator.calculateDeliveryCost(distance, size, isFragile, workload));
        }
    }


    @Test
    @Tag("Negative")
    @DisplayName("Расстояние 35 км, маленький груз, хрупкий, загруженность обычная")
        //Ожидается исключение, т.к. хрупкий груз не доставляется на расстояние больше 30 км
    void testDeliveryCostFragileTooFar() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DeliveryCostCalculator.calculateDeliveryCost(35, "small", true, "normal");
        });
        assertEquals("Хрупкий груз не может быть доставлен на расстояние более 30 км", exception.getMessage());
    }

    @Test
    @Tag("Negative")
    @DisplayName("Расстояние 10 км, маленький груз, не хрупкий, загруженность неизвестная")
    void testUnknownWorkload() {
        // Неизвестный уровень загруженности (ожидается исключение)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DeliveryCostCalculator.calculateDeliveryCost(10, "small", false, "unknown");
        });
        assertEquals("Неизвестный уровень загруженности", exception.getMessage());

    }
    @Test
    @Tag("Negative")
    @DisplayName("Расстояние 0 км, маленький груз, хрупкий, загруженность высокая")
    void testNegativeDistance() {
        // Расстояние равно 0 (ожидается исключение)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DeliveryCostCalculator.calculateDeliveryCost(0, "small", true, "high");
        });
        assertEquals("Расстояние не может быть меньше или равно 0", exception.getMessage());

    }
}
