package edu.illinois.cs465.cs465_subsplit_functionalprototype_individual;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;

import android.widget.AdapterView.OnItemSelectedListener;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;


public class IndividualSubscription extends AppCompatActivity implements OnItemSelectedListener {
    Button btnGroupSubscription, btnIndividualSubscription;
    ImageButton btnAdd, btnGroup, btnCommunity, btnSettings, btnIndividual;
    EditText edtSubscription, edtCategory, edtTotalCost;
    Spinner selectMonth, selectDay, selectYear, selectRenewal, selectCategory;
    private ImageView imageAddIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.individual_subscription);

        //Initialization of all editText
        edtSubscription=(EditText)findViewById(R.id.subscription_name);
        edtTotalCost=(EditText)findViewById(R.id.total_cost);

        //Initialization of Spinner elements
        selectMonth = (Spinner) findViewById(R.id.month);
        selectDay = (Spinner) findViewById(R.id.day);
        selectYear = (Spinner) findViewById(R.id.year);
        selectRenewal = (Spinner) findViewById(R.id.renewal_interval);
        selectCategory = (Spinner) findViewById(R.id.category);

        //Spinner click listener
        selectMonth.setOnItemSelectedListener(this);
        selectDay.setOnItemSelectedListener(this);
        selectYear.setOnItemSelectedListener(this);
        selectRenewal.setOnItemSelectedListener(this);
        selectCategory.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> monthCategories = new ArrayList<String>();
        monthCategories.add("January");
        monthCategories.add("February");
        monthCategories.add("March");
        monthCategories.add("April");
        monthCategories.add("May");
        monthCategories.add("June");
        monthCategories.add("July");
        monthCategories.add("August");
        monthCategories.add("September");
        monthCategories.add("October");
        monthCategories.add("November");
        monthCategories.add("December");
        List<String> dayCategories = new ArrayList<String>();
        dayCategories.add("1");
        dayCategories.add("2");
        dayCategories.add("3");
        dayCategories.add("4");
        dayCategories.add("5");
        dayCategories.add("6");
        dayCategories.add("7");
        dayCategories.add("8");
        dayCategories.add("9");
        dayCategories.add("10");
        dayCategories.add("11");
        dayCategories.add("12");
        dayCategories.add("13");
        dayCategories.add("14");
        dayCategories.add("15");
        dayCategories.add("16");
        dayCategories.add("17");
        dayCategories.add("18");
        dayCategories.add("19");
        dayCategories.add("20");
        dayCategories.add("21");
        dayCategories.add("22");
        dayCategories.add("23");
        dayCategories.add("24");
        dayCategories.add("25");
        dayCategories.add("26");
        dayCategories.add("27");
        dayCategories.add("28");
        dayCategories.add("29");
        dayCategories.add("30");
        dayCategories.add("31");
        List<String> yearCategories = new ArrayList<String>();
        yearCategories.add("2019");
        yearCategories.add("2020");
        List<String> renewalCategories = new ArrayList<String>();
        renewalCategories.add("Annual");
        renewalCategories.add("Bi-Annual");
        renewalCategories.add("Weekly");
        renewalCategories.add("Monthly");
        List<String> categoryCategories = new ArrayList<String>();
        categoryCategories.add("Academic");
        categoryCategories.add("Entertainment");
        categoryCategories.add("News");
        categoryCategories.add("Sports");
        categoryCategories.add("Shopping");
        categoryCategories.add("Other");

        //Creating adapter for spinner
        ArrayAdapter<String> dataAdapterMonth = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, monthCategories);
        ArrayAdapter<String> dataAdapterDay = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dayCategories);
        ArrayAdapter<String> dataAdapterYear = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, yearCategories);
        ArrayAdapter<String> dataAdapterRenewal = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, renewalCategories);
        ArrayAdapter<String> dataAdapterCategory = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoryCategories);

        //Drop down layout style - list view with radio button
        dataAdapterMonth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterDay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterRenewal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Attaching data adapter to spinner
        selectMonth.setAdapter(dataAdapterMonth);
        selectDay.setAdapter(dataAdapterDay);
        selectYear.setAdapter(dataAdapterYear);
        selectRenewal.setAdapter(dataAdapterRenewal);
        selectCategory.setAdapter(dataAdapterCategory);

        //Initialization of ImageView
        imageAddIcon = (ImageView) findViewById(R.id.add_icon);
        imageAddIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage(IndividualSubscription.this);
            }
        });

        //Initialization of Individual & Group Buttons
        btnGroupSubscription=(Button)findViewById(R.id.group_subscription);
        btnIndividualSubscription=(Button)findViewById(R.id.individual_subscription);


        //Individual button functionality
        btnIndividualSubscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
//                if(edtSubscription.getText().toString().length()==0){
//                    edtSubscription.setError("Subscription Name Not Entered");
//                    edtSubscription.requestFocus();
//                }
//                if(edtCategory.getText().toString().length()==0){
//                    edtCategory.setError("Category Not Entered");
//                    edtCategory.requestFocus();
//                }
//                if(edtTotalCost.getText().toString().length()==0){
//                    edtTotalCost.setError("Total Cost is Required");
//                    edtTotalCost.requestFocus();
//                }
//                else {
//                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(IndividualSubscription.this,SecondActivity.class);
                    intent.putExtra("data",String.valueOf(selectRenewal.getSelectedItem()));
                    startActivity(intent);
//                }
            }
        });

        //Bottom nav bar buttons initialization and functionality
        btnAdd = (ImageButton) findViewById(R.id.add_subscription_button);
        btnGroup = (ImageButton) findViewById(R.id.group_subscription_button);
        btnIndividual = (ImageButton) findViewById(R.id.individual_subscription_button);
        btnCommunity = (ImageButton) findViewById(R.id.community_board_button);
        btnSettings = (ImageButton) findViewById(R.id.settings_button);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(IndividualSubscription.this, IndividualSubscription.class);
                startActivity(intent);
            }
        });
        btnGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(IndividualSubscription.this, Subscriptions.class);
                startActivity(intent);
            }
        });
        btnIndividual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(IndividualSubscription.this, Subscriptions.class);
                startActivity(intent);
            }
        });
        btnCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(IndividualSubscription.this, CommunityBoardMain.class);
                startActivity(intent);
            }
        });
    }


    //Methods to assist with image upload in form
    private void selectImage(Context context) {
        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose your profile picture");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {

                if (options[item].equals("Take Photo")) {
                    Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(takePicture, 0);

                } else if (options[item].equals("Choose from Gallery")) {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto, 1);//one can be replaced with any action code

                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            switch (requestCode) {
                case 0:
                    if (resultCode == RESULT_OK && data != null) {
                        Bitmap selectedImage = (Bitmap) data.getExtras().get("data");
                        imageAddIcon.setImageBitmap(selectedImage);
                    }

                    break;
                case 1:
                    if (resultCode == RESULT_OK && data != null) {
                        Uri selectedImage = data.getData();
                        String[] filePathColumn = {MediaStore.Images.Media.DATA};
                        if (selectedImage != null) {
                            Cursor cursor = getContentResolver().query(selectedImage,
                                    filePathColumn, null, null, null);
                            if (cursor != null) {
                                cursor.moveToFirst();

                                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                                String picturePath = cursor.getString(columnIndex);
                                imageAddIcon.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                                cursor.close();
                            }
                        }

                    }
                    break;
            }
        }
    }

    //Methods to assist with drop down Spinner options
//   @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

//        //Showing selected spinner item
//        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}