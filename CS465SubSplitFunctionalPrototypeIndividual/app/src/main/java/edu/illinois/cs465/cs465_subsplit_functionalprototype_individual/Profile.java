package edu.illinois.cs465.cs465_subsplit_functionalprototype_individual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;

public class Profile extends AppCompatActivity {

    ImageButton btnAdd, btnGroup, btnCommunity, btnSettings, btnIndividual;
    Button btnBack;
    Intent initial_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_window);

        btnBack = (Button) findViewById(R.id.back_arrow);
        initial_intent = getIntent();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Profile.this, CommunityBoardMain.class);
                if (initial_intent.getParcelableExtra("sub_parcel") != null) {
                    SubscriptionParcel sub_parcel = initial_intent.getParcelableExtra("sub_parcel");
                    intent.putExtra("sub_parcel", sub_parcel);
                }
                startActivity(intent);
            }
        });
    }
}