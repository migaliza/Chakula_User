package com.example.migaliza.chakula_user;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;


public class MealsFragment extends ListFragment implements AbsListView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView myadapter, View view, int position, long id) {
        // TODO implement some logic
       Toast.makeText(getActivity(), "Hello", Toast.LENGTH_LONG).show();

        //String toast = "Hello";
    }

    //@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<Meal> meals;
        Controller mycontrol = new Controller();
        String url = "http://10.10.56.70/chakula/controller/ajax-action.php?cmd=20";
        String cmd = "meals";
        mycontrol.execute(cmd, url);
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        meals = mycontrol.meals;
        MealsAdapter adapter = new MealsAdapter(getActivity(), meals);
        setListAdapter(adapter);
    }
}
