package com.example.asus.magicidapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText etID;  //Not necessary
    Button btnSubmit;
    TextView tvResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);    //connecting the UI to the code
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String idNumber = etID.getText().toString().trim();

                String dob = idNumber.substring(0,4);  //end one is always 1 less

                String dc = idNumber.substring(4,6);

                String uc = idNumber.substring(7,9);

                String union = idNumber.substring(9,11);

                String form = idNumber.substring(11,17);


                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));  //to get to a specific position

                String sGender;

                if (gender == 9)
                {
                    sGender = "City Corporation";
                }
                else if (gender == 5)
                {
                    sGender = "Cantonment Area";
                }
                else if (gender == 2)
                {
                    sGender = "Municipal Area";
                }
                else if (gender == 1)
                {
                    sGender = "Rural Area";
                }
                else if (gender == 3)
                {
                    sGender = "Out of Municipal Area (Town)";
                }
                else
                {
                    sGender = "Wrong NID Number";
                }

                /*int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                String sNationality;

                if (nationality == 0)
                {
                    sNationality = getString(R.string.SA_Citizen);
                }
                else
                {
                    sNationality = getString(R.string.permanent_resident);
                }*/

                String text = "Birth Year is : " + dob + "\n" + "District Code: " + dc + "\n" + "RMO Code: " + sGender + "\n" +
                        "Upazilla / Police Station Code: " + uc + "\n" + "Union Code: " + union + "\n" +
                        "Form Number (When you registered for your NID card): " + form ;

                tvResults.setText(text);

                tvResults.setVisibility(View.VISIBLE);

            }
        });
    }
}
