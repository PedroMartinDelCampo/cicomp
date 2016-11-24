package pmg.cicomp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 20/10/16.
 */

public abstract class Section extends Fragment {

    private View view;

    protected String title;
    protected List<ListItem> items;

    public Section() {
        title = "";
        items = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<ListItem> getItems() {
        return items;
    }

    protected void setItems(List<ListItem> items) {
        this.items = items;
        ListView list = (ListView) view.findViewById(R.id.list);
        list.setAdapter(new ListAdapter(getContext(), items));
        list.setOnItemClickListener(new OpenDetails(getContext(), items));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        refresh();
        Button refresh = (Button) view.findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
            }
        });
        return view;
    }

    public abstract void refresh();

}
