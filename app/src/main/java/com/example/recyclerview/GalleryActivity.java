package com.example.recyclerview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        this.getIncommingIntent();
    }

    private void getIncommingIntent(){
        if(getIntent().hasExtra("recipeTitle") &&
            getIntent().hasExtra("recipeText") )
        {
            String recipeTitle = getIntent().getStringExtra("recipeTitle");
            String recipeText = getIntent().getStringExtra("recipeText");

            this.setImage(recipeTitle, recipeText);
        }
    }

    private void setImage(String recipeTitle, String recipeText)
    {
        ImageView recipeImage = findViewById(R.id.recipeImage);
        TextView recipeIngredients = findViewById(R.id.recipeIngredients);
        recipeIngredients.setText("Ingredients:\n" + recipeText);
        switch (recipeTitle)
        {
            case "Yummy Yam":
                recipeImage.setImageResource(R.drawable.yummy_yam);
                break;
            case "Strong Spinach":
                recipeImage.setImageResource(R.drawable.strong_spinach);
                break;
            case "Pretty Pear":
                recipeImage.setImageResource(R.drawable.pretty_pear);
                break;
            case "Appetizing Apple":
                recipeImage.setImageResource(R.drawable.apetizing_apple);
                break;
            case "Carefree Cake":
                recipeImage.setImageResource(R.drawable.carefree_cake);
                break;
            case "Beautiful Beets":
                recipeImage.setImageResource(R.drawable.beautiful_beets);
                break;
            case "Shy Sprouts":
                recipeImage.setImageResource(R.drawable.shy_sprouts);
                break;
            case "Powerful Pickels":
                recipeImage.setImageResource(R.drawable.powerful_pickle);
                break;
        };
    }
}
