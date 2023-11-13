package com.undp.aep.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;
import com.undp.aep.R;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter  extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

private Context context;
private List<String> mSliderItems = null;

public SliderAdapter(Context context , ArrayList<String> data) {
        this.context = context;
        mSliderItems=data;
        }



@Override
public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
        }

@Override
public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {
        String sliderItem = mSliderItems.get(position);
       Picasso.get().load(sliderItem).into(viewHolder.imageView);
        }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }


    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

     ImageView imageView;

    public SliderAdapterVH(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image);
     }
}

}
