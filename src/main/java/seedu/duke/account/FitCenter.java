package seedu.duke.account;

import seedu.duke.command.CommandRecordType;
import seedu.duke.common.Messages;
import seedu.duke.goal.GoalList;
import seedu.duke.goal.Goal;
import seedu.duke.goal.PeriodType;
import seedu.duke.record.Record;
import seedu.duke.record.RecordList;
import seedu.duke.record.RecordType;


import java.time.LocalDate;

import static seedu.duke.command.CommandRecordType.EXERCISE;
import static seedu.duke.command.CommandRecordType.DIET;
import static seedu.duke.command.CommandRecordType.SLEEP;
import static seedu.duke.command.CommandRecordType.BODY_WEIGHT;
import static seedu.duke.goal.PeriodType.DAILY;

/**
 * Manages the fitness of a user through list of records.
 */
public class FitCenter {
    private final RecordList sleepRecordList = new RecordList(RecordType.SLEEP);
    private final RecordList exerciseRecordList = new RecordList(RecordType.EXERCISE);
    private final RecordList dietRecordList = new RecordList(RecordType.DIET);
    private final RecordList bodyRecordList = new RecordList(RecordType.BODYWEIGHT);
    private final GoalList exerciseGoalList = new GoalList();
    private final GoalList dietGoalList = new GoalList();
    private final GoalList sleepGoalList = new GoalList();
    private final GoalList bodyWeightGoalList = new GoalList();

    private RecordList getRecordListByType(CommandRecordType type) {
        switch (type) {
        case SLEEP:
            return sleepRecordList;
        case EXERCISE:
            return exerciseRecordList;
        case DIET:
            return dietRecordList;
        case BODY_WEIGHT:
            return bodyRecordList;
        default:
            return null;
        }
    }

    private GoalList getGoalListByType(CommandRecordType type) {
        switch (type) {
        case SLEEP:
            return sleepGoalList;
        case EXERCISE:
            return exerciseGoalList;
        case DIET:
            return dietGoalList;
        case BODY_WEIGHT:
            return bodyWeightGoalList;
        default:
            return null;
        }
    }

    public void resetGoalProgress(PeriodType periodType) {
        exerciseGoalList.initializeGoalProgress(periodType);
        dietGoalList.initializeGoalProgress(periodType);
        sleepGoalList.initializeGoalProgress(periodType);
        bodyWeightGoalList.initializeGoalProgress(periodType);
    }

    /**
     * Adds a given record to a list that stores the same type of records.
     *
     * @param type   the type of the record.
     * @param record the record to add.
     */
    public void addRecordToList(CommandRecordType type, Record record) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            list.addRecord(record);
        }
    }

    /**
     * Adds a given goal to a list that stores the same type of goals.
     *
     * @param type the type of the goal.
     * @param goal the goal to add.
     */
    public void addGoalToList(CommandRecordType type, Goal goal) {
        double progress;
        LocalDate currentDate = goal.getDaySet();
        GoalList list = getGoalListByType(type);
        if (list != null) {
            list.addGoal(goal);
        }
        switch (type) {
        case EXERCISE:
            progress = exerciseRecordList.getDailyProgress(currentDate);
            break;
        case DIET:
            progress = dietRecordList.getDailyProgress(currentDate);
            break;
        case BODY_WEIGHT:
            progress = bodyRecordList.getDailyProgress(currentDate);
            break;
        case SLEEP:
            progress = sleepRecordList.getDailyProgress(currentDate);
            break;
        default:
            return;
        }
        goal.setProgress(progress);
    }

    /**
     * Removes a record from a record list by index.
     *
     * @param type  the type of the record.
     * @param index the index of the record in the list.
     * @return a summary of the record removed.
     * @throws IndexOutOfBoundsException when the index input is out of range.
     */
    public String removeRecordFromList(CommandRecordType type, int index) throws IndexOutOfBoundsException {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            return list.removeRecord(index);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public String cancelGoalFromList(CommandRecordType type, int index) throws IndexOutOfBoundsException {
        GoalList list = getGoalListByType(type);
        if (list != null) {
            return list.removeGoal(index);
        }
        return Messages.MESSAGE_CANT_CANCEL_GOAL;
    }

    /**
     * Prints the list of record of a selected type.
     *
     * @param type the type of the record that the list stores.
     */
    public String getRecordListString(CommandRecordType type) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            return list.getRecordsToPrint();
        }
        return Messages.MESSAGE_CANT_VIEW_LIST;
    }

    /**
     * Prints the list of record of a selected type on a specific date.
     *
     * @param type the type of the record that the list stores.
     * @param date the date of records.
     */
    public String getRecordListString(CommandRecordType type, LocalDate date) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            return list.getRecordsToPrint(date);
        }
        return Messages.MESSAGE_CANT_VIEW_LIST;
    }

    public String getRecordListString(CommandRecordType type, String optionalParam) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            return list.getRecordsToPrint(optionalParam);
        }
        return Messages.MESSAGE_CANT_VIEW_LIST;
    }

    public String getRecordListString(CommandRecordType type, LocalDate date, String optionalParam) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            return list.getRecordsToPrint(date, optionalParam);
        }
        return Messages.MESSAGE_CANT_VIEW_LIST;
    }

    public String getGoalListString(CommandRecordType type, PeriodType optionalPeriodType) {
        GoalList list = getGoalListByType(type);
        if (list != null) {
            return list.getGoalsToPrint(optionalPeriodType);
        }
        return Messages.MESSAGE_CANT_CHECK_GOAL;
    }

    public String getAllGoalListStringAtLoading() {
        StringBuilder stringBuilder = new StringBuilder();
        if (dietGoalList.isNotEmpty()) {
            stringBuilder.append("Diet Goals\n");
            stringBuilder.append(getGoalListString(DIET, DAILY));
        }
        if (exerciseGoalList.isNotEmpty()) {
            stringBuilder.append("Exercise Goals\n");
            stringBuilder.append(getGoalListString(EXERCISE, DAILY));
        }
        if (sleepGoalList.isNotEmpty()) {
            stringBuilder.append("Sleep Goals\n");
            stringBuilder.append(getGoalListString(SLEEP, DAILY));
        }
        if (bodyWeightGoalList.isNotEmpty()) {
            stringBuilder.append("Body Weight Goals\n");
            stringBuilder.append(getGoalListString(BODY_WEIGHT, DAILY));
        }
        return stringBuilder.toString();
    }

    public String getRecordListForStore() {
        return exerciseRecordList.getRecordToStore()
                + dietRecordList.getRecordToStore()
                + sleepRecordList.getRecordToStore()
                + bodyRecordList.getRecordToStore();
    }

    public String getGoalListForStore() {
        return exerciseGoalList.getGoalToStore()
                + dietGoalList.getGoalToStore()
                + sleepGoalList.getGoalToStore()
                + bodyWeightGoalList.getGoalToStore();
    }

    public void initializeDailyProgressAtLoading(LocalDate currentDate) {
        dietGoalList.updateDailyProgress(dietRecordList.getDailyProgress(currentDate));
        exerciseGoalList.updateDailyProgress(exerciseRecordList.getDailyProgress(currentDate));
        sleepGoalList.updateDailyProgress(sleepRecordList.getDailyProgress(currentDate));
        bodyWeightGoalList.updateDailyProgress(bodyRecordList.getDailyProgress(currentDate));
    }

    public void updateDailyProgressAtAdding(Record record, LocalDate currentDate) {
        if (!record.getDate().isEqual(currentDate)) {
            return;
        }
        RecordType type = record.getType();
        switch (type) {
        case EXERCISE:
            exerciseGoalList.updateDailyProgress(exerciseRecordList.getDailyProgress(currentDate));
            break;
        case DIET:
            dietGoalList.updateDailyProgress(dietRecordList.getDailyProgress(currentDate));
            break;
        case SLEEP:
            sleepGoalList.updateDailyProgress(sleepRecordList.getDailyProgress(currentDate));
            break;
        case BODYWEIGHT:
            bodyWeightGoalList.updateDailyProgress(bodyRecordList.getDailyProgress(currentDate));
            break;
        default:
        }
    }
}
