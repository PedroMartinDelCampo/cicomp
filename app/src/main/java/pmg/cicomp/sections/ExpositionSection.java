package pmg.cicomp.sections;

import java.util.ArrayList;

import pmg.cicomp.ListItem;
import pmg.cicomp.Section;
import pmg.cicomp.async.GetConferences;
import pmg.cicomp.async.GetExpositions;
import pmg.cicomp.async.GetRequest;
import pmg.cicomp.json.JSONUtils;

/**
 * Created by pedro on 20/10/16.
 */

public class ExpositionSection extends Section {

    public ExpositionSection() {
        title = "Ponencias";
    }

    public void refresh() {
        GetExpositions expositionsRequest = new GetExpositions();
        expositionsRequest.setOnResult(new GetRequest.Listener() {
            @Override
            public void onResult(String result) {
                setItems(JSONUtils.getInstance().toListItems(result));
            }
        });
        expositionsRequest.execute();
    }

}
