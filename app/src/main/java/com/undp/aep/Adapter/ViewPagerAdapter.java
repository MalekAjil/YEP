package com.undp.aep.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.undp.aep.R;
import com.undp.aep.ui.Activity.TrainingActivity;
import com.undp.aep.ui.Fragment.CourseFragment;
import com.undp.aep.ui.Fragment.MainFragment;
import com.undp.aep.ui.Fragment.MyAccountFragment;
import com.undp.aep.ui.Fragment.NotificationFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    Context context;
    public ViewPagerAdapter(TrainingActivity act) {
        super(act);
        this.context=act;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;

         if (position == 0)
        {
            title = context.getString(R.string.last);
        }
        else if (position == 1)
        {
            title = context.getString(R.string.continue_learnig);

        }
        else if (position == 2)
        {
            title = context.getString(R.string.train);

        }
        else if (position == 3)
        {
            title = context.getString(R.string.work);

        }
        return title;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new MainFragment();
        }
        else if (position == 1)
        {
            fragment = new CourseFragment();
        }
        else if (position == 2)
        {
            fragment = new NotificationFragment();
        }
        else if (position == 3)
        {
            fragment = new MyAccountFragment();
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
