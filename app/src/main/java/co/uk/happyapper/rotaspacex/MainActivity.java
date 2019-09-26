package co.uk.happyapper.rotaspacex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import co.uk.happyapper.rotaspacex.Data.Data;
import co.uk.happyapper.rotaspacex.Models.RocketView;
import co.uk.happyapper.rotaspacex.Models.RocketViewModel;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    private MainPresenter mainPresenter;
    private RocketViewModel rocketViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rocketViewModel = ViewModelProviders.of(this).get(RocketViewModel.class);
        mainPresenter = new MainPresenter(this);
        mainPresenter.init();
    }

    @Override
    public void getRockets() {
        rocketViewModel.getRockets();
    }

    @Override
    public void startObservingRockets() {
        rocketViewModel.observeRockets().observe(this, new Observer<RocketView>() {
            @Override
            public void onChanged(RocketView rocketView) {
                mainPresenter.gotRockets(rocketView);
            }
        });
    }
}
