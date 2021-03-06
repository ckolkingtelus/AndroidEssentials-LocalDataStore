package com.example.android.data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
// import android.widget.TextView;

import com.example.android.data.model.DataItem;
import com.example.android.data.sample.SampleDataProvider;

import java.util.ArrayList;
import java.util.Collections;
// Ch01-02  import java.util.Comparator;
import java.util.List;

/*
 *
 *  This is really important stuff to write here :)
 *
 */
public class MainActivity extends AppCompatActivity {

 //Ch01-02       TextView tvOut;
        List<DataItem> dataItemList = SampleDataProvider.dataItemList;
        List<String> dataItemNames = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            Log.d("LDS-Kolking", "Main onCreate");
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Ch01-01:
            // DataItem item = new DataItem(null, "My Menu Item", "a cateogry", "description stuff", 1, 10.55, "cake ciocia");

            // Ch01-02: tvOut = (TextView) findViewById(R.id.out);
            // Ch01-01:
            // tvOut.setText(item.toString());

            // Ch01-02:
/* Ch01-02
            tvOut.setText("");
            Collections.sort(dataItemList, new Comparator<DataItem>() {
                @Override
                public int compare(DataItem o1, DataItem o2) {
                    return o1.getItemName().compareTo(o2.getItemName());
                }
            });
*/
            for (DataItem item : dataItemList) {
                //Ch01-02  tvOut.append(item.getItemName() + "\n");
                dataItemNames.add(item.getItemName());
            }
            // I added the 'try-catch' with the Android Studio menu "Code - Surround With.." item, but this try-catch is not really needed here:
            try {
                Collections.sort(dataItemNames);  // no custom comparator needed as opposed to Ch01-02 code.
            } catch (Exception e) {
                e.printStackTrace();
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this, android.R.layout.simple_list_item_1, dataItemNames);

            // ListView listView = (ListView) findViewById(android.R.id.list);
            // NOTE that custom id is not in "android.R":
            ListView listView = (ListView) findViewById(R.id.restolist);
            Log.d("LDS-Kolking", "Main onCreate display list view");
            listView.setAdapter(adapter);
        }
}
