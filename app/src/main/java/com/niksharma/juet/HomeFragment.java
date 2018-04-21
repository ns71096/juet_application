package com.niksharma.juet;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private int i;
    private int[] image={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4};
    public  ImageView img;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public View view;

    String[] listdata={"University",
            "Academics",
            "Faculties and Departments",
            "Laboratories",
            "Research"
    };
    String[] adi_info={"About University",
            "About Academics",
            "About Faculties and Departments",
            "About Laboratories",
            "About Research"
    };
    int[] image_list={
            R.drawable.university,R.drawable.acad,R.drawable.fad,
    R.drawable.lab,R.drawable.research};

    ListView list;
    AppCompatActivity context;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }





    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view=inflater.inflate(R.layout.fragment_home, container, false);
        this.img=view.findViewById(R.id.imageView2);
        this.list=view.findViewById(R.id.listView);
        i=1;


        return this.view;
    }

    public void setImages(final MainActivity obj)
    {
        this.context=obj;
        Thread t=new Thread(){
          @Override
          public void run()
          {
              while(!isInterrupted())
              {
                  try {
                      Thread.sleep(3000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  obj.runOnUiThread(new Runnable() {
                      @Override
                      public void run() {
                          img.setImageResource(image[i]);
                          i++;
                          if(i==image.length)
                              i=0;

                      }
                  });
              }
          }
        };
        t.start();

    }
    public void setListView()
    {
        Thread t=new Thread(){
            @Override
            public void run()
            {

                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            final Adapter adapter=new Adapter(context,listdata,image_list,adi_info);
                            list.setAdapter(adapter);
                        }
                    });

            }
        };
        t.start();



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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            Toast.makeText(getContext(),"Home Fragment",Toast.LENGTH_LONG).show();
        }
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
