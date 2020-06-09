package sg.edu.rp.c346.id_18021531.demomycolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
 EditText etElement;
 Button btnAdd;
 ListView lvColour;
    EditText etIndex;


    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etElement = findViewById(R.id.editTextColour);
        btnAdd =  findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndex = findViewById(R.id.editTextIndex);

        alColours = new ArrayList<>();
        alColours.add("red");
        alColours.add("orange");
        aaColour = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newColour = etElement.getText().toString();

                int pos = Integer.parseInt(etIndex.getText().toString());
                alColours.add(pos,newColour);
                aaColour.notifyDataSetChanged();

            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String Colour = alColours.get(position);
                Toast.makeText(MainActivity.this,Colour,Toast.LENGTH_SHORT).show();

            }
        });

    }
}
