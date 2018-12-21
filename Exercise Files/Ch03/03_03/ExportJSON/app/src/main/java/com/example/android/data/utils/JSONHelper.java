package com.example.android.data.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.example.android.data.model.DataItem;
import com.google.gson.Gson;  // use "Gson" objects to manipulate data into Json structures.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class JSONHelper {

    private static final String FILE_NAME = "menuitems.json";
    private static final String TAG = "JSONHelper";

    /**
     * this function 'exportToJSON' uses the Gson library to manipulate
     * the data list into Json structure
     * that can be put into a file.
     * @param context I don't know why the app/activity context is needed for this function
     * @param dataItemList this is the list of data (type DataItem) that will be Json-ified
     * @return true if the file is written successfully, otherwise false.
     */
    public static boolean exportToJSON(Context context, List<DataItem> dataItemList) {
        DataItems menuData = new DataItems();
        menuData.setDataItems(dataItemList);

        Gson gson = new Gson();
        String jsonString = gson.toJson(menuData);
        Log.i(TAG, "Export to Json: " + jsonString);

        FileOutputStream fileOutputStream = null;
        File file = new File(Environment.getExternalStorageDirectory(), FILE_NAME);

        try {
            fileOutputStream = new FileOutputStream(file);
            byte[] jsonStringAsByteArray = jsonString.getBytes();
            fileOutputStream.write(jsonStringAsByteArray);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }


    public static List<DataItem> importFromJSON(Context context) {

        FileReader fileReader = null;

        try {
            File file = new File(Environment.getExternalStorageDirectory(), FILE_NAME);
            fileReader = new FileReader(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    static class DataItems {
        List<DataItem> dataItems;

        public List<DataItem> getDataItems() {
            return dataItems;
        }

        public void setDataItems(List<DataItem> dataItems) {
            this.dataItems = dataItems;
        }
    }

}
