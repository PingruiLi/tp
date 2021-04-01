package seedu.duke.goal;

import seedu.duke.record.RecordType;

import java.time.LocalDate;

import static seedu.duke.common.Messages.MESSAGE_NO_BODY_WEIGHT_PROGRESS;

public class BodyWeightGoal extends Goal {

    /**
     * Initialize an instance of an exercise goal.
     *
     * @param periodType       the period type of the goal which can be daily or weekly.
     * @param targetBodyWeight the target body weight.
     */
    public BodyWeightGoal(PeriodType periodType, double targetBodyWeight) throws NumberFormatException {
        super(RecordType.BODYWEIGHT, periodType, targetBodyWeight);
        if (targetBodyWeight < 0 || targetBodyWeight > 400) {
            throw new NumberFormatException("Target weight invalid");
        }
        initializeProgress();
        lengthOfTarget = getLengthOfTarget();
        setSeparator();
    }

    /**
     * Initialize an instance of an exercise goal.
     *
     * @param periodType       the period type of the goal which can be daily or weekly.
     * @param targetBodyWeight the target body weight.
     * @param daySet           the date when the goal is set.
     */
    public BodyWeightGoal(PeriodType periodType, double targetBodyWeight, LocalDate daySet) {
        super(RecordType.BODYWEIGHT, periodType, targetBodyWeight, daySet);
        initializeProgress();
        lengthOfTarget = getLengthOfTarget();
        setSeparator();
    }

    @Override
    public void initializeProgress() {
        progress = -1;
    }

    @Override
    public boolean isAchieved() {
        return progress == target;
    }

    @Override
    public String getProgressUnit() {
        return "Kg";
    }

    @Override
    public String getGoalSummary() {
        if (progress == -1) {
            return "Date Set: " + getDaySet().format(DATE_FORMATTER) + "\n"
                    + "Goal Type: " + getPeriodType().toString() + " " + getType().toString().toLowerCase() + "\n"
                    + "Target: " + getTarget() + " " + getProgressUnit() + "\n"
                    + "Progress: " + MESSAGE_NO_BODY_WEIGHT_PROGRESS;
        } else {
            return "Date Set: " + getDaySet().format(DATE_FORMATTER) + "\n"
                    + "Goal Type: " + getPeriodType().toString() + " " + getType().toString().toLowerCase() + "\n"
                    + "Target: " + getTarget() + " " + getProgressUnit() + "\n"
                    + "Progress: " + getProgress() + getProgressUnit();
        }
    }

    @Override
    public String getGoalData() {
        if (progress == -1) {
            return SEPATATOR_TAB + SEPATATOR_TAB + getDaySet().format(DATE_FORMATTER) + SEPATATOR_TAB + SEPATATOR_TAB
                    + getPeriodType().toString().toLowerCase() + getAchieved() + separatorBetweenTypeAndTarget
                    + getTarget() + " " + getProgressUnit() + separatorBetweenTargetAndProgress
                    + MESSAGE_NO_BODY_WEIGHT_PROGRESS + getAchieved() + "\n";
        } else {
            return SEPATATOR_TAB + SEPATATOR_TAB + getDaySet().format(DATE_FORMATTER) + SEPATATOR_TAB + SEPATATOR_TAB
                    + getPeriodType().toString().toLowerCase() + separatorBetweenTypeAndTarget
                    + getTarget() + " " + getProgressUnit() + separatorBetweenTargetAndProgress
                    + getProgress() + " " + getProgressUnit() + getAchieved() + "\n";
        }
    }

    @Override
    public String getGoalDataToStore() {
        return "W" + SEPARATOR + getDaySet().format(DATE_FORMATTER) + SEPARATOR + periodType + SEPARATOR + target;
    }

    private int getLengthOfTarget() {
        return ("" + target).length() + getProgressUnit().length() + 1;
    }
}
