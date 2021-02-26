package lab4;

public class Plane {
    private double speed;
    private final double maxSpeed;
    private final int maxCountOfPeople;
    private final String planeName;
    private final boolean isAutoPilot;

    Plane(String planeName, double maxSpeed, int maxCountOfPeople, double speed, boolean isAutoPilot) {  // Ініціалізація об'єкта
        this.planeName = planeName;
        this.maxSpeed = maxSpeed;
        this.maxCountOfPeople = maxCountOfPeople;
        this.speed = speed;
        this.isAutoPilot = isAutoPilot;
    }

    public boolean checkEnoughPlace(int peopleCount) {  // Перевірити, чи достатньо сидінь людям
        return peopleCount <= maxCountOfPeople;
    }

    public double getSpeed(){   // Отримати швидкість літака
        return speed;
    }

    public int getMaxCountOfPeople(){   // Отримати максимальну кількість пасажирів
        return maxCountOfPeople;
    }

    @Override
    public String toString() {  // Вивід інформації про літак
        return "Назва літака - " + planeName + "\n" +
                "Максимальна швидкість - " + maxSpeed + "\n" +
                "Максимальна кількість людей в літаку - " + maxCountOfPeople + "\n" +
                "Швидкість - " + speed + "\n" +
                "Автопілот - " + (isAutoPilot ? "так" : "ні");
    }
}
