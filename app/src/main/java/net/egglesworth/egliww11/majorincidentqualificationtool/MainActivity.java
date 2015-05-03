package net.egglesworth.egliww11.majorincidentqualificationtool;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    //Initialize the values of each question to 0
    int Q1Val = 0;
    int Q2Val = 0;
    int Q3Val = 0;
    int Q4Val = 0;
    int Q5Val = 0;
    int Q6Val = 0;
    int Q7Val = 0;
    int Q8Val = 0;
    int MIRating = 0;
    int Q9Val = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get all the check boxes.
        final CheckBox chkQ1 = (CheckBox) findViewById(R.id.q1);
        final CheckBox chkQ2 = (CheckBox) findViewById(R.id.q2);
        final CheckBox chkQ3 = (CheckBox) findViewById(R.id.q3);
        final CheckBox chkQ4 = (CheckBox) findViewById(R.id.q4);
        final CheckBox chkQ5 = (CheckBox) findViewById(R.id.q5);
        final CheckBox chkQ6 = (CheckBox) findViewById(R.id.q6);
        final CheckBox chkQ7 = (CheckBox) findViewById(R.id.q7);
        final CheckBox chkQ8 = (CheckBox) findViewById(R.id.q8);
        final Spinner spin = (Spinner) findViewById(R.id.workAround);

        //Get the checked items
        chkQ1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            final Integer SDWeight = getResources().getInteger(R.integer.SDWeight);

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (chkQ1.isChecked()) {
                    Q1Val = 1 * SDWeight;
                } else {
                    Q1Val = 0;
                }

                //updateRating();
            }
        });

        chkQ2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            final Integer CBPWeight = getResources().getInteger(R.integer.CBPWeight);

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (chkQ2.isChecked()) {
                    Q2Val = (1 * CBPWeight) / 2;
                } else {
                    Q2Val = 0;
                }
                //updateRating();
            }
        });

        chkQ3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            final Integer CBPWeight = getResources().getInteger(R.integer.CBPWeight);

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (chkQ3.isChecked()) {
                    Q3Val = (1 * CBPWeight) / 2;
                } else {
                    Q3Val = 0;
                }
                //updateRating();
            }
        });

        chkQ4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            final Integer EUWeight = getResources().getInteger(R.integer.EUWeight);

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (chkQ4.isChecked()) {
                    Q4Val = (1 * EUWeight) / 3;
                } else {
                    Q4Val = 0;
                }
                //updateRating();
            }
        });

        chkQ5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            final Integer EUWeight = getResources().getInteger(R.integer.EUWeight);

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (chkQ5.isChecked()) {
                    Q5Val = (1 * EUWeight) / 3;
                } else {
                    Q5Val = 0;
                }
                //updateRating();
            }
        });
        chkQ6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            final Integer EUWeight = getResources().getInteger(R.integer.EUWeight);

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (chkQ6.isChecked()) {
                    Q6Val = (1 * EUWeight) / 3;
                } else {
                    Q6Val = 0;
                }
                //updateRating();
            }
        });

        chkQ7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            final Integer MIWeight = getResources().getInteger(R.integer.MIWeight);

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (chkQ7.isChecked()) {
                    Q7Val = (1 * MIWeight) / 2;
                } else {
                    Q7Val = 0;
                }
                //updateRating();
            }
        });

        chkQ8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            final Integer MIWeight = getResources().getInteger(R.integer.MIWeight);

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (chkQ8.isChecked()) {
                    Q8Val = (1 * MIWeight) / 2;
                } else {
                    Q8Val = 0;
                }
            }
        });

        Button btnReset = (Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtMIRating = (TextView) findViewById(R.id.txtMIRating);
                TextView txtRecommendation = (TextView) findViewById(R.id.txtRecommendation);

                chkQ1.setChecked(false);
                chkQ2.setChecked(false);
                chkQ3.setChecked(false);
                chkQ4.setChecked(false);
                chkQ5.setChecked(false);
                chkQ6.setChecked(false);
                chkQ7.setChecked(false);
                chkQ8.setChecked(false);
                spin.setSelection(0);
                txtMIRating.setText("Major Incident Rating of: 0");
                txtRecommendation.setText("");
                txtRecommendation.setBackgroundColor(0);
            }
        });

        Button btnCalc = (Button) findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRating();
            }

        });
    }
    public void updateRating () {
        //final Integer WorkAroundWeight = (Integer) getResources().getInteger(R.integer.WorkAroundWeight);

        //Get the selected Workaround Value
        final Spinner spin = (Spinner) findViewById(R.id.workAround);
        Integer WorkAround = spin.getSelectedItemPosition();

        //Calculate the value and update the TextView at the bottom
        MIRating = Q1Val + Q2Val + Q3Val + Q4Val + Q5Val +
                Q6Val + Q7Val + Q8Val;

        System.out.println("MIRating: " + MIRating);
        System.out.println(Q1Val);
        System.out.println(WorkAround);

        switch (WorkAround) {
            //case 0:
             //   Q9Val = 0;
             //   break;
            case 1:
                MIRating += 10;
                break;
            case 2:
                MIRating -= 10;
                break;
        }


        TextView txtMIRating = (TextView) findViewById(R.id.txtMIRating);
        TextView txtRecommendation = (TextView) findViewById(R.id.txtRecommendation);
        txtMIRating.setText("Major Incident Rating of " + MIRating);

        if (MIRating == 50) {
            txtRecommendation.setText("Based on this rating, a SWAT should be initiated.");
            txtRecommendation.setBackgroundColor(Color.YELLOW);
        }
        if (MIRating < 50 && MIRating > 0) {
            txtRecommendation.setText("Based on this rating, a Technical Roundtable is recommended, possibly a SWAT.");
            txtRecommendation.setBackgroundColor(Color.GREEN);
        }
        if (MIRating > 50) {
            txtRecommendation.setText("Based on this rating, a Rapid Response should be initiated.");
            txtRecommendation.setBackgroundColor(Color.RED);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
