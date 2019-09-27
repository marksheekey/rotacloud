package co.uk.happyapper.rotaspacex.Data;
import java.util.ArrayList;

import co.uk.happyapper.rotaspacex.Models.Rocket;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Data {
    private RocketAPI api;

    public Data(RocketAPI api) {
        this.api = api;
    }
    public void getRockets(final GetRocketsInterface callback){
        Call<ArrayList<Rocket>> call = api.getRockets();
        call.enqueue(new Callback<ArrayList<Rocket>>() {
            @Override
            public void onResponse(Call<ArrayList<Rocket>> call, Response<ArrayList<Rocket>> response) {
                if(response.errorBody()!=null){
                    callback.onFailure();
                    return;
                }
                callback.gotRockets(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Rocket>> call, Throwable t) {
                callback.onFailure();
            }
        });
    }

    public interface GetRocketsInterface{
        void gotRockets(ArrayList<Rocket> rockets);
        void onFailure();
    }

}
