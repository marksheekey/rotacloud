package co.uk.happyapper.rotaspacex;

import co.uk.happyapper.rotaspacex.Models.RocketView;

public class MainContract {

    public interface View{
        void getRockets();
        void startObservingRockets();
    }

    public interface Presenter{
        void init();
        void gotRockets(RocketView rocketView);
    }

}
