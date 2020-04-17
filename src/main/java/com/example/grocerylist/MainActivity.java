package com.example.grocerylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.view.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> shoppingList = null;
    ArrayAdapter<String> adapter = null;
    ListView lv = null;

    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt=(Button)findViewById(R.id.share_button2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "\"Rice          ₦500\", \"Beans           ₦600\",\n" +
                        "                \"Potato         ₦200\", \"Milk            ₦330\", \"Fruits          ₦900\", \"Bread           ₦300\", \"Eggs            ₦800\", \"Towel            ₦200\", \"Chicken curry           ₦500\", \"Apples          ₦100\",  \"Sunscreen         ₦200\", \"Toothpaste            ₦300\", \"Smoked Fish           ₦450\"";
                String shareSub = "Grocery List of Customer Aliyu";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share Using"));

            }
        });

        shoppingList = new ArrayList<>();
        Collections.addAll(shoppingList, "Rice          ₦500", "Beans           ₦600",
                "Potato         ₦200", "Milk            ₦330", "Fruits          ₦900", "Bread           ₦300", "Eggs            ₦800");
        shoppingList.addAll(Arrays.asList("Towel            ₦200", "Chicken curry           ₦500", "Apples          ₦100"));
        shoppingList.add("Sunscreen         ₦200");
        shoppingList.add("Toothpaste            ₦300");
        shoppingList.add("Smoked Fish           ₦450");
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, shoppingList);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
    }
    public void Ganesh(View View)
    {
        String button_text;
        button_text =((Button)View).getText().toString();
        if(button_text.equals("Proceed to checkout"))
        {
            Intent ganesh = new Intent(this,SecondActivity.class);
            startActivity(ganesh);
        }
        else if (button_text.equals("Share List"))
        {
            Intent mass = new Intent(this,ThirdActivity.class);
            startActivity(mass);

        }
    }


}
