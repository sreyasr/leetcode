import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomArrayGenerator {

    private final int limit;
    private final int size;
    private final int upperCap = 10000;
    private final int lowerCap = -10000;
    private final Random r = new Random();

    RandomArrayGenerator(int limit, int size) {
        this.limit = limit;
        this.size = size;
    }
    public List<String> generate() {
        List<String> ret = new ArrayList<>();
        IntStream.range(0, this.size).forEach( ignored -> {
        List<Integer> list = new ArrayList<>();
        r.ints(lowerCap, upperCap).limit(this.limit).forEach(list::add);
        List<String> stringList = list.stream().map(Object::toString).collect(Collectors.toList());
        ret.add(String.join(",", stringList));
    });
    return ret;
    }


    public static void main(String[] args) {
        List<String> x = new RandomArrayGenerator(20, 20).generate();
        x.forEach(s -> System.out.printf("[%s]\n", s));
    }
}
