    package com.example.exercicecourjava;

    import androidx.appcompat.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.ArrayAdapter;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ListView;
    import java.util.ArrayList;
    import java.util.List;

    public class MainActivity extends AppCompatActivity {

        ListView lv;
        List<String> countries = new ArrayList<String>();
        MyAdapter adapter;
        EditText editText;
        Button addButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            lv = findViewById(R.id.CountriesList);
            editText = findViewById(R.id.editText);
            addButton = findViewById(R.id.addButton);

            countries.add("US");
            countries.add("UK");
            countries.add("Morocco");
            countries.add("Tunisia");
            countries.add("Lebanon");
            countries.add("Palestine");

            adapter = new MyAdapter(this, countries);
            lv.setAdapter(adapter);

            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String newCountry = editText.getText().toString();
                    if (!newCountry.isEmpty()) {
                        countries.add(newCountry);
                        adapter.notifyDataSetChanged();
                        editText.setText("");
                    }
                }
            });
        }
    }
