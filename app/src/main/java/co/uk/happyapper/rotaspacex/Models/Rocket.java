package co.uk.happyapper.rotaspacex.Models;

public class Rocket implements Comparable<Rocket> {
    private String rocket_name;
    private Height height;

    @Override
    public int compareTo(Rocket o) {
        return this.height.feet.compareTo(o.height.feet);
    }

    class Height{
        private Double meters;
        private Double feet;
    }

    public String getRocketName() {
        return rocket_name;
    }

    public String getFormattedHeight(boolean metric) {
        if (metric) {
            return height.meters + " m";
        } else {
            return height.feet + " ft";
        }
    }

    public int getHeight() {
        Double cm = height.meters * 100;
        return cm.intValue();
    }

}
