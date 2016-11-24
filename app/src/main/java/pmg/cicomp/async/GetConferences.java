package pmg.cicomp.async;

/**
 * Created by pedro on 18/11/16.
 */

public class GetConferences extends GetRequest {

    private static String URL = BASE_URL + "conferences";

    public GetConferences() {
        super(URL);
    }

}
