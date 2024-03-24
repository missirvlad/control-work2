import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyShop {

    private PriorityQueue<Toy> toys;

    public ToyShop() {
        toys = new PriorityQueue<>();
    }

    public void addNewToy(int id, String name, int weight) {
        toys.add(new Toy(id, name, weight));
    }

    public void getToys(int times) {
        try (FileWriter writer = new FileWriter("output.txt")) {
            for (int i = 0; i < times; i++) {
                int randomNumber = (int) (Math.random() * 100);
                Toy selectedToy = null;
                if (randomNumber < 20) {
                    for (Toy toy : toys) {
                        if (toy.getId() == 1) {
                            selectedToy = toy;
                            break;
                        }
                    }
                } else if (randomNumber < 40) {
                    for (Toy toy : toys) {
                        if (toy.getId() == 2) {
                            selectedToy = toy;
                            break;
                        }
                    }
                } else {
                    for (Toy toy : toys) {
                        if (toy.getId() == 3) {
                            selectedToy = toy;
                            break;
                        }
                    }
                }
                if (selectedToy != null) {
                    writer.write(selectedToy.getName() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
