package ShippingCost;

public class DeliveryCostCalculator {


    public static double calculateDeliveryCost(int distance, String size, boolean isFragile, String workload) throws IllegalArgumentException {
        // Базовая стоимость доставки в зависимости от расстояния
        double deliveryCost = 0;
        if (distance > 30) {
            deliveryCost = 300;
        } else if (distance > 10) {
            deliveryCost = 200;
        } else if (distance > 2) {
            deliveryCost = 100;
        } else if (distance > 0) {
            deliveryCost = 50;

        }
        if (distance <= 0) {
            throw new IllegalArgumentException("Расстояние не может быть меньше или равно 0");
        }

            // Стоимость в зависимости от габаритов
            if ("large".equals(size)) {
                deliveryCost += 200;
            } else if ("small".equals(size)) {
                deliveryCost += 100;
            }

            // Доплата за хрупкость груза
            if (isFragile) {
                deliveryCost += 300;
                // Если груз хрупкий, нельзя перевозить на расстояние более 30 км
                if (distance > 30) {
                    throw new IllegalArgumentException("Хрупкий груз не может быть доставлен на расстояние более 30 км");
                }
            }

            // Коэффициент загруженности службы доставки
            switch (workload) {
                case "very_high":
                    deliveryCost *= 1.6;
                    break;
                case "high":
                    deliveryCost *= 1.4;
                    break;
                case "increased":
                    deliveryCost *= 1.2;
                    break;
                case "normal":
                    // Если загруженность нормальная, ничего не умножаем
                    break;
                default:
                    throw new IllegalArgumentException("Неизвестный уровень загруженности");
            }

            // Минимальная сумма доставки
            if (deliveryCost < 400) {
                deliveryCost = 400;
            }

            return deliveryCost;
        }

        public static void main (String[]args){
            try {
                // Пример 1: Груз с маленькими габаритами, не хрупкий, расстояние 4 км, нормальная загруженность
                double cost1 = calculateDeliveryCost(4, "small", false, "normal");
                System.out.println("Стоимость доставки: " + cost1 + " рублей");

                // Пример 2: Груз с большими габаритами, хрупкий, расстояние 15 км, повышенная загруженность
                double cost2 = calculateDeliveryCost(15, "large", true, "increased");
                System.out.println("Стоимость доставки: " + cost2 + " рублей");

                // Пример 3: Груз с маленькими габаритами, хрупкий, расстояние 35 км, высокая загруженность
                double cost3 = calculateDeliveryCost(35, "small", true, "high");
                System.out.println("Стоимость доставки: " + cost3 + " рублей");

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
}