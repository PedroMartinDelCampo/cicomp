package pmg.cicomp.async;

/**
 * Created by pedro on 18/11/16.
 */

public class GetExpositions extends GetRequest {

    private static String URL = BASE_URL + "expositions";

    public GetExpositions() {
        super(URL);
    }

}
