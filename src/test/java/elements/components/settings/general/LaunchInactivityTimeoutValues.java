package elements.components.settings.general;

import lombok.Getter;

import java.util.List;
import java.util.Random;

@Getter
public enum LaunchInactivityTimeoutValues {
    ONE_HOUR("1 hour"),
    THREE_HOURS("3 hours"),
    SIX_HOURS("6 hours"),
    TWELVE_HOURS("12 hours"),
    ONE_DAY("1 day"),
    SEVEN_DAYS("7 days");

    private static final List<LaunchInactivityTimeoutValues> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    private final String title;

    LaunchInactivityTimeoutValues(String title) {
        this.title = title;
    }

    public static LaunchInactivityTimeoutValues getByTitle(String title) {
        return VALUES.stream()
                .filter(it -> it.title.equals(title))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unable to get LaunchInactivityTimeout value by title %s".formatted(title)));
    }

    public static LaunchInactivityTimeoutValues getAnyOtherThan(LaunchInactivityTimeoutValues exclusion) {
        LaunchInactivityTimeoutValues randomValue = VALUES.get(RANDOM.nextInt(SIZE));
        if (randomValue == exclusion) {
            return getAnyOtherThan(exclusion);
        }
        return randomValue;
    }
}
