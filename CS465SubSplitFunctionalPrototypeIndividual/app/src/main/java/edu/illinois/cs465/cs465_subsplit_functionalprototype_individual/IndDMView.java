package edu.illinois.cs465.cs465_subsplit_functionalprototype_individual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class IndDMView extends AppCompatActivity {
    ImageButton btnBack;
    Intent initial_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.individual_dm);

        btnBack = (ImageButton)  findViewById(R.id.back_arrow);
        initial_intent = getIntent();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(IndDMView.this, DMBoard.class);
                if (initial_intent.getParcelableExtra("sub_parcel") != null) {
                    SubscriptionParcel sub_parcel = initial_intent.getParcelableExtra("sub_parcel");
                    intent.putExtra("sub_parcel", sub_parcel);
                }
                startActivity(intent);
            }
        });
    }
}