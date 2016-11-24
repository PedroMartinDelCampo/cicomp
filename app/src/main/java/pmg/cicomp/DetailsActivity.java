package pmg.cicomp;

import android.content.Intent;
import android.os.Bundle;
import static android.provider.CalendarContract.Events;

import android.provider.CalendarContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DetailsActivity extends AppCompatActivity {

    public static final String EXTRA_ITEM = "pmg.cicomp.item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ListItem item = (ListItem) getIntent().getSerializableExtra(EXTRA_ITEM);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
                    Calendar beginTime = Calendar.getInstance();
                    beginTime.setTime(sdf.parse(item.getFrom()));
                    Calendar endTime = Calendar.getInstance();
                    endTime.setTime(sdf.parse(item.getTo()));
                    Intent intent = new Intent(Intent.ACTION_INSERT)
                            .setData(Events.CONTENT_URI)
                            .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                            .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                            .putExtra(Events.TITLE, "CiComp: " + item.getName())
                            .putExtra(Events.DESCRIPTION, item.getDescription())
                            .putExtra(Events.EVENT_LOCATION, "UABC")
                            .putExtra(Events.AVAILABILITY, Events.AVAILABILITY_BUSY);
                    startActivity(intent);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle(item.getName());
        showListItem(item);
    }

    private void showListItem(ListItem item) {
        TextView detailName = (TextView) findViewById(R.id.detailName);
        detailName.setText(item.getName());

        TextView detailDescription= (TextView) findViewById(R.id.detailDescription);
        detailDescription.setText(item.getDescription());

        TextView detailInstructor = (TextView) findViewById(R.id.detailInstructor);
        detailInstructor.setText(item.getInstructor());

        TextView detailOrganization = (TextView) findViewById(R.id.detailOrganization);
        detailOrganization.setText(item.getOrganization());

        TextView detailDate = (TextView) findViewById(R.id.detailDate);
        detailDate.setText("De " + item.getFrom() + " a " + item.getTo());
    }

}
