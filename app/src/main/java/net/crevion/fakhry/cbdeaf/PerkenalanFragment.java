package net.crevion.fakhry.cbdeaf;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PerkenalanFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PerkenalanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerkenalanFragment extends Fragment implements
        TextToSpeech.OnInitListener{

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPageNo;
    private GridView perkenalanGridView;
    private TextToSpeech tts;

    private static final String[] gridViewString = {
            "Siapa nama anda?",
            "Senang berkenalan dengan anda",
            "Anda tinggal dimana"
    } ;

    private static final int[] gridViewImageId = {
            R.drawable.ic_handshake,
            R.drawable.ic_handshake,
            R.drawable.ic_handshake
    };

    private OnFragmentInteractionListener mListener;

    public PerkenalanFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PerkenalanFragment newInstance(int pageNo) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNo);
        PerkenalanFragment fragment = new PerkenalanFragment();
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
        View view = inflater.inflate(R.layout.fragment_perkenalan, container, false);
        SalamGridAdapter salamGridAdapter = new SalamGridAdapter(getActivity(), gridViewString, gridViewImageId);
        perkenalanGridView = (GridView) view.findViewById(R.id.perkenalan_gridview);
        perkenalanGridView.setAdapter(salamGridAdapter);

        tts = new TextToSpeech(getActivity(), this);

        perkenalanGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                speakOut(gridViewString[position]);
                Toast.makeText(getActivity(), "" + gridViewString[+position]  ,Toast.LENGTH_SHORT).show();
            }
        });
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

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(new Locale("id", "ID"));

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
//                btnSpeak.setEnabled(true);
//                speakOut("Hello");
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void speakOut(String kalimat) {
        tts.setSpeechRate(1.0f);
        tts.speak(kalimat, TextToSpeech.QUEUE_FLUSH, null,"id1");
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
