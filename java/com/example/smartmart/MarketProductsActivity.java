package com.example.smartmart;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.smartmart.adapters.MarketProductsAdapter;
import java.util.ArrayList;
import java.util.List;

public class MarketProductsActivity extends AppCompatActivity {

    private RecyclerView recMarketProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_products);

        recMarketProducts = findViewById(R.id.recMarketProducts);
        recMarketProducts.setLayoutManager(new GridLayoutManager(this, 3));
        /* add the product images */
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.cucumber);
        imageList.add(R.drawable.lettuce);
        imageList.add(R.drawable.tomato);
        imageList.add(R.drawable.marslogoo);
        imageList.add(R.drawable.galaxy);
        imageList.add(R.drawable.kinder);
        imageList.add(R.drawable.lays);
        imageList.add(R.drawable.tasali);
        imageList.add(R.drawable.pom);
        imageList.add(R.drawable.potato);
        imageList.add(R.drawable.eggplant);
        imageList.add(R.drawable.milka);
        imageList.add(R.drawable.kiwis);
        imageList.add(R.drawable.banana);
        imageList.add(R.drawable.varmilk);
        imageList.add(R.drawable.chocomilk);
        imageList.add(R.drawable.bubbly);
        /* add the product names */
        List<String> nameList = new ArrayList<>();
        nameList.add("Cucumber");
        nameList.add("Lettuce");
        nameList.add("Tomato");
        nameList.add("Mars");
        nameList.add("Galaxy");
        nameList.add("Kinder");
        nameList.add("Lays");
        nameList.add("Tasali");
        nameList.add("Pomegrante");
        nameList.add("Potato");
        nameList.add("Eggplant");
        nameList.add("Milka chocolate");
        nameList.add("Kiwi");
        nameList.add("Banana");
        nameList.add("Variety milk");
        nameList.add("Chocolate milk");
        nameList.add("Bubbly chocolate");

        List<String> descriptionList = new ArrayList<>();
// Add corresponding descriptions for each product
        descriptionList.add("Healthy Egyptian cucumbers from local farms.");
        descriptionList.add("Healthy Egyptian lettuce from local farms.");
        descriptionList.add("Healthy Egyptian tomatoes from local farms.");
        descriptionList.add("Delicious Mars chocolate.");
        descriptionList.add("Delicious Galaxy chocolate.");
        descriptionList.add("Kinder, a popular brand of chocolate.");
        descriptionList.add("Lays, a popular brand of potato chips.");
        descriptionList.add("Tasali, offering a variety of food products.");
        descriptionList.add("Pomegranate, a nutritious and refreshing fruit.");
        descriptionList.add("Potato, a versatile vegetable used in various culinary dishes.");
        descriptionList.add("Eggplant, a meaty-textured vegetable used in Mediterranean and Asian cuisines.");
        descriptionList.add("Milka chocolate, a smooth and creamy chocolate brand.");
        descriptionList.add("Kiwi, a tangy and sweet fruit packed with vitamin C.");
        descriptionList.add("Banana, a popular fruit known for its natural sweetness and potassium content.");
        descriptionList.add("Variety milk, offering a range of flavored dairy products.");
        descriptionList.add("Chocolate milk, a delicious dairy beverage with added chocolate flavor.");
        descriptionList.add("Bubbly chocolate, a type of chocolate with a light and aerated texture.");


        recMarketProducts.setAdapter(new MarketProductsAdapter(this, imageList, nameList, descriptionList));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_contact: {
                Intent intent = new Intent(this, ContactUs.class);
                startActivity(intent);

                return true;
            }
            case R.id.menu_settings: {

                return true;
            }

            default:
                return false;
        }
    }
}

