package kampus.vn;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ArrayList<EarthQuake> list = QueryUtils.extractEarthquakes();
        final ArrayList<EarthQuake> list = QueryUtils.extractEarthquakes();

        //Find ListView from layout
        ListView listView = findViewById(R.id.listView);
        //Create a Adapter
        final EarthquakeAdapter adapter = new EarthquakeAdapter(this, list);
        //Set adapter for List
        listView.setAdapter(adapter);

        //Handle event when item in ListView was clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                EarthQuake earthQuake = adapter.getItem(i);
                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(earthQuake.getUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });
    }
}
