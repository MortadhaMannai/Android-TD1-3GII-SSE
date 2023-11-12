package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecipeAdapter.OnItemClickListener {

    private List<Recipe> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a list of recipes
        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(new Recipe("Recipe 1", "Description 1"));
        recipeList.add(new Recipe("Recipe 2", "Description 2"));
        // Add more recipes as needed

        // Create RecyclerView and set adapter
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecipeAdapter adapter = new RecipeAdapter(recipeList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(int position) {
        // Handle item click, start RecipeActivity
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra("title", recipeList.get(position).getTitle());
        intent.putExtra("description", recipeList.get(position).getDescription());
        startActivity(intent);
    }
}
