package lab6;

public class Seed extends Coffee {
    Seed(double volume, double quality) {
        super(volume, 30, quality);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Вид кави - зернова\n";
    }
}
