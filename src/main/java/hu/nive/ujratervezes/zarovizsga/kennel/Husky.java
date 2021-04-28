package hu.nive.ujratervezes.zarovizsga.kennel;

public class Husky extends Dog {

    private int happiness;

    public Husky(String name) {
        super(name);
    }

    @Override
    public int getHappiness() {
        return happiness;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    void feed() {
        happiness += 4;
    }

    @Override
    void play(int hours) {
        happiness += hours * 3;
    }
}
