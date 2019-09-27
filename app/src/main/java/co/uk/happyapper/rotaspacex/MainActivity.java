package co.uk.happyapper.rotaspacex;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.uk.happyapper.rotaspacex.Data.Data;
import co.uk.happyapper.rotaspacex.Data.RocketAPI;
import co.uk.happyapper.rotaspacex.Models.Rocket;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    private MainPresenter mainPresenter;
    private ProgressBar progress;
    private LinearLayout display;
    private TextView units;
    private SwitchCompat unitSwitch;
    private RecyclerView recyclerView;
    private RocketListAdapter adapter;
    private TextView empty;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ;

        progress = findViewById(R.id.progress);
        display = findViewById(R.id.display);
        units = findViewById(R.id.units);
        unitSwitch = findViewById(R.id.unit_switch);
        recyclerView = findViewById(R.id.recycler);
        empty = findViewById(R.id.empty);
        error = findViewById(R.id.error);

        setTitle("Space X rockets");
        setupUI();
        RocketAPI api = RocketAPI.retrofit.create(RocketAPI.class);
        mainPresenter = new MainPresenter(this, new Data(api));
        mainPresenter.init();

    }


    private void setupUI() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        unitSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.unitChange(unitSwitch.isChecked());
            }
        });
    }


    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgres() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void showDisplay() {
        display.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDisplay() {
        display.setVisibility(View.GONE);
    }

    @Override
    public void setUnits(boolean metric) {
        if (metric) {
            units.setText("Metric");
            unitSwitch.setChecked(true);
        } else {
            units.setText("Imperial");
            unitSwitch.setChecked(false);
        }
    }

    @Override
    public void showList(boolean metric, ArrayList<Rocket> rockets) {
        adapter = new RocketListAdapter(MainActivity.this, metric, rockets);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void displayEmpty() {
        empty.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayError() {
        error.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmpty() {
        empty.setVisibility(View.GONE);
    }

    @Override
    public void hideError() {
        error.setVisibility(View.GONE);
    }
}
