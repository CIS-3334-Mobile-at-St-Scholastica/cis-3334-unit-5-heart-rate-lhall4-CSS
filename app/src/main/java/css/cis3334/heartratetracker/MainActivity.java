package css.cis3334.heartratetracker;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    HeartRateList heartRateList;        // The list of heart rate objects
    ArrayAdapter<HeartRate> hrAdapter;
    ListView listViewHeartRate;
    TextView TextViewSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewHeartRate = findViewById(R.id.LVHeartRates);
        TextViewSelect = findViewById(R.id.SelectTextView);

        heartRateList = new HeartRateList();
        heartRateList.InitRandomElderly();

        hrAdapter = new HeartRateAdapter(this, R.layout.heart_rate_row, R.id.textViewPulse, heartRateList);
        hrAdapter.setDropDownViewResource(R.layout.heart_rate_row);
        listViewHeartRate.setAdapter(hrAdapter);

        listViewHeartRate.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HeartRate hr = (HeartRate) adapterView.getItemAtPosition(i);
                TextViewSelect.setText("You selected: " + hr.toString());
                int heartRateRange = hr.getRange();
                int colorValue;
                if(heartRateRange == 0) {
                    colorValue = R.color.colorZone1;
                }
                else if(heartRateRange == 1) {
                    colorValue = R.color.colorZone2;
                }
                else if(heartRateRange == 2) {
                    colorValue = R.color.colorZone3;
                }
                else if(heartRateRange == 3) {
                    colorValue = R.color.colorZone4;
                }
                else {
                    colorValue = R.color.colorZone5;
                }
                TextViewSelect.setTextColor(ContextCompat.getColor(getApplicationContext(), colorValue));
            }
        });
    }
}
