package poc;

import java.util.*;

public class Recipe {
    String title;
    List<Ingredient> ingredients = new ArrayList<>();

    public Recipe(String title) {
        this.title = title;
    }


    public class Ingredient {
        String name;
        double quantity;
        public Ingredient(String name, double quantity) {
            this.name = name;
            this.quantity = quantity;
        }
        public void display() {
            System.out.printf("[%s] %.2f × %s%n", Recipe.this.title, quantity, name);
        }
    }

    public void addIngredient(String name, double quantity) {
        ingredients.add(new Ingredient(name, quantity));
    }

    public void showIngredients() {
        ingredients.forEach(Ingredient::display);
    }


    public static class Sorter {
        public static void sortByName(List<Recipe> recipes) {
            recipes.sort(Comparator.comparing(r -> r.title));
        }
        public static void sortIngredients(Recipe r) {
            r.ingredients.sort(Comparator.comparing(i -> i.name));
        }
    }

    public void editTitle(String newTitle) {
        final String old = title;
        class EditTracker {
            void undo() { title = old; }
        }
        title = newTitle;
        new EditTracker().undo(); // undo immediately
    }


    public interface Action { void perform(); }
    public void onPrint(Action act) { act.perform(); }
}
