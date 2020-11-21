package edu.illinois.cs465.cs465_subsplit_functionalprototype_individual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CommunityBoardMain extends AppCompatActivity {

    ImageButton btnAdd, btnGroup, btnCommunity, btnSettings, btnIndividual, btnProfile, btnDMs, btnLiked, btnLiked2;
    Intent initial_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.community_board);

        btnProfile = (ImageButton) findViewById(R.id.profile_);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(CommunityBoardMain.this, Profile.class);
                if (initial_intent.getParcelableExtra("sub_parcel") != null) {
                    SubscriptionParcel sub_parcel = initial_intent.getParcelableExtra("sub_parcel");
                    intent.putExtra("sub_parcel", sub_parcel);
                }
                startActivity(intent);
            }
        });

        btnDMs = (ImageButton) findViewById(R.id.myDms);
        btnDMs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(CommunityBoardMain.this, DMBoard.class);
                if (initial_intent.getParcelableExtra("sub_parcel") != null) {
                    SubscriptionParcel sub_parcel = initial_intent.getParcelableExtra("sub_parcel");
                    intent.putExtra("sub_parcel", sub_parcel);
                }
                startActivity(intent);
            }
        });

        btnLiked = (ImageButton)findViewById(R.id.likebtn);
        btnLiked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLiked.setImageResource(R.drawable.like_highlight);
                TextView tv = (TextView)findViewById(R.id.likect);
                tv.setText("5");
            }
        });

        btnLiked2 = (ImageButton)findViewById(R.id.likebtn2);
        btnLiked2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLiked2.setImageResource(R.drawable.like_highlight);
                TextView tv = (TextView)findViewById(R.id.likect2);
                tv.setText("13");
            }
        });

        //Bottom nav bar buttons initialization and functionality
        btnAdd = (ImageButton) findViewById(R.id.add_subscription_button);
        btnGroup = (ImageButton) findViewById(R.id.group_subscription_button);
        btnIndividual = (ImageButton) findViewById(R.id.individual_subscription_button);
        btnCommunity = (ImageButton) findViewById(R.id.community_board_button);
        btnSettings = (ImageButton) findViewById(R.id.settings_button);

        initial_intent = getIntent();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(CommunityBoardMain.this, IndividualSubscription.class);
                if (initial_intent.getParcelableExtra("sub_parcel") != null) {
                    SubscriptionParcel sub_parcel = initial_intent.getParcelableExtra("sub_parcel");
                    intent.putExtra("sub_parcel", sub_parcel);
                }
                startActivity(intent);
            }
        });
        btnGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(CommunityBoardMain.this, Subscriptions.class);
                if (initial_intent.getParcelableExtra("sub_parcel") != null) {
                    SubscriptionParcel sub_parcel = initial_intent.getParcelableExtra("sub_parcel");
                    intent.putExtra("sub_parcel", sub_parcel);
                }
                startActivity(intent);
            }
        });
        btnIndividual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(CommunityBoardMain.this, Subscriptions.class);
                if (initial_intent.getParcelableExtra("sub_parcel") != null) {
                    SubscriptionParcel sub_parcel = initial_intent.getParcelableExtra("sub_parcel");
                    intent.putExtra("sub_parcel", sub_parcel);
                }
                startActivity(intent);
            }
        });
        btnCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(CommunityBoardMain.this, CommunityBoardMain.class);
                if (initial_intent.getParcelableExtra("sub_parcel") != null) {
                    SubscriptionParcel sub_parcel = initial_intent.getParcelableExtra("sub_parcel");
                    intent.putExtra("sub_parcel", sub_parcel);
                }
                startActivity(intent);
            }
        });
    }
}