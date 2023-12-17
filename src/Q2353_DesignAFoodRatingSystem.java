import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Q2353_DesignAFoodRatingSystem {
    public static void main(String[] args) {
        var result = new Q2353_DesignAFoodRatingSystem().new FoodRatings(null, null, null);
    }

    class Food {
        String name;
        int rating;
        String cuisine;

        public Food(String name, int rating, String cuisine) {
            this.name = name;
            this.rating = rating;
            this.cuisine = cuisine;
        }

        public String toString() {
            return "[" + this.name + "=" + this.rating + "]";
        }
    }

    class FoodRatings {

        // Food name to cuisine pq for modify rating
        HashMap<String, Food> foodToCuisineMap = new HashMap<String, Food>();

        // cuisine to food item pq
        HashMap<String, PriorityQueue<Food>> cuisineToRatingMap = new HashMap<String, PriorityQueue<Food>>();

        // Comparator for PQ for sorting Food Objects

        Comparator<Food> foodComparator = (f1, f2) -> {
            if (f1.rating > f2.rating)
                return -1;
            else if (f1.rating < f2.rating)
                return 1;
            else
                return f1.name.compareTo(f2.name);
        };

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                Food item = new Food(foods[i], ratings[i], cuisines[i]);
                foodToCuisineMap.put(item.name, item);
                PriorityQueue<Food> pq = cuisineToRatingMap.getOrDefault(item.cuisine,
                        new PriorityQueue(foodComparator));
                pq.add(item);
                cuisineToRatingMap.put(item.cuisine, pq);
            }
        }

        public void changeRating(String food, int newRating) {
            // Get cusuines name
            Food item = foodToCuisineMap.get(food);
            cuisineToRatingMap.get(item.cuisine).remove(item);
            item.rating = newRating;
            cuisineToRatingMap.get(item.cuisine).add(item);

            // System.out.println("RATING CHANGED f0r " + food +" to " + item.rating);
            // print();
        }

        public String highestRated(String cuisine) {
            // print();
            return cuisineToRatingMap.get(cuisine).peek().name;
        }

        // public void print(){

        // System.out.println("=============");
        // System.out.println("FOOD ITEMS");
        // System.out.println(foodToCuisineMap);

        // System.out.println(" Ratings MAP");
        // System.out.println(cuisineToRatingMap);

        // System.out.println("=============");
        // }
    }

    /**
     * Your FoodRatings object will be instantiated and called as such:
     * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
     * obj.changeRating(food,newRating);
     * String param_2 = obj.highestRated(cuisine);
     */
}
