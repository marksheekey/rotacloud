package co.uk.happyapper.rotaspacex;

import android.view.View;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    public MainPresenter(MainContract.View view){
        this.view = view;
    }

    @Override
    public void init() {

    }
}
