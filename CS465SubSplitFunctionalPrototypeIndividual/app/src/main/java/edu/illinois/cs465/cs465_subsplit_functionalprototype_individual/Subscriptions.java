package edu.illinois.cs465.cs465_subsplit_functionalprototype_individual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class Subscriptions extends AppCompatActivity {
    ImageButton btnAdd, btnGroup, btnCommunity, btnSettings, btnIndividual;

    ////////////
    ListView list;
    String cost_new, subscription_name_new, renewal_date_new, frequency_new, subscription_type_new;
    Intent initial_intent;

    String[] drawable_names ={
            "spotify", "netflix",
            "amazon prime", "prime", "barkbox",
            "chegg", "nordvpn",
            "costco",
    };

    Integer[] drawable_imgid={
            R.drawable.spotify,R.drawable.netflix,
            R.drawable.prime,R.drawable.prime,R.drawable.barkbox,
            R.drawable.chegg,R.drawable.nordvpn,
            R.drawable.costco,
    };

    String[] subscription_name ={
            "Spotify", "Netflix",
            "Amazon Prime", "BarkBox",
            "Chegg", "NordVPN",
    };

    String[] subscription_name_lowercase ={
            "spotify", "netflix",
            "amazon prime", "barkbox",
            "chegg", "nordvpn",
    };

    String[] frequency ={
            "Monthly", "Monthly",
            "Annual", "Monthly",
            "Monthly", "Annual",
    };

    String[] subscription_type ={
            "Group", "Individual",
            "Individual", "Group",
            "Group", "Individual",
    };

    String[] cost ={
            "$3.3", "$12.99",
            "$119", "$15",
            "$5", "$70",
    };

    String[] renewal_date ={
            "12/1/2020", "12/1/2020",
            "1/1/2021", "12/14/2020",
            "12/1/2020", "1/1/2021",
    };

    // -1 if its individual and paid status not needed
    // 0 if group but not yet paid
    // 1 if group but it is paid
    int[] paid_status ={
        0, -1,
        -1, 1,
        1, -1,
    };

    int[] imgid={
            R.drawable.spotify,R.drawable.netflix,
            R.drawable.prime,R.drawable.barkbox,
            R.drawable.chegg,R.drawable.nordvpn,
    };

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
// Save UI state changes to the savedInstanceState.
// This bundle will be passed to onCreate if the process is
// killed and restarted.
        savedInstanceState.putBoolean("StringKeyForBoolean", false);
        savedInstanceState.putDouble("StringKeyForDouble", 3.4);
        savedInstanceState.putInt("StringKeyForInteger", 5);
        savedInstanceState.putString("StringKey", "Folio3/blog");
// etc.
    }

    ////////////



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subscriptions);

        initial_intent = getIntent();
        if (initial_intent.getParcelableExtra("sub_parcel") != null) {
            Toast toast=Toast.makeText(getApplicationContext(),"SUB_PARCEL_NOT  subscription",Toast.LENGTH_SHORT);
            SubscriptionParcel sub_parcel = initial_intent.getParcelableExtra("sub_parcel");
            subscription_name = sub_parcel.getsubscription_name();
            subscription_name_lowercase = sub_parcel.getsubscription_name_lowercase();
            frequency = sub_parcel.getfrequency();
            subscription_type = sub_parcel.getsubscription_type();
            cost = sub_parcel.getcost();
            renewal_date = sub_parcel.getrenewal_date();
            paid_status = sub_parcel.getpaid_status();
            imgid = sub_parcel.getimgid();
        }

        //Bottom nav bar buttons initialization and functionality
        btnAdd = (ImageButton) findViewById(R.id.add_subscription_button);
        btnGroup = (ImageButton) findViewById(R.id.group_subscription_button);
        btnIndividual = (ImageButton) findViewById(R.id.individual_subscription_button);
        btnCommunity = (ImageButton) findViewById(R.id.community_board_button);
        btnSettings = (ImageButton) findViewById(R.id.settings_button);
        ////////////

        if (getIntent().getExtras() != null) {
            //String temp = getIntent().getExtras().getString("asfasdfasdf");
            cost_new = getIntent().getExtras().getString("cost");
            subscription_name_new = getIntent().getExtras().getString("subscription_name");
            renewal_date_new = getIntent().getExtras().getString("renewal_date");
            frequency_new = getIntent().getExtras().getString("frequency");
            if (subscription_name_new != null) {
                Integer current_index = Arrays.asList(subscription_name_lowercase).indexOf(subscription_name_new.toLowerCase());
                if (current_index == -1){
                    //this subscription is not found in the current list by name (make a new one by appending)
                    subscription_name = ArrayUtils.add(subscription_name, subscription_name_new);
                    subscription_name_lowercase = ArrayUtils.add(subscription_name_lowercase,
                            subscription_name_new.toLowerCase());
                    cost = ArrayUtils.add(cost, "$" + cost_new);
                    frequency = ArrayUtils.add(frequency, frequency_new);
                    subscription_type = ArrayUtils.add(subscription_type, "Individual");
                    renewal_date = ArrayUtils.add(renewal_date, renewal_date_new);
                    paid_status = ArrayUtils.add(paid_status, -1);
                    Integer drawable_id = Arrays.asList(drawable_names).indexOf(subscription_name_new.toLowerCase());
                    if (drawable_id == -1){
                        imgid = ArrayUtils.add(imgid, -1);
                    } else {
                        imgid = ArrayUtils.add(imgid, drawable_imgid[drawable_id]);
                    }
                } else {
                    //this subscription name is found within the existing ones (consider this an edit and change values)
                    cost[current_index] = "$" + cost_new;
                    frequency[current_index] = frequency_new;
                    subscription_type[current_index] = "Individual";
                    renewal_date[current_index] = renewal_date_new;
                    paid_status[current_index] = -1;
                }
            }
        }

        MyListAdapter adapter=new MyListAdapter(this, subscription_name, frequency,subscription_type,cost,renewal_date,paid_status,imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {
                    //code specific to first list item
                    Toast.makeText(getApplicationContext(),"Place Your First Option Code",Toast.LENGTH_SHORT).show();
                }

                else if(position == 1) {
                    //code specific to 2nd list item
                    Toast.makeText(getApplicationContext(),"Place Your Second Option Code",Toast.LENGTH_SHORT).show();
                }

                else if(position == 2) {

                    Toast.makeText(getApplicationContext(),"Place Your Third Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 3) {

                    Toast.makeText(getApplicationContext(),"Place Your Forth Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 4) {

                    Toast.makeText(getApplicationContext(),"Place Your Fifth Option Code",Toast.LENGTH_SHORT).show();
                }

            }
        });
        ////////////



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Subscriptions.this, IndividualSubscription.class);
                SubscriptionParcel sub_parcel = new SubscriptionParcel(subscription_name,subscription_name_lowercase,
                        frequency,subscription_type,cost,renewal_date,paid_status,imgid);
                intent.putExtra("sub_parcel", sub_parcel);
                startActivity(intent);
            }
        });
        btnGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Subscriptions.this, Subscriptions.class);
                SubscriptionParcel sub_parcel = new SubscriptionParcel(subscription_name,subscription_name_lowercase,
                        frequency,subscription_type,cost,renewal_date,paid_status,imgid);
                intent.putExtra("sub_parcel", sub_parcel);
                startActivity(intent);
            }
        });
        btnIndividual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Subscriptions.this, Subscriptions.class);
                SubscriptionParcel sub_parcel = new SubscriptionParcel(subscription_name,subscription_name_lowercase,
                        frequency,subscription_type,cost,renewal_date,paid_status,imgid);
                intent.putExtra("sub_parcel", sub_parcel);
                startActivity(intent);
            }
        });
        btnCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Subscriptions.this, CommunityBoardMain.class);
                SubscriptionParcel sub_parcel = new SubscriptionParcel(subscription_name,subscription_name_lowercase,
                        frequency,subscription_type,cost,renewal_date,paid_status,imgid);
                intent.putExtra("sub_parcel", sub_parcel);
                startActivity(intent);
            }
        });
    }
}