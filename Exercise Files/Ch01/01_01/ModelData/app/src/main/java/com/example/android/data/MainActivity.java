package com.example.android.data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
// import android.widget.TextView;

import com.example.android.data.model.DataItem;
import com.example.android.data.sample.SampleDataProvider;

import java.util.ArrayList;
import java.util.Collections;
// Ch01-02  import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

 //Ch01-02       TextView tvOut;
        List<DataItem> dataItemList = SampleDataProvider.dataItemList;
        List<String> dataItemNames = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
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
            Collections.sort(dataItemNames);  // no custom comparator needed as opposed to Ch01-02 code.

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this, android.R.layout.simple_list_item_1, dataItemNames);

            ListView listView = (ListView) findViewById(android.R.id.restolist);
            listView.setAdapter(adapter);
        }
}
