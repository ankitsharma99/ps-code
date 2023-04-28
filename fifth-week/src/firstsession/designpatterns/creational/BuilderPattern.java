package firstsession.designpatterns.creational;

class Meal {
    private String drink;
    private String mainCourse;
    private String side;

    public Meal(String drink, String mainCourse, String side) {
        this.drink = drink;
        this.mainCourse = mainCourse;
        this.side = side;
    }

    public static class MealBuilder {
        private String drink;
        private String mainCourse;
        private String side;

        public MealBuilder() {}

        public MealBuilder drink(String drink) {
            this.drink = drink;
            return this;
        }

        public MealBuilder mainCourse(String mainCourse) {
            this.mainCourse = mainCourse;
            return this;
        }

        public MealBuilder side(String side) {
            this.side = side;
            return this;
        }

        public Meal build() {
            return new Meal(drink, mainCourse, side);
        }
    }
}
public class BuilderPattern {
    public static void main(String[] args) {
        Meal meal = new Meal.MealBuilder()
                .drink("Coke")
                .mainCourse("Pizza")
                .side("Fries")
                .build();
    }
}
