package pmg.cicomp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pedro on 20/10/16.
 */

public class ListAdapter extends ArrayAdapter<ListItem> {

    public ListAdapter(Context context, List<ListItem> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        ListItem item = getItem(position);
        View root = (convertView == null) ?
                inflater.inflate(R.layout.layout_list_item, parent, false) :
                convertView;

        if (item != null) {
            TextView listItemName = (TextView) root.findViewById(R.id.listItemName);
            listItemName.setText(item.getName());

            TextView listItemDescription = (TextView) root.findViewById(R.id.listItemDescription);
            listItemDescription.setText(item.getDescription());
        }

        return root;
    }
}
