package com.example.migaliza.chakula_user;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;


public class MealsFragment extends ListFragment {

    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO implement some logic
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<Meal> meals;
        Controller mycontrol = new Controller();
        String url = "http://10.10.43.174/chakula/controller/ajax-action.php?cmd=20";
        String cmd = "meals";
        mycontrol.execute(cmd, url);
        try {
            Thread.sleep(500);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        meals = mycontrol.meals;
        MealsAdapter adapter = new MealsAdapter(getActivity(), meals);
        setListAdapter(adapter);
    }
}
