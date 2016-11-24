package pmg.cicomp.async;

/**
 * Created by pedro on 18/11/16.
 */

public class GetWorkshops extends GetRequest {

    private static String URL = BASE_URL + "workshops";

    public GetWorkshops() {
        super(URL);
    }

}
