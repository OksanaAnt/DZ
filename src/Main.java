import animals.AbsAnimal;
import data.AnimalTypeData;
import data.CommandsData;
import factories.AnimalFactory;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<AbsAnimal> animal = new ArrayList<>();

        while (true) {
            System.out.println("Введите команду add/list/exit: ");
            String userCommand = console.next().toUpperCase().trim();
            boolean isExist = false;
            for (CommandsData action : CommandsData.values()) {
                if (action.name().equals(userCommand)) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                System.out.println("Вы ввели команду, отличную от add/list/exit.");
                continue;
            }


            CommandsData commandsData = CommandsData.valueOf(userCommand);


            switch (commandsData) {

                case ADD: {
                    while (true) {
                        System.out.println("Введите животное cat/dog/duck: ");
                        String userAnimal = console.next().toUpperCase().trim();
                        boolean isInclude = false;
                        for (AnimalTypeData typeAnimal : AnimalTypeData.values()) {
                            if (typeAnimal.name().equals(userAnimal)) {
                                isInclude = true;
                                break;
                            }
                        }
                        if (!isInclude) {
                            System.out.println("Вы ввели животное, отличное от cat/dog/duck.");
                            continue;
                        }

                        AnimalTypeData animalTypeData = AnimalTypeData.valueOf(userAnimal);
                        animal.add(fullData(animalTypeData));
                        break;
                    }
                    break;
                }

                case LIST: {
                    System.out.println(animal.toString());
                    break;
                }

                case EXIT: {
                    System.exit(0);
                }
            }
        }
    }

    public static AbsAnimal fullData(AnimalTypeData animalTypeData) {
        AnimalFactory animalFactory = new AnimalFactory();
        AbsAnimal animals = animalFactory.create(animalTypeData);

        System.out.println("Как зовут животное?");
        animals.setName(console.next());

        System.out.println("Какой возраст животного?");
        String ageStr = console.next();
        while (!isNumeric(ageStr)) {
            ageStr = console.next();
        }
        animals.setAge(Integer.parseInt(ageStr));


        System.out.println("Какой вес животного?");
        String weightStr = console.next();
        while (!isNumeric(weightStr)) {
            weightStr = console.next();
        }
        animals.setWeight(Integer.parseInt(weightStr));

        System.out.println("Какой цвет животного?");
        animals.setColor(console.next());
        ((AbsAnimal) animals).say();
        return animals;
    }


    public static boolean isNumeric(String string) {
        while (true) {
            boolean isNumber = false;
            try {
                Integer.parseInt(string);
                Long.parseLong(string);
                isNumber = true;
                return true;
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число");
                System.out.println("Повторите ввод: ");
                return false;
            } catch (Exception e) {
                System.out.println("Произошла непредвиденная ошибка");
                System.out.println("Повторите ввод: ");
                return false;
            }
        }
    }
}


