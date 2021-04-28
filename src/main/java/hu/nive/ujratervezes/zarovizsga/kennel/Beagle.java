package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog {

    private int happiness;

    public Beagle(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getHappiness() {
        return happiness;
    }

    @Override
    void feed() {
        happiness += 2;
    }

    @Override
    void play(int hours) {
        happiness += hours * 2;
    }
}
