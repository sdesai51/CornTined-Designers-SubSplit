package edu.illinois.cs465.cs465_subsplit_functionalprototype_individual;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] subscription_name;
    private final String[] frequency;
    private final String[] subscription_type;
    private final String[] cost;
    private final String[] renewal_date;
    private final int[] paid_status;
    private final int[] imgid;

    public MyListAdapter(Activity context, String[] subscription_name,String[] frequency,String[] subscription_type,String[] cost,String[] renewal_date,int[] paid_status,int[] imgid) {
        super(context, R.layout.mylist, subscription_name);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.subscription_name=subscription_name;
        this.frequency=frequency;
        this.subscription_type=subscription_type;
        this.cost=cost;
        this.renewal_date=renewal_date;
        this.paid_status=paid_status;
        this.imgid=imgid;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView subscription_nameText = (TextView) rowView.findViewById(R.id.subscription_name);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView frequencyText = (TextView) rowView.findViewById(R.id.frequency);
        TextView subscription_typeText = (TextView) rowView.findViewById(R.id.subscription_type);
        TextView costText = (TextView) rowView.findViewById(R.id.cost);
        TextView renewal_dateText = (TextView) rowView.findViewById(R.id.renewal_date);

        subscription_nameText.setText(subscription_name[position]);
        if (imgid[position] != -1) {
            imageView.setImageResource(imgid[position]);
        }
        frequencyText.setText(frequency[position]);
        subscription_typeText.setText(subscription_type[position]);
        costText.setText(cost[position]);
        renewal_dateText.setText(renewal_date[position]);

        return rowView;

    };
}
