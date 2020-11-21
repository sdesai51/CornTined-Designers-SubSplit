package edu.illinois.cs465.cs465_subsplit_functionalprototype_individual;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

public class GroupSubscription extends AppCompatActivity implements View.OnClickListener {
    public static final int PEEK_ACTIVITY_CODE = 1;
    private ArrayList<String> memberList;
    private Button addMemberButton, btnSave;
    ImageButton btnAdd, btnGroup, btnCommunity, btnSettings, btnIndividual;
    int numMembers;
    String totalCost, cost;
//    private EditText searchText;
//    String totalCost = getIntent().getStringExtra("data");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_subscription);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Group Payment Setting");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        cost = getIntent().getExtras().getString("cost_from_ind");
//        if (getIntent().hasExtra("cost")){
//            totalCost = getIntent().getStringExtra("cost");
//        }
//        Bundle intentExtras = getIntent().getExtras();
//        totalCost = intentExtras.get("cost").toString();

        memberList = (ArrayList<String>) getIntent().getSerializableExtra("memberList");

        addMemberButton = (Button) findViewById(R.id.add_members_button);
        addMemberButton.setOnClickListener(this);

        if (!(memberList == null)) {
            numMembers = memberList.size();
            String curr_name;
            for (int counter = 0; (counter < 5) && (counter < memberList.size()); counter++) {
                curr_name = memberList.get(counter);
                String member_display_id = "added_user_display_" + Integer.toString(counter);
                int resourceId = getResources().getIdentifier(member_display_id, "id", getPackageName());
                Button curr_button = (Button) findViewById(resourceId);
                curr_button.setText(curr_name);
                curr_button.setVisibility(View.VISIBLE);
                
                String member_split_cost = "split_user_cost_" + Integer.toString(counter);
                int splitCost = getResources().getIdentifier(member_split_cost, "id", getPackageName());
                TextView split_cost_text = (TextView) findViewById(splitCost);
                int split = 0;
                if (getIntent().hasExtra("cost")){
                    totalCost = getIntent().getExtras().getString("cost");
                    split = Integer.parseInt(totalCost)/numMembers;
                }
                split_cost_text.setText("$" + Integer.toString(split) + ".00");
                String member_split_id = "split_user_" + Integer.toString(counter);
                int splitId = getResources().getIdentifier(member_split_id, "id", getPackageName());
                TextView split_tv = (TextView) findViewById(splitId);
                split_tv.setText(curr_name);

                String show_split_id = "show_split_" + Integer.toString(counter);
                int showSplitId = getResources().getIdentifier(show_split_id, "id", getPackageName());
                RelativeLayout split_rl = (RelativeLayout) findViewById(showSplitId);
                split_rl.setVisibility(View.VISIBLE);
            }
        }

        btnAdd = (ImageButton) findViewById(R.id.add_subscription_button);
        btnGroup = (ImageButton) findViewById(R.id.group_subscription_button);
        btnIndividual = (ImageButton) findViewById(R.id.individual_subscription_button);
        btnCommunity = (ImageButton) findViewById(R.id.community_board_button);
        btnSettings = (ImageButton) findViewById(R.id.settings_button);
        btnSave = (Button) findViewById(R.id.save_button);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(GroupSubscription.this, IndividualSubscription.class);
                startActivity(intent);
            }
        });
        btnGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(GroupSubscription.this, Subscriptions.class);
                startActivity(intent);
            }
        });
        btnIndividual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(GroupSubscription.this, Subscriptions.class);
                startActivity(intent);
            }
        });
        btnCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(GroupSubscription.this, CommunityBoardMain.class);
                startActivity(intent);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(GroupSubscription.this, Subscriptions.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add_members_button) {
            Intent intent = new Intent(this, AddMemberActivity.class);
            startActivity(intent);
            Bundle extras = new Bundle();
            extras.putString("cost_from_group", cost);
            intent.putExtras(extras);
            startActivityForResult(intent, PEEK_ACTIVITY_CODE);
        }
    }

    public void onActivityResult(int activityCode, int resultCode, Intent intent) {
        super.onActivityResult (activityCode, resultCode, intent);
        if (activityCode == PEEK_ACTIVITY_CODE); {
            if (resultCode == Activity.RESULT_OK) {
                if (intent != null) {
                    String s = intent.getStringExtra(AddMemberActivity.PEEK_RETURN_MSG);
                    if (s != null) {
                        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

}