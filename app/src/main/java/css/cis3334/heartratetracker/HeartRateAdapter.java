package css.cis3334.heartratetracker;

import android.app.Activity;
import android.content.Context;
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

        TextView PulseTextView = (TextView) view.findViewById(R.id.textViewPulse);
        PulseTextView.setText(hr.getPulse().toString());

        return(view);

    }
}
