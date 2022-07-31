package elements.components.settings.general;

import helpers.RandomUtil;
import lombok.Getter;

import java.util.List;

@Getter
public enum LaunchInactivityTimeoutValue {
    ONE_HOUR("1 hour"),
    THREE_HOURS("3 hours"),
    SIX_HOURS("6 hours"),
    TWELVE_HOURS("12 hours"),
    ONE_DAY("1 day"),
    SEVEN_DAYS("7 days");

    private static final List<LaunchInactivityTimeoutValue> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private final String title;

    LaunchInactivityTimeoutValue(String title) {
        this.title = title;
    }

    public static LaunchInactivityTimeoutValue getByTitle(String title) {
        return VALUES.stream()
                .filter(it -> it.title.equals(title))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unable to get LaunchInactivityTimeout value by title %s".formatted(title)));
    }

    public static LaunchInactivityTimeoutValue getAnyOtherThan(LaunchInactivityTimeoutValue exclusion) {
        LaunchInactivityTimeoutValue randomValue = VALUES.get(RandomUtil.getRandomIntUpTo(SIZE));
        if (randomValue == exclusion) {
            return getAnyOtherThan(exclusion);
        }
        return randomValue;
    }
}
