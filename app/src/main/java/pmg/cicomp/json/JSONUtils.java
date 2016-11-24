package pmg.cicomp.json;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pmg.cicomp.ListItem;

/**
 * Created by pedro on 18/11/16.
 */

public class JSONUtils {

    private static JSONUtils instance = new JSONUtils();
    private JSONUtils() {}

    public static JSONUtils getInstance() {
        return instance;
    }

    public List<ListItem> toListItems(String json) {
        List<ListItem> items = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                ListItem item = new ListItem(
                        obj.getInt("id"),
                        obj.getString("name"),
                        obj.getString("description"),
                        obj.getString("instructor"),
                        obj.getString("organization"),
                        obj.getString("type"),
                        obj.getString("from"),
                        obj.getString("to")
                );
                items.add(item);
            }
            return items;
        } catch (JSONException e) {
            return items;
        }
    }

}
