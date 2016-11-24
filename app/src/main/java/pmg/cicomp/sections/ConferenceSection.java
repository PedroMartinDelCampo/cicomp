package pmg.cicomp.sections;

import android.util.Log;

import java.util.ArrayList;

import pmg.cicomp.ListItem;
import pmg.cicomp.Section;
import pmg.cicomp.async.GetConferences;
import pmg.cicomp.async.GetRequest;
import pmg.cicomp.json.JSONUtils;

/**
 * Created by pedro on 20/10/16.
 */

public class ConferenceSection extends Section {

    public ConferenceSection() {
        title = "Conferencias";
    }

    public void refresh() {
        GetConferences conferencesRequest = new GetConferences();
        conferencesRequest.setOnResult(new GetRequest.Listener() {
            @Override
            public void onResult(String result) {
                setItems(JSONUtils.getInstance().toListItems(result));
            }
        });
        conferencesRequest.execute();
    }

}
