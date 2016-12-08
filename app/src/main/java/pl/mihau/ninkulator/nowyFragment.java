package pl.mihau.ninkulator;

/**
 * Created by x on 06.12.2016.
 */

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class nowyFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public nowyFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static nowyFragment newInstance(int sectionNumber) {
        nowyFragment fragment = new nowyFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        TextView textView = (TextView) view.findViewById(R.id.section_label);
        final int a = getArguments().getInt(ARG_SECTION_NUMBER);
        textView.setText(getString(R.string.section_format, a));

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "8g97y089 " + String.valueOf(a), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        return view;

    }
}
