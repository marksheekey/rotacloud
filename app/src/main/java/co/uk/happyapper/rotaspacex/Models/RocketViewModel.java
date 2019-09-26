package co.uk.happyapper.rotaspacex.Models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RocketViewModel extends ViewModel {
    private MutableLiveData<RocketView> rockets;

    public LiveData<RocketView> getRockets(){
        if(rockets==null){
            rockets = new MutableLiveData<>();
        }
        return rockets;
    }
}
