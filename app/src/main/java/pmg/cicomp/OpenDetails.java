package pmg.cicomp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by pedro on 20/10/16.
 */

public class OpenDetails implements AdapterView.OnItemClickListener {

    private List<ListItem> items;
    private Context context;

    public OpenDetails(Context context, List<ListItem> items) {
        this.context = context;
        this.items = items;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListItem item = items.get(position);
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(DetailsActivity.EXTRA_ITEM, item);
        context.startActivity(intent);
    }
}
