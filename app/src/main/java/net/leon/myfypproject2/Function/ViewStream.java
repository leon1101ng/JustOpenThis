package net.leon.myfypproject2.Function;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.leon.myfypproject2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewStream extends Fragment {


    public ViewStream() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_stream, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().setTitle("Live Stream");
    }

}
