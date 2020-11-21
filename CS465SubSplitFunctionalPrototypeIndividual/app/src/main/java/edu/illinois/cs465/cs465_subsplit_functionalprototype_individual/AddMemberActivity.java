package edu.illinois.cs465.cs465_subsplit_functionalprototype_individual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
//import android.widget.LinearLayout.LayoutParams;
import android.graphics.Color;
import java.util.ArrayList;

public class AddMemberActivity extends AppCompatActivity {
    public static final String PEEK_RETURN_MSG = "PEEK_RETURN_MSG";
    ArrayList<String> memberList = new ArrayList<String>();
    private Button addMemberButton;
    private EditText searchText;
    private Button finishAddButton;
    ImageButton btnAdd, btnGroup, btnCommunity, btnSettings, btnIndividual;
    String cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Add Members");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        addMemberButton = (Button) this.findViewById(R.id.add_members_search_button);
        finishAddButton = (Button) this.findViewById(R.id.finish_add_button);
        final EditText searchText = (EditText)findViewById(R.id.add_members_search_text);

        cost = getIntent().getExtras().getString("cost_from_group");
        /*
            Add member Button
        */
        addMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(searchText.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please type in user", Toast.LENGTH_SHORT).show();
                } else {
                    String addedMemberName = searchText.getText().toString();
                    Toast.makeText(getApplicationContext(), "Added member :  " + (addedMemberName), Toast.LENGTH_SHORT).show();
                    memberList.add(addedMemberName);

                    LinearLayout parentLayout = (LinearLayout)findViewById(R.id.search_display);

//                    LinearLayout childLayout = new LinearLayout(AddMemberActivity.this);
//                    childLayout.setOrientation(LinearLayout.HORIZONTAL);
//                    childLayout.setBackgroundColor(Color.parseColor("#ffbeb8"));
//                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//                    params.weight = 1.0f;
//                    params.gravity = Gravity.CENTER;
//                    params.bottomMargin = 15;
//                    childLayout.setLayoutParams(params);

                    RelativeLayout childLayout=new RelativeLayout(AddMemberActivity.this);
                    RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
                    layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

                    Button entered_txt = new Button(AddMemberActivity.this);
                    entered_txt.setText(addedMemberName);
//                    entered_txt.setGravity(Gravity.CENTER | Gravity.BOTTOM);
                    entered_txt.setGravity(Gravity.CENTER);
                    entered_txt.setTextColor(getResources().getColor(android.R.color.black));
                    entered_txt.setPadding(20, 20, 20, 20);
                    entered_txt.setTextSize(25);

                    ImageButton btn = new ImageButton(AddMemberActivity.this);
                    btn.setImageResource(R.drawable.searchh);
                    btn.setBackgroundColor(Color.parseColor("#ffbeb8"));
                    btn.setLayoutParams(layoutParams);

                    childLayout.addView(entered_txt);
//                    childLayout.addView(btn);
                    parentLayout.addView(childLayout);
                }
            }
        });

        finishAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddMemberActivity.this, GroupSubscription.class);
                intent.putExtra("memberList", memberList);
                intent.putExtra("cost", cost);
                startActivity(intent);
            }
        });


        btnAdd = (ImageButton) findViewById(R.id.add_subscription_button);
        btnGroup = (ImageButton) findViewById(R.id.group_subscription_button);
        btnIndividual = (ImageButton) findViewById(R.id.individual_subscription_button);
        btnCommunity = (ImageButton) findViewById(R.id.community_board_button);
        btnSettings = (ImageButton) findViewById(R.id.settings_button);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(AddMemberActivity.this, IndividualSubscription.class);
                startActivity(intent);
            }
        });
        btnGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(AddMemberActivity.this, Subscriptions.class);
                startActivity(intent);
            }
        });
        btnIndividual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(AddMemberActivity.this, Subscriptions.class);
                startActivity(intent);
            }
        });
        btnCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(AddMemberActivity.this, CommunityBoardMain.class);
                startActivity(intent);
            }
        });



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                Intent intent = new Intent(AddMemberActivity.this, GroupSubscription.class);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}