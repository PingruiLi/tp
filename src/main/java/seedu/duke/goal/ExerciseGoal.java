package seedu.duke.goal;

import seedu.duke.account.User;
import seedu.duke.record.RecordType;

import java.time.LocalDate;

public class ExerciseGoal extends Goal {
    private final double targetEnergy;
    private double progress;

    /**
     * Initialize an instance of an exercise goal.
     *
     * @param periodType   the period type of the goal which can be daily or weekly.
     * @param targetEnergy the target energy to be burnt.
     */
    public ExerciseGoal(PeriodType periodType, double targetEnergy) {
        super(RecordType.EXERCISE, periodType);
        this.targetEnergy = targetEnergy;
        initializeProgress();
    }

    public ExerciseGoal(PeriodType periodType, double targetEnergy, LocalDate daySet) {
        super(RecordType.EXERCISE, periodType);
        this.targetEnergy = targetEnergy;
        this.daySet = daySet;
        initializeProgress();
    }
    /**
     * Gets the the target energy to be burnt.
     *
     * @return the target energy to be burnt in kcal.
     */
    public double getTargetEnergy() {
        return targetEnergy;
    }

    /**
     * Gets the progress of the exercise goal (energy burnt).
     *
     * @return the energy burnt in kcal.
     */
    public double getProgress() {
        return progress;
    }

    /**
     * Initializes the progress of the exercise goal (energy burnt) to 0 kcal.
     */
    public void initializeProgress() {
        this.progress = 0;
    }

    /**
     * Updates the progress of the exercise goal (energy burnt).
     *
     * @param progress the energy burnt in kcal.
     */
    public void updateProgress(double progress) {
        this.progress = progress;
    }


    @Override
    public String getProgressUnit() {
        return "Kcal";
    }

    /**
     * Gets a string summary of all info of this goal instance.
     *
     * @return a summary of all info of this goal instance in String.
     */
    @Override
    public String getGoalSummary() {
        return "Date Set: " + getDaySet().format(DATE_FORMATTER) + "\n"
                + "Goal Type: " + getPeriodType().toString() + " " + getType().toString().toLowerCase() + "\n"
                + "Target: " + getTargetEnergy() + getProgressUnit() + "\n"
                + "Progress: " + getProgress() + getProgressUnit();
    }

    /**
     * Gets all data of the goal in a table row.
     *
     * @return a string of all data of the goal in a table row.
     */
    @Override
    public String getGoalData() {
        return "\t" + getDaySet().format(DATE_FORMATTER) + "\t"
                + getPeriodType().toString().toLowerCase() + "\t"
                + getTargetEnergy() + getProgressUnit() + "\t"
                + getProgress() + getProgressUnit() + "\n";
    }

    @Override
    public String getGoalDataToStore() {
        return "E" + SEPARATOR + daySet + SEPARATOR + periodType + SEPARATOR + targetEnergy;
    }

    @Override
    public void setProgressAtLoadingTime(User user){

    }
}
