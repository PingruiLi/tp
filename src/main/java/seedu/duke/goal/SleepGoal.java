package seedu.duke.goal;

import seedu.duke.record.RecordType;

import java.security.SecurityPermission;
import java.time.LocalDate;

public class SleepGoal extends Goal {

    /**
     * Initialize an instance of an exercise goal.
     *
     * @param periodType     the period type of the goal which can be daily or weekly.
     * @param targetDuration the target sleeping duration.
     */
    public SleepGoal(PeriodType periodType, double targetDuration) throws NumberFormatException {
        super(RecordType.SLEEP, periodType, targetDuration);
        if (targetDuration < 0 || targetDuration > 24) {
            throw new NumberFormatException("Target duration invalid");
        }
        initializeProgress();
        lengthOfTarget = getLengthOfTarget();
        setSeparator();
    }

    /**
     * Initialize an instance of an exercise goal.
     *
     * @param periodType     the period type of the goal which can be daily or weekly.
     * @param targetDuration the target sleeping duration.
     * @param daySet         the date when the goal is set.
     */
    public SleepGoal(PeriodType periodType, double targetDuration, LocalDate daySet) {
        super(RecordType.SLEEP, periodType, targetDuration, daySet);
        initializeProgress();
        lengthOfTarget = getLengthOfTarget();
        setSeparator();
    }

    @Override
    public String getProgressUnit() {
        return "hour(s)";
    }

    @Override
    public String getGoalSummary() {
        return "Date Set: " + getDaySet().format(DATE_FORMATTER) + "\n"
                + "Goal Type: " + getPeriodType().toString() + " " + getType().toString().toLowerCase() + "\n"
                + "Target: " + getTarget() + " " + getProgressUnit() + "\n"
                + "Progress: " + getProgress() + " " + getProgressUnit();
    }

    @Override
    public String getGoalData() {
        return SEPATATOR_TAB + SEPATATOR_TAB + getDaySet().format(DATE_FORMATTER) + SEPATATOR_TAB + SEPATATOR_TAB
                + getPeriodType().toString().toLowerCase() + separatorBetweenTypeAndTarget
                + getTarget() + " " + getProgressUnit() + separatorBetweenTargetAndProgress
                + getProgress() + " " + getProgressUnit() + getAchieved() + "\n";
    }

    @Override
    public String getGoalDataToStore() {
        return "S" + SEPARATOR + getDaySet().format(DATE_FORMATTER) + SEPARATOR + periodType + SEPARATOR + target;
    }

    private int getLengthOfTarget() {
        return ("" + target).length() + getProgressUnit().length() + 1;
    }
}
