package pmg.cicomp.sections;

import android.util.Log;

import java.util.ArrayList;

import pmg.cicomp.ListItem;
import pmg.cicomp.Section;
import pmg.cicomp.async.GetExpositions;
import pmg.cicomp.async.GetRequest;
import pmg.cicomp.async.GetWorkshops;
import pmg.cicomp.json.JSONUtils;

/**
 * Created by pedro on 20/10/16.
 */

public class WorkshopSection extends Section {

    public WorkshopSection() {
        title = "Talleres";
    }

    public void refresh() {
        GetWorkshops workshopRequest = new GetWorkshops();
        workshopRequest.setOnResult(new GetRequest.Listener() {
            @Override
            public void onResult(String result) {
                setItems(JSONUtils.getInstance().toListItems(result));
            }
        });
        workshopRequest.execute();
    }

}
