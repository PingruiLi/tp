package seedu.duke.goal;

import seedu.duke.common.Messages;
import seedu.duke.goal.comparator.GoalPeriodTypeComparator;

import java.util.ArrayList;

/**
 * Represents a list of goals.
 */
public class GoalList {
    private final ArrayList<Goal> goals = new ArrayList<>();

    /**
     * Adds a new goal into the list.
     *
     * @param newGoal a new goal to be added.
     */
    public void addGoal(Goal newGoal) {
        goals.add(newGoal);
        goals.sort(new GoalPeriodTypeComparator());
    }

    /**
     * Removes a goal from the list.
     *
     * @param index the index of the goal in the list.
     * @return the string summary of the goal removed.
     * @throws IndexOutOfBoundsException when the index is out of range.
     */
    public String removeGoal(int index) throws IndexOutOfBoundsException {
        Goal goalToRemove = goals.get(index);
        String goalSummary = goalToRemove.getGoalSummary();
        goals.remove(goalToRemove);
        return goalSummary;
    }

    /**
     * Gets a printable string of goals that can be filtered by an optional period type given.
     *
     * @param optionalPeriodType an optional period type for filtering the result.
     * @return a printable string of goals that can be filtered by an optional period type given.
     */
    public String getGoalsToPrint(PeriodType optionalPeriodType) {
        if (goals.isEmpty()) {
            return Messages.MESSAGE_NO_GOAL;
        } else if (optionalPeriodType != null) {
            StringBuilder goalStringBuilder = new StringBuilder();
            int i = 1;
            for (Goal goal : goals) {
                if (goal.getPeriodType() == optionalPeriodType) {
                    goalStringBuilder.append(i).append(goal.getGoalData());
                    i++;
                }
            }
            if (i == 1) {
                return Messages.MESSAGE_NO_ELIGIBLE_GOAL;
            }
            return Messages.MESSAGE_CHECK_HEADER + goalStringBuilder.toString();
        } else {
            StringBuilder goalStringBuilder = new StringBuilder();
            int i = 1;
            for (Goal goal : goals) {
                goalStringBuilder.append(i).append(goal.getGoalData());
                i++;
            }
            return Messages.MESSAGE_CHECK_HEADER + goalStringBuilder.toString();
        }
    }

    /**
     * Initializes the progress of goals of a given period type in the list.
     *
     * @param periodType the period type of the goal.
     */
    public void initializeGoalProgress(PeriodType periodType) {
        assert periodType == PeriodType.INVALID || periodType == null : "A period type is expected but not received!";
        if (goals.isEmpty()) {
            return;
        }

        for (Goal goal : goals) {
            if (goal.getPeriodType().equals(periodType)) {
                goal.initializeProgress();
            }
        }
    }

    /**
     * Gets a string of goals in a pre-defined format that can be stored into a text file.
     *
     * @return a string of goals in a pre-defined format that can be stored into a text file.
     */
    public String getGoalToStore() {
        StringBuilder goalStringBuilder = new StringBuilder();
        for (Goal goal : goals) {
            goalStringBuilder.append(goal.getGoalDataToStore()).append("\n");
        }
        return goalStringBuilder.toString();
    }

    /**
     * Updates the progress of goals of a given period type with given progress value.
     *
     * @param periodType the period type of goals.
     * @param progress   the new value of the progress in double.
     */
    public void updateProgress(PeriodType periodType, double progress) {
        for (Goal goal : goals) {
            if (goal.getPeriodType().equals(periodType)) {
                goal.setProgress(progress);
            }
        }
    }

    /**
     * Checks if the goal list has goals.
     *
     * @return true if the goal list has goals, otherwise false.
     */
    public boolean isNotEmpty() {
        return goals.size() != 0;
    }

    /**
     * Checks if the goal list has goals of a specified period type.
     *
     * @param periodType the period type of goals.
     * @return true if the goal list has goals of a specified period type, otherwise false.
     */
    public boolean isNotEmpty(PeriodType periodType) {
        if (goals.size() == 0) {
            return false;
        } else {
            int num = 0;
            for (Goal goal : goals) {
                if (goal.getPeriodType().equals(periodType)) {
                    num++;
                }
            }
            return num != 0;
        }
    }

    /**
     * Checks if all goals of a specified period type in the list are achieved.
     *
     * @param periodType the period type of goals.
     * @return true if all goals of a specified period type in the list are achieved, otherwise false.
     */
    public boolean isGoalAchieved(PeriodType periodType) {
        for (Goal goal : goals) {
            if (goal.getPeriodType().equals(periodType) && !goal.isAchieved()) {
                return false;
            }
        }
        return true;
    }
}
