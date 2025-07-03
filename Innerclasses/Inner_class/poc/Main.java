package poc;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Recipe> recipes = Arrays.asList(
                new Recipe("Pancakes"), new Recipe("Omelette"), new Recipe("Salad")
        );

        recipes.get(0).addIngredient("flour", 200);
        recipes.get(0).addIngredient("eggs", 2);
          recipes.get(1).addIngredient("eggs", 3);
         recipes.get(1).addIngredient("milk", 50);
        recipes.get(2).addIngredient(" baking soda", 100);
         recipes.get(2).addIngredient("tomato", 80);


        Recipe.Sorter.sortByName(recipes);
        recipes.forEach(Recipe.Sorter::sortIngredients);

        recipes.forEach(r ->
                r.onPrint(new Recipe.Action() {
                    @Override
                    public void perform() {
                        System.out.println("Recipe: " + r.title);
                        r.showIngredients();
                        System.out.println();
                    }
                  })
            );

        Recipe r = recipes.get(0);
        System.out.println("Before edit: " + r.title);
        r.editTitle(" Title");
        System.out.println("undo: " + r.title);
    }
}
