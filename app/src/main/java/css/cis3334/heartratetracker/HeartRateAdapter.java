package css.cis3334.heartratetracker;

import android.app.Activity;
import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


/**
 * Created by landonhall on 2/13/18.
 */

public class HeartRateAdapter extends ArrayAdapter<HeartRate> {

    private final Context context;
    private HeartRateList hrList;

    public HeartRateAdapter(Context context, int rowLayout, int dummyTv, HeartRateList hrList) {
        super(context, rowLayout, dummyTv, hrList.getList());
        this.context = context;
        this.hrList = hrList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.heart_rate_row, null);
        HeartRate hr = hrList.getHeartRate(position);

        TextView PulseTextView = view.findViewById(R.id.textViewPulse);
        String PulseString = hr.getPulse().toString() + " - " + hr.getRangeName() + " - " + hr.getRangeDescrtiption() ;
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
        Spannable spannable = new SpannableString(PulseString);

        spannable.setSpan(new ForegroundColorSpan(context.getResources().getColor(colorValue)), 0, hr.getPulse().toString().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        PulseTextView.setText(spannable, TextView.BufferType.SPANNABLE);
        //PulseTextView.setFontFeatureSettings();

        return(view);

    }
}
