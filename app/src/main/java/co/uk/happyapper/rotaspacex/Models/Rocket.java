package co.uk.happyapper.rotaspacex.Models;

public class Rocket {
    private String rocket_name;
    private Height height;

    class Height{
        private double meters;
        private double feet;
    }

    public String getName(){
        return this.rocket_name;
    }

    public double getHeight(boolean metric){
        if(metric){
            return this.height.meters;
        }else{
            return this.height.feet;
        }
    }

}
