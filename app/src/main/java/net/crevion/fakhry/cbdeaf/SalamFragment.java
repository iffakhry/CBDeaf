package net.crevion.fakhry.cbdeaf;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SalamFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SalamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SalamFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPageNo;
    GridView salamGridView;

    String[] gridViewString = {
            "Assalamualaikum",
            "Selamat pagi",
            "Selamat siang",
            "Selamat sore",
            "Selamat malam",
            "Apa kabar?",
            "Sampai jumpa"
    } ;

    int[] gridViewImageId = {
            R.drawable.ic_handshake,
            R.drawable.ic_handshake,
            R.drawable.ic_handshake,
            R.drawable.ic_handshake,
            R.drawable.ic_handshake,
            R.drawable.ic_handshake,
            R.drawable.ic_handshake
    };



    private OnFragmentInteractionListener mListener;

    public SalamFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SalamFragment newInstance(int pageNo) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNo);
        SalamFragment fragment = new SalamFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPageNo = getArguments().getInt(ARG_PAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_salam, container, false);
        SalamGridAdapter salamGridAdapter = new SalamGridAdapter(getActivity(), gridViewString, gridViewImageId);
        salamGridView = (GridView) view.findViewById(R.id.salam_gridview);
        salamGridView.setAdapter(salamGridAdapter);
//        TextView textView = (TextView) view;
//        textView.setText("Fragment #" + mPageNo);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
