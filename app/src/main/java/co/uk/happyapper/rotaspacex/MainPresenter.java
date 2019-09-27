package co.uk.happyapper.rotaspacex;

import java.util.ArrayList;
import java.util.Collections;

import co.uk.happyapper.rotaspacex.Data.Data;
import co.uk.happyapper.rotaspacex.Models.Rocket;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private Data data;
    private boolean metric;
    private ArrayList<Rocket> rockets;

    public MainPresenter(MainContract.View view, Data data) {
        this.view = view;
        this.data = data;
    }

    @Override
    public void init() {
        metric = true;
        view.hideDisplay();
        view.hideProgres();
        view.hideEmpty();
        view.hideError();
        view.setUnits(metric);

        getRockets();
    }

    @Override
    public void unitChange(boolean newUnits) {
        metric = newUnits;
        view.setUnits(metric);
        showList();
    }


    private void getRockets(){
        view.hideEmpty();
        view.hideError();
        view.showProgress();
        data.getRockets(new Data.GetRocketsInterface() {
            @Override
            public void gotRockets(ArrayList<Rocket> rocketList) {
                view.hideProgres();
                if (rocketList == null) {
                    view.displayError();
                    return;
                }
                if (rocketList.size() == 0) {
                    view.displayEmpty();
                    return;
                }
                Collections.sort(rocketList, Collections.reverseOrder());
                rockets = rocketList;
                showList();
            }

            @Override
            public void onFailure() {
                view.hideProgres();
                view.displayError();
            }
        });
    }

    private void showList() {
        view.showDisplay();
        view.showList(metric, rockets);
    }
}
