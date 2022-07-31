package helpers;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class RandomUtil {
    public final Random RANDOM = new Random();

    public int getRandomIntUpTo(int size) {
        return RANDOM.nextInt(size);
    }
}
