import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class FitCheck {
    private int age;
    private String gender;
    private double weight;
    private double height;
    private Map<Integer, Map<String, Map<String, double[]>>> idealData;

    public FitCheck() {
        // Initialize ideal weight and height ranges for different age groups and genders
        idealData = new HashMap<>();
        idealData.put(15, Map.of(
            "male", Map.of("weight", new double[]{45, 55}, "height", new double[]{162, 168}),
            "female", Map.of("weight", new double[]{45, 52}, "height", new double[]{158, 163})
        ));
        idealData.put(16, Map.of(
            "male", Map.of("weight", new double[]{47, 60}, "height", new double[]{165, 173}),
            "female", Map.of("weight", new double[]{46, 53}, "height", new double[]{159, 164})
        ));
        idealData.put(17, Map.of(
            "male", Map.of("weight", new double[]{48, 62}, "height", new double[]{168, 175}),
            "female", Map.of("weight", new double[]{48, 56}, "height", new double[]{160, 165})
        ));
        idealData.put(18, Map.of(
            "male", Map.of("weight", new double[]{50, 65}, "height", new double[]{170, 175}),
            "female", Map.of("weight", new double[]{50, 60}, "height", new double[]{161, 166})
        ));
        idealData.put(19, Map.of(
            "male", Map.of("weight", new double[]{53, 68}, "height", new double[]{171, 180}),
            "female", Map.of("weight", new double[]{53, 65}, "height", new double[]{162, 167})
        ));
        idealData.put(20, Map.of(
            "male", Map.of("weight", new double[]{56, 73}, "height", new double[]{160, 180}),
            "female", Map.of("weight", new double[]{55, 69}, "height", new double[]{160, 175})
        ));
        idealData.put(21, Map.of(
            "male", Map.of("weight", new double[]{50, 65}, "height", new double[]{170, 185}),
            "female", Map.of("weight", new double[]{50, 62}, "height", new double[]{158, 172})
        ));
        idealData.put(26, Map.of(
            "male", Map.of("weight", new double[]{53, 70}, "height", new double[]{168, 183}),
            "female", Map.of("weight", new double[]{53, 67}, "height", new double[]{157, 171})
        ));
        idealData.put(31, Map.of(
            "male", Map.of("weight", new double[]{59, 73}, "height", new double[]{166, 181}),
            "female", Map.of("weight", new double[]{59, 70}, "height", new double[]{156, 170})
        ));
        idealData.put(36, Map.of(
            "male", Map.of("weight", new double[]{61, 76}, "height", new double[]{165, 180}),
            "female", Map.of("weight", new double[]{60, 74}, "height", new double[]{155, 169})
        ));
        idealData.put(41, Map.of(
            "male", Map.of("weight", new double[]{62, 77}, "height", new double[]{163, 178}),
            "female", Map.of("weight", new double[]{60, 76}, "height", new double[]{153, 167})
        ));
        idealData.put(46, Map.of(
            "male", Map.of("weight", new double[]{63, 80}, "height", new double[]{160, 175}),
            "female", Map.of("weight", new double[]{62, 78}, "height", new double[]{150, 165})
        ));
    }

    public void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        age = scanner.nextInt();
        System.out.print("Enter your gender (male/female): ");
        gender = scanner.next().toLowerCase();
        System.out.print("Enter your current weight (kg): ");
        weight = scanner.nextDouble();
        System.out.print("Enter your current height (cm): ");
        height = scanner.nextDouble();
        System.out.println("\nHealth Analysis:");
    }

    private String getAgeGroup() {
        if (age >= 21 && age <= 25) return "21-25";
        else if (age >= 26 && age <= 30) return "26-30";
        else if (age >= 31 && age <= 35) return "31-35";
        else if (age >= 36 && age <= 40) return "36-40";
        else if (age >= 41 && age <= 45) return "41-45";
        else if (age >= 46 && age <= 50) return "46-50";
        else return null;
    }

    public double[] analyzeData() {
        String ageGroup = getAgeGroup();
        if (idealData.containsKey(age) && idealData.get(age).containsKey(gender)) {
            double[] idealWeightRange = idealData.get(age).get(gender).get("weight");
            double[] idealHeightRange = idealData.get(age).get(gender).get("height");

            double weightDiff = 0;
            double heightDiff = 0;

            if (weight < idealWeightRange[0]) {
                weightDiff = weight - idealWeightRange[0];
                System.out.printf("Weight difference: %.2f kg\n", weightDiff);
                System.out.println("You are underweight.\n");
            } else if (weight > idealWeightRange[1]) {
                weightDiff = weight - idealWeightRange[1];
                System.out.printf("Weight difference: %.2f kg\n", weightDiff);
                System.out.println("You are overweight.\n");
            }

            if (height < idealHeightRange[0]) {
                heightDiff = height - idealHeightRange[0];
                System.out.printf("Height difference: %.2f cm\n", heightDiff);
                System.out.println("Your height is short as per our data.\n");
            } else if (height > idealHeightRange[1]) {
                heightDiff = height - idealHeightRange[1];
                System.out.printf("Height difference: %.2f cm\n", heightDiff);
                System.out.println("Your height is perfect.\n");
            }

            return new double[]{weightDiff, heightDiff};
        } else if (ageGroup != null && idealData.containsKey(Integer.parseInt(ageGroup.split("-")[0])) && idealData.get(Integer.parseInt(ageGroup.split("-")[0])).containsKey(gender)) {
            double[] idealWeightRange = idealData.get(Integer.parseInt(ageGroup.split("-")[0])).get(gender).get("weight");
            double[] idealHeightRange = idealData.get(Integer.parseInt(ageGroup.split("-")[0])).get(gender).get("height");

            double weightDiff = 0;
            double heightDiff = 0;

            if (weight < idealWeightRange[0]) {
                weightDiff = weight - idealWeightRange[0];
                System.out.printf("Weight difference: %.2f kg\n", weightDiff);
                System.out.println("You are underweight.\n");
            } else if (weight > idealWeightRange[1]) {
                weightDiff = weight - idealWeightRange[1];
                System.out.printf("Weight difference: %.2f kg\n", weightDiff);
                System.out.println("You are overweight.\n");
            }

            if (height < idealHeightRange[0]) {
                heightDiff = height - idealHeightRange[0];
                System.out.printf("Height difference: %.2f cm\n", heightDiff);
                System.out.println("Your height is short as per our data.\n");
            } else if (height > idealHeightRange[1]) {
                heightDiff = height - idealHeightRange[1];
                System.out.printf("Height difference: %.2f cm\n", heightDiff);
                System.out.println("Your height is perfect.\n");
            }

            return new double[]{weightDiff, heightDiff};
        } else {
            return null;
        }
    }

    public void displayRecommendations(double weightDiff, double heightDiff) {
        if (weightDiff < 0) {
            if (gender.equals("male")) {
                if (age >= 15 && age <= 25) {
                    System.out.println("So here's a planned routine for your FitCheck from today!!!");
                    System.out.println("#StayHealthy\n");
                    System.out.println("Diet for weight gain.");
                    System.out.println("Breakfast (8:00-8:30AM) : 2 egg brown bread sandwich + green chutney + 1 cup milk + 3 cashews + 4 almonds + 2 walnuts.");
                    System.out.println("Mid-Meal (11:00-11:30AM): 1 cup banana shake.");
                    System.out.println("Lunch (2:00-2:30PM) : 1 cup arhar dal + 1 cup potato curry + 3 chapatti + 1/2 cup rice + 1/2 cup low fat curd + salad.");
                    System.out.println("Evening (4:00-4:30PM) : 1 cup strawberry smoothie + 1 cup vegetable poha.");
                    System.out.println("Dinner (8:00-8:30PM) : 1.5 cup chicken curry + 3 chapati + salad.");
                } else if (age >= 26 && age <= 35) {
                    System.out.println("So here's a planned routine for your FitCheck from today!!!");
                    System.out.println("#StayHealthy\n");
                    System.out.println("Diet for weight gain.");
                    System.out.println("Breakfast (8:00-8:30AM) : 3 onion stuffed paratha + 1 cup curd + 3 cashews + 4 almonds + 2 walnuts");
                    System.out.println("Mid-Meal (11:00-11:30AM) : 1 cup mango shake.");
                    System.out.println("Lunch (2:00-2:30PM) : 1 cup moong dal/ chicken curry + 1 cup potato and cauliflower vegetable + 3 chapatti + 1/2 cup rice + salad.");
                    System.out.println("Evening (4:00-4:30PM) : 1 cup pomegranate juice + 2 butter toasted bread.");
                    System.out.println("Dinner (8:00-8:30PM)	1 cup beans potato vegetable + 3 chapatti + salad.");
                } else if (age >= 36 && age <= 50) {
                    System.out.println("So here's a planned routine for your FitCheck from today!!!");
                    System.out.println("#StayHealthy\n");
                    System.out.println("Diet for weight gain.");
                    System.out.println("Breakfast (8:00-8:30AM) : 2 cup vegetable poha + 1 cup curd + 3 cashews + 4 almonds + 2 walnuts.");
                    System.out.println("Mid-Meal (11:00-11:30AM) : 2 cups watermelon juice.");
                    System.out.println("Lunch (2:00-2:30PM) : 1 cup chana dal + 1 cup bhindi vegetable + 3 chapatti + 1/2 cup rice + salad.");
                    System.out.println("Evening (4:00-4:30PM) : 1 cup sprouts salad + 2 potato cheela + green chutney.");
                    System.out.println("Dinner (8:00-8:30PM)	1 cup peas mushroom vegetable + 3 chapatti + salad.");
                }
            } else if (gender.equals("female")) {
                if (age >= 15 && age <= 25) {
                    System.out.println("So here's a planned routine for your FitCheck from today!!!");
                    System.out.println("#StayHealthy\n");
                    System.out.println("Diet for weight gain");
                    System.out.println("Breakfast (8:00-8:30AM) : 1 serving Raspberry-Peach-Mango Smoothie Bowl + 1 hard-boiled egg.");
                    System.out.println("Mid-Meal (11:00-11:30AM) : 15 baby carrots + 3 Tbsp. hummus + 1 medium orange.");
                    System.out.println("Lunch (2:00-2:30PM) : 1 serving Roasted Butternut Squash & Root Vegetables with Cauliflower Gnocchi + 1 slice whole-wheat toast with 1 tsp. unsalted butter.");
                    System.out.println("Evening (4:00-4:30PM) : 1 serving Homemade Microwave Popcorn + 1 large banana + 8 unsalted almonds.");
                    System.out.println("Dinner (8:00-8:30PM) : 2 servings Philly Cheese Steak Sloppy Joes + 2 cups fresh spinach, 1 cup shredded carrots topped with 1/2 Tbsp. olive oil and 1/2 Tbsp. balsamic vinegar.");
                } else if (age >= 26 && age <= 35) {
                    System.out.println("So here's a planned routine for your FitCheck from today!!!");
                    System.out.println("#StayHealthy\n");
                    System.out.println("Diet for weight gain");
                    System.out.println("Breakfast (8:00-8:30AM) : 1 serving Raspberry-Peach-Mango Smoothie Bowl + 1 hard-boiled egg.");
                    System.out.println("Mid-Meal (11:00-11:30AM) : 15 baby carrots + 3 Tbsp. hummus + 1 medium orange.");
                    System.out.println("Lunch (2:00-2:30PM) : 1 serving Roasted Butternut Squash & Root Vegetables with Cauliflower Gnocchi + 1 slice whole-wheat toast with 1 tsp. unsalted butter.");
                    System.out.println("Evening (4:00-4:30PM) : 1 serving Homemade Microwave Popcorn + 1 large banana + 8 unsalted almonds.");
                    System.out.println("Dinner (8:00-8:30PM) : 2 servings Philly Cheese Steak Sloppy Joes + 2 cups fresh spinach, 1 cup shredded carrots topped with 1/2 Tbsp. olive oil and 1/2 Tbsp. balsamic vinegar.");
                } else if (age >= 36 && age <= 50) {
                    System.out.println("So here's a planned routine for your FitCheck from today!!!");
                    System.out.println("#StayHealthy\n");
                    System.out.println("Diet for weight gain");
                    System.out.println("Breakfast (8:00-8:30AM) : 2 servings Maple-Nut Granola + 1 cup 2% milk.");
                    System.out.println("Mid-Meal (11:00-11:30AM) : 15 carrot sticks + 1/4 cup hummus + 1 medium orange.");
                    System.out.println("Lunch (2:00-2:30PM) : 1 serving Roasted Butternut Squash & Root Vegetables with Cauliflower Gnocchi + 1 slice whole-wheat toast with 1 tsp. unsalted butter.");
                    System.out.println("Evening (4:00-4:30PM) : 4 graham crackers + 1 medium apple.");
                    System.out.println("Dinner (8:00-8:30PM) : 1 serving Southern-Style Oven-Fried Chicken + 1 serving Greek Potato Salad + 1 serving Garlicky Green Beans.");
                }
            }
        } else if (weightDiff > 0) {
            if (gender.equals("male")) {
                if (age >= 15 && age <= 25) {
                    System.out.println("So here's a planned routine for your FitCheck from today!!!");
                    System.out.println("#StayHealthy\n");
                    System.out.println("Diet for weight loss");
                    System.out.println("Breakfast (8:00-8:30AM) : green smoothie (made with ½ banana + ½ cup frozen mango + 1 cup kale + ½ cup plain, low-fat Greek yogurt + ½ small avocado + ½ cup nonfat milk).");
                    System.out.println("Mid-Meal (11:00-11:30AM) : 1 apple + 1 oz nuts.");
                    System.out.println("Lunch (2:00-2:30PM) : 2 cups Veggie Soup.");
                    System.out.println("Evening (4:00-4:30PM) : 1 cup baby carrots & sugar snap peas + 2 tablespoons hummus.");
                    System.out.println("Dinner (8:00-8:30PM) : 4 oz salmon + 1 cup steamed carrots + 1 cup steamed broccoli + 2 tablespoons teriyaki sauce + 1 teaspoon sesame seeds.");
                } else if (age >= 26 && age <= 35) {
                    System.out.println("So here's a planned routine for your FitCheck from today!!!");
                    System.out.println("#StayHealthy\n");
                    System.out.println("Diet for weight loss");
                    System.out.println("Breakfast (8:00-8:30AM) : berry smoothie (made with ½ banana + 1 cup frozen strawberries + ½ cup plain, low-fat Greek yogurt + ½ cup nonfat milk).");
                    System.out.println("Mid-Meal (11:00-11:30AM) : 1 banana + 1 oz nuts.");
                    System.out.println("Lunch (2:00-2:30PM) : 2 cups Veggie Soup.");
                    System.out.println("Evening (4:00-4:30PM) : 1 cup broccoli & cauliflower + 2 tablespoons tzatziki.");
                    System.out.println("Dinner (8:00-8:30PM) : 4 oz grilled chicken + ½ cup roasted sweet potatoes + 1 cup roasted Brussels sprouts + 1 tablespoon olive oil.");
                } else if (age >= 36 && age <= 50) {
                    System.out.println("So here's a planned routine for your FitCheck from today!!!");
                    System.out.println("#StayHealthy\n");
                    System.out.println("Diet for weight loss");
                    System.out.println("Breakfast (8:00-8:30AM) : green smoothie (made with ½ banana + ½ cup frozen mango + 
