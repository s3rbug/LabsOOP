package lab6;

public class Coffee {
    private double volume, price, quality;

    Coffee(double volume, double price, double quality) {
        this.volume = volume;
        this.price = price;
        this.quality = quality;
    }

    double pricePerVolume() {
        if (volume == 0) {
            return 0;
        }
        return price / volume;
    }

    double getVolume() {
        return volume;
    }

    double getPrice() {
        return price;
    }

    double getQuality() {
        return quality;
    }

    double getVolumeByPrice(double customPrice) {
        return customPrice / pricePerVolume();
    }

    @Override
    public String toString() {
        return "Ціна: " + price +
                "\nОбсяг: " + volume +
                "\nЯкість: " + quality + "%" +
                "\nСпіввідношення ціни до ваги: " + pricePerVolume() + "\n";
    }
}
