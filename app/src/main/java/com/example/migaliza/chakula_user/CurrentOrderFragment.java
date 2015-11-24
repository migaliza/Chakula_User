package com.example.migaliza.chakula_user;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;


public class CurrentOrderFragment extends ListFragment {
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO implement some logic
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<CurrentOrder> orders;
        Controller mycontrol = new Controller();
        int user_id = 58062016;
        String url = "http://10.10.33.36/chakula/controller/ajax-action.php?cmd=23&user_id="+user_id;
        String cmd = "current";
        mycontrol.execute(cmd, url);
        try {
            Thread.sleep(500);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        orders = mycontrol.currentOrders;
        CurrentOrderAdapter adapter = new CurrentOrderAdapter(getActivity(), orders);
        setListAdapter(adapter);
    }
}
