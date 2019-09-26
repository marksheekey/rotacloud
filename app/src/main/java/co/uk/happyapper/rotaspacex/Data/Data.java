package co.uk.happyapper.rotaspacex.Data;
import java.util.ArrayList;

import co.uk.happyapper.rotaspacex.Models.Rocket;
import retrofit2.Call;
import retrofit2.Callback;

public class Data {
    RocketAPI api = RocketAPI.retrofit.create(RocketAPI.class);
    Call<ArrayList<Rocket>> call = api.getRockets();
}
