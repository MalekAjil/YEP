package com.undp.aep.ui.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.undp.aep.Adapter.SliderAdapter;

import com.undp.aep.R;

import java.util.ArrayList;


public class MainFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        ArrayList<String> list_of_image = new ArrayList<>();
        list_of_image.add("https://via.placeholder.com/728x200.png?text=hi1");
        list_of_image.add("https://via.placeholder.com/728x200.png?text=hi2");
        list_of_image.add("https://via.placeholder.com/728x200.png?text=hi3");

        SliderView sliderView = v.findViewById(R.id.imageSlider);
        sliderView.setSliderAdapter(new SliderAdapter(getContext() ,  list_of_image));
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.startAutoCycle();

        return v;
    }
}