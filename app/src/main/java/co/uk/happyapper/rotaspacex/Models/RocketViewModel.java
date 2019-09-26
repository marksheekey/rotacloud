package co.uk.happyapper.rotaspacex.Models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import co.uk.happyapper.rotaspacex.Data.Data;

public class RocketViewModel extends ViewModel {
    private MutableLiveData<RocketView> rockets;

    public LiveData<RocketView> observeRockets(){
        if(rockets==null){
            rockets = new MutableLiveData<>();
        }
        return rockets;
    }

    public void getRockets(){
        Data data = new Data();
        data.getRockets(new Data.GetRocketsInterface() {
            @Override
            public void gotRockets(ArrayList<Rocket> rocketList) {
                updateRockets(rocketList);
            }

            @Override
            public void onFailure() {
                updateRockets(null);
            }
        });
    }

    private void updateRockets(ArrayList<Rocket> rocketList){
        RocketView currentView = rockets.getValue();
        currentView.setRockets(rocketList);
        rockets.setValue(currentView);
    }
}
