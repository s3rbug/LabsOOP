package lab6;

public class GroundCoffee extends Coffee {
    double packagePrice, packageVolume;

    GroundCoffee(double volume, double quality, double packagePrice, double packageVolume) {
        super(volume, 50, quality);
        this.packagePrice = packagePrice;
        this.packageVolume = packageVolume;
    }

    @Override
    double pricePerVolume() {
        if (super.getVolume() + this.packageVolume == 0) {
            return 0;
        }
        return (super.getPrice() + packagePrice) / (super.getVolume() + packageVolume);
    }

    @Override
    double getVolumeByPrice(double customPrice) {
        return (packagePrice + customPrice) / pricePerVolume() - packageVolume;
    }

    @Override
    public String toString() {
        return super.toString() + "Ціна упаковки: " + packagePrice +
                "\nОбсяг упаковки: " + packageVolume +
                "\nВид кави: мелена\n";
    }
}
