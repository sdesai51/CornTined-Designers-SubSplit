package edu.illinois.cs465.cs465_subsplit_functionalprototype_individual;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
    private Button addMemberButton;
//    private EditText searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_subscription);
        setTitle("Group Payment Setting");

        memberList = (ArrayList<String>) getIntent().getSerializableExtra("memberList");

        addMemberButton = (Button) findViewById(R.id.add_members_button);
        addMemberButton.setOnClickListener(this);

        if (!(memberList == null)) {
//            String curr_name;
//            for (int counter = 0; counter < memberList.size(); counter++) {
//                curr_name = memberList.get(counter);
//                String member_display_id = "added_user_display_" + Integer.toString(counter);
//                int resourceId = getResources().getIdentifier(member_display_id, "drawable", getPackageName());
//                Button curr_button = (Button) findViewById(resourceId);
//                curr_button.setText(curr_name);
//            }
            String curr_name = memberList.get(0);
            Button curr_button = (Button) findViewById(R.id.added_user_display_1);
            curr_button.setText(curr_name);

//            String curr_name = memberList.get(0);
//            String member_display_id = "added_user_display_" + Integer.toString(0);
//            int resourceId = getResources().getIdentifier(member_display_id, "drawable", getPackageName());
//            Button curr_button = (Button) findViewById(resourceId);
//            curr_button.setText(curr_name);
        }

//        addMemberButton = (Button) this.findViewById(R.id.add_members_button);
//        final EditText searchText = (EditText)findViewById(R.id.add_members_text);
//
//        /*
//            Add member Button
//        */
//        addMemberButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(searchText.getText().toString().isEmpty())
//                {
//                    Toast.makeText(getApplicationContext(), "Please type in user", Toast.LENGTH_SHORT).show();
//                } else {
//                    String addedMemberName = searchText.getText().toString();
//                    Toast.makeText(getApplicationContext(), "Added member :  " + (addedMemberName), Toast.LENGTH_SHORT).show();
//
//                    LinearLayout parentLayout = (LinearLayout)findViewById(R.id.added_display);
//
//                    LinearLayout childLayout = new LinearLayout(MainActivity.this);
//                    childLayout.setOrientation(LinearLayout.HORIZONTAL);
//                    childLayout.setBackgroundColor(Color.parseColor("#ffbeb8"));
//                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//                    params.weight = 1.0f;
//                    params.gravity = Gravity.CENTER;
//                    params.bottomMargin = 15;
//                    childLayout.setLayoutParams(params);
////
////                    RelativeLayout childLayout=new RelativeLayout(MainActivity.this);
////                    RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
////                    layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
////                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
//
////                    TextView entered_txt = new TextView(MainActivity.this);
////                    entered_txt.setText(addedMemberName);
////                    entered_txt.setTextSize(30);
////                    entered_txt.setGravity(Gravity.CENTER | Gravity.BOTTOM);
//////                    entered_txt.setLayoutParams(layoutParams);
////
////                    ImageButton btn = new ImageButton(MainActivity.this);
////                    btn.setImageResource(R.drawable.searchh);
////                    btn.setBackgroundColor(Color.parseColor("#ffbeb8"));
//////                    btn.setLayoutParams(layoutParams);
//
//                    Button btn = new Button(MainActivity.this);
//                    btn.setText(addedMemberName);
//                    btn.setTextSize(20);
//                    btn.setBackgroundColor(Color.parseColor("#ffbeb8"));
//                    btn.setGravity(Gravity.CENTER_HORIZONTAL);
//
////                    btn.setLayoutParams(layoutParams);
//
////                    childLayout.addView(entered_txt);
//                    childLayout.addView(btn);
//                    parentLayout.addView(childLayout);
//                }
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add_members_button) {
            Intent intent = new Intent(this, AddMemberActivity.class);
            startActivity(intent);
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