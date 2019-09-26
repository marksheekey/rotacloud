package co.uk.happyapper.rotaspacex;

import android.util.Log;
import android.view.View;

import co.uk.happyapper.rotaspacex.Data.Data;
import co.uk.happyapper.rotaspacex.Models.RocketView;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private boolean metric;

    public MainPresenter(MainContract.View view){
        this.view = view;
    }

    @Override
    public void init() {
        metric = true;
        view.startObservingRockets();
        getRockets();
    }


    @Override
    public void gotRockets(RocketView rocketView) {
       if(rocketView==null){
           getRockets();
       }
    }

    private void getRockets(){
        view.getRockets();
    }
}
