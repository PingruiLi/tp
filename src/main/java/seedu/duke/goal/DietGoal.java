package seedu.duke.goal;

import seedu.duke.record.RecordType;

import java.time.LocalDate;


public class DietGoal extends Goal {

    /**
     * Initialize an instance of an diet goal.
     *
     * @param periodType   the period type of the goal which can be daily or weekly.
     * @param targetEnergy the target energy to be consumed.
     */
    public DietGoal(PeriodType periodType, double targetEnergy) throws NumberFormatException {
        super(RecordType.DIET, periodType, targetEnergy);
        if (targetEnergy < 0 || targetEnergy > 10000) {
            throw new NumberFormatException("Target calorie invalid");
        }
        initializeProgress();
        lengthOfTarget = getLengthOfTarget();
        setSeparator();
    }

    /**
     * Initialize an instance of an diet goal.
     *
     * @param periodType   the period type of the goal which can be daily or weekly.
     * @param targetEnergy the target energy to be consumed.
     * @param daySet       the date when the goal is set.
     */
    public DietGoal(PeriodType periodType, double targetEnergy, LocalDate daySet) {
        super(RecordType.DIET, periodType, targetEnergy, daySet);
        initializeProgress();
        lengthOfTarget = getLengthOfTarget();
        setSeparator();
    }

    @Override
    public String getProgressUnit() {
        return "Kcal";
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
        return "D" + SEPARATOR + getDaySet().format(DATE_FORMATTER) + SEPARATOR + periodType + SEPARATOR + target;
    }

    private int getLengthOfTarget() {
        return ("" + target).length() + getProgressUnit().length() + 1;
    }
}