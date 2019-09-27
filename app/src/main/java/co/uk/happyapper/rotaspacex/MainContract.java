package co.uk.happyapper.rotaspacex;

import java.util.ArrayList;

import co.uk.happyapper.rotaspacex.Models.Rocket;

public class MainContract {

    public interface View{
        void showProgress();

        void hideProgres();

        void showDisplay();

        void hideDisplay();

        void setUnits(boolean metric);

        void showList(boolean metric, ArrayList<Rocket> rockets);

        void displayEmpty();

        void displayError();

        void hideEmpty();

        void hideError();

    }
    public interface Presenter{
        void init();

        void unitChange(boolean metric);
    }

}
