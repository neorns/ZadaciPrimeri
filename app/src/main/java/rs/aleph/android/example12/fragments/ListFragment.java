package rs.aleph.android.example12.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import rs.aleph.android.example12.R;
import rs.aleph.android.example12.activities.FirstActivity;
import rs.aleph.android.example12.activities.SecondActivity;
import rs.aleph.android.example12.provider.JeloProvider;

/**
 * Created by androiddevelopment on 6.2.17..
 */

public class ListFragment extends Fragment {

    OnItemSelectedListener listener;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        final List<String> jelaNazivi = JeloProvider.getJelaNazivi();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, jelaNazivi);
        ListView listView = (ListView) getActivity().findViewById(R.id.listJela);

        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    listener.onItemSelected(position);
            }
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        if (container == null) {
            return null;
        }

        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OnItemSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnItemSelectedListener");
        }
    }

    // Container activity must implement this interface
    public interface OnItemSelectedListener {

        public void onItemSelected(int position);
    }
}
