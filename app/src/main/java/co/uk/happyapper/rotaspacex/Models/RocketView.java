package co.uk.happyapper.rotaspacex.Models;

import java.util.ArrayList;

public class RocketView {
    private ArrayList<Rocket> rockets;
    private int status;


    public void setRockets(ArrayList<Rocket> rockets){
        if(this.rockets==null){
            this.rockets = new ArrayList<>();
        }
        this.rockets = rockets;
    }

    public void setStatus(int status){
        this.status=status;
    }

    public int getStatus(){
        return this.status;
    }

    public ArrayList<Rocket> getRockets(){
        return this.rockets;
    }
}
