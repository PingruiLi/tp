package seedu.duke.goal;

import seedu.duke.common.Messages;
import seedu.duke.record.RecordType;

import java.lang.reflect.Member;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents the abstraction of a goal to be achieved.
 */
public abstract class Goal {
    protected static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    protected static final int SPACES_FOR_TYPE = 16;
    protected static final int SPACES_FOR_TARGET = 16;
    protected LocalDate daySet;
    protected RecordType type;
    protected PeriodType periodType;
    protected double target;
    protected double progress;
    protected int lengthOfPeriodType;
    protected int lengthOfTarget;
    protected String separatorBetweenTypeAndTarget;
    protected String separatorBetweenTargetAndProgress;
    public static final String SEPARATOR = " | ";
    protected static final String SEPATATOR_TAB = "    ";

    /**
     * Initializes the instance with goal type and period type.
     *
     * @param type       the type of the goal which corresponds to the type of health records.
     * @param periodType the period type of the goal which can be daily or weekly.
     */
    public Goal(RecordType type, PeriodType periodType) {
        this.type = type;
        this.periodType = periodType;
        daySet = LocalDate.now();
        lengthOfPeriodType = getLengthOfPeriodType();
    }

    /**
     * Initializes the instance with goal type and period type and target value.
     *
     * @param type       the type of the goal which corresponds to the type of health records.
     * @param periodType the period type of the goal which can be daily or weekly.
     * @param target     the target value of the goal in double.
     */
    public Goal(RecordType type, PeriodType periodType, double target) {
        this.type = type;
        this.periodType = periodType;
        daySet = LocalDate.now();
        this.target = target;
        lengthOfPeriodType = getLengthOfPeriodType();
    }

    /**
     * Initializes the instance with goal type and period type and target value and date set.
     *
     * @param type       the type of the goal which corresponds to the type of health records.
     * @param periodType the period type of the goal which can be daily or weekly.
     * @param target     the target value of the goal in double.
     * @param date       the date when the goal is set in LocalDate
     */
    public Goal(RecordType type, PeriodType periodType, double target, LocalDate date) {
        this.type = type;
        this.periodType = periodType;
        daySet = date;
        this.target = target;
        lengthOfPeriodType = getLengthOfPeriodType();
    }

    /**
     * Gets the current progress of the goal.
     *
     * @return the value of the current progress of the goal in double.
     */
    public double getProgress() {
        return progress;
    }

    /**
     * Sets the current progress of the goal.
     *
     * @param progress the value of the new progress of the goal in double.
     */
    public void setProgress(double progress) {
        this.progress = progress;
    }

    /**
     * Initializes the value of the progress of the goal to 0.
     */
    public void initializeProgress() {
        progress = 0;
    }

    /**
     * Gets the target of the goal.
     *
     * @return the value of the target of the goal in double.
     */
    public double getTarget() {
        return target;
    }

    /**
     * Gets the date when the goal is set by the user.
     *
     * @return the date when the goal is set by the user.
     */
    public LocalDate getDaySet() {
        return daySet;
    }

    /**
     * Gets the type of the goal.
     *
     * @return the type of the goal which corresponds to the type of health records.
     */
    public RecordType getType() {
        return type;
    }

    /**
     * Gets the period type of a goal.
     *
     * @return the period type of the goal which can be daily or weekly.
     */
    public PeriodType getPeriodType() {
        return periodType;
    }

    /**
     * Checks if the goal is achieved.
     *
     * @return true if the goal is achieved.
     */
    public boolean isAchieved() {
        return progress >= target;
    }

    /**
     * Gets a string value of the status of the goal.
     *
     * @return '(achieved)' when the goal is achieved, otherwise '(not achieved)'.
     */
    public String getAchieved() {
        return isAchieved() ? "(achieved)" : "(not achieved)";
    }

    /**
     * Gets a string summary of all info of this goal instance.
     *
     * @return a summary of all info of this goal instance in String.
     */
    public abstract String getGoalSummary();

    /**
     * Gets all data of the goal in a table row.
     *
     * @return a string of all data of the goal in a table row.
     */
    public abstract String getGoalData();

    /**
     * Gets the unit of the progress of the goal.
     *
     * @return a string of the unit of the progress of the goal.
     */
    public abstract String getProgressUnit();

    /**
     * Gets all data of the goal in a format that can be stored into a text file.
     *
     * @return a string of all data of the goal in a format that can be stored into a text file.
     */
    public abstract String getGoalDataToStore();

    protected void setSeparatorBetweenTypeAndTarget() {
        separatorBetweenTypeAndTarget = "";
        for (int i = 0; i < SPACES_FOR_TYPE - lengthOfPeriodType; i++) {
            separatorBetweenTypeAndTarget += " ";
        }
    }

    protected void setSeparatorBetweenTargetAndProgress() {
        separatorBetweenTargetAndProgress = "";
        for (int i = 0; i < SPACES_FOR_TARGET - lengthOfTarget; i++) {
            separatorBetweenTargetAndProgress += " ";
        }
    }

    private int getLengthOfPeriodType() {
        return periodType.toString().length();
    }

    protected void setSeparator() {
        setSeparatorBetweenTargetAndProgress();
        setSeparatorBetweenTypeAndTarget();
    }
}
