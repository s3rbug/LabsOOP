package lab6;

public class InstantCoffee extends Coffee {
    double jarPrice, jarVolume;

    InstantCoffee(double volume, double quality, double jarPrice, double jarVolume) {
        super(volume, 100, quality);
        this.jarPrice = jarPrice;
        this.jarVolume = jarVolume;
    }

    @Override
    double pricePerVolume() {
        if (super.getVolume() + this.jarVolume == 0) {
            return 0;
        }
        return (super.getPrice() + jarPrice) / (super.getVolume() + jarVolume);
    }

    @Override
    double getVolumeByPrice(double customPrice) {
        return (jarPrice + customPrice) / pricePerVolume() - jarVolume;
    }

    @Override
    public String toString() {
        return super.toString() + "Ціна банки: " + jarPrice +
                "\nОбсяг банки: " + jarVolume +
                "\nВид кави: розчинна в банках\n";
    }
}
