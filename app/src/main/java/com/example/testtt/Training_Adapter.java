package com.example.testtt;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/* public class Training_Adapter extends ArrayAdapter {
    public Training_Adapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    private Context mContent;

*/
 class TrainingAdapter extends ArrayAdapter<Training> {
public TrainingAdapter(Context context, int textViewResourceId,
                       ArrayList<Training> TaskList2) {
        super(context, textViewResourceId, TaskList2);
        mContext = context;
        this.all_data = TaskList2;
        }


private Context mContext;
public ArrayList<Training> all_data;


private class ViewHolder {
    TextView training_name, training_center, training_certificate,training_date,training_duratuin;
}

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.training_item, null);
            holder = new ViewHolder();
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Log.i(TAG, "ProductAdapter: " + position);

        final Training t = Form.getInstance(false).AllCourses.get(position);

        holder.training_name = (TextView) convertView.findViewById(R.id.training_name);
        holder.training_center = (TextView) convertView.findViewById(R.id.training_center);
        holder.training_certificate = (TextView) convertView.findViewById(R.id.training_certificate);
        holder.training_date = (TextView) convertView.findViewById(R.id.training_date);
        holder.training_duratuin = (TextView) convertView.findViewById(R.id.training_duration);
        holder.training_name.setText(t.Name);
        holder.training_center.setText(t.Center);
        holder.training_certificate.setText(t.Successful);
        holder.training_date.setText(t.Date);
        holder.training_duratuin.setText(t.Duration);


        return convertView;

    }


}