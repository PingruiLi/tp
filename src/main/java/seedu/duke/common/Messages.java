package seedu.duke.common;

/**
 * Container for commonly used messages.
 */
public class Messages {
    //public static final String SPACING = "        ";
    public static final String MESSAGE_VERSION = "V2.0";
    public static final String MESSAGE_FEATURES = "You can use the app by using command ADD, VIEW, and DELETE.";
    public static final String MESSAGE_WELCOME = "Healthier - your powerful personal fitness app.\n"
            + "What's in your mind?\n";
    public static final String MESSAGE_BYE = "Nice work today!\n"
            + "You are one step closer to ultimate fitness!\n"
            + "See you again soon :)\n";
    public static final String MESSAGE_EXIT = "Thank you for using this app. The app is exiting...";
    public static final String MESSAGE_HELP_PROMPT = "Not sure how to use this app?\n"
            + "Use command 'help' to see what you can do.";
    public static final String MESSAGE_HELP_GREETINGS = "Thank you for choosing to be healthier with us.\n"
            + "The current version of this application is: " + MESSAGE_VERSION + "\n"
            + MESSAGE_FEATURES + "\n";
    public static final String MESSAGE_CHECK_GOALS_PROMPT = "Check out your current goals with command 'check'.\n";
    public static final String MESSAGE_SAME_DAY = "Welcome back to Healthier today.";
    public static final String MESSAGE_NEW_DAY = "Nice to see you on a brand new day!\n"
            + "All progress of daily goals have been reset for you.\n";
    public static final String MESSAGE_NEW_WEEK = "Today marks a new week.\nThis week is week %s.\n"
            + "All progress of weekly goals have been reset for you.\n";
    public static final String MESSAGE_UNACHIEVED_GOALS = "You have unachieved goals.\n";
    public static final String MESSAGE_GOALS_DONE_TODAY = "Congratulations!\n"
            + "You have achieved all daily goals for today!";
    public static final String MESSAGE_GOALS_DONE_THIS_WEEK = "Congratulations!\n"
            + "You have achieved all weekly goals for this week!";
    public static final String MESSAGE_VIEW_TITLE = "Displaying all eligible %s records:\n";
    public static final String MESSAGE_CHECK_TITLE = "Checking the progress of eligible %s goals:\n";
    public static final String MESSAGE_CHECK_HEADER = "Index    Date Set          Goal Type       "
            + "Target          Progress\n";
    public static final String MESSAGE_VIEW_HEADER_EXERCISE = "Index        Date          Activity        "
            + "Duration        Calories\n";
    public static final String MESSAGE_VIEW_HEADER_DIET = "Index        Date          Food Category       Weight"
            + "      Calories\n";
    public static final String MESSAGE_VIEW_HEADER_SLEEP = "Index        Date              Duration\n";
    public static final String MESSAGE_VIEW_HEADER_WEIGHT = "Index        Date              Body Weight\n";
    public static final String MESSAGE_NO_RECORD = "Sorry, no records found.\n"
            + "You can try adding records by using command 'add'.";
    public static final String MESSAGE_NO_GOAL = "Sorry, no goals found.\n"
            + "You can try setting a goal by using command 'set'.";
    public static final String MESSAGE_NO_ELIGIBLE_GOAL = "Sorry, there are currently no eligible goals\n"
            + "You can try setting a goal by using command 'set'.";
    public static final String MESSAGE_INDEX_NUMBER_FORMAT_EXCEPTION = "The index field is not a valid integer "
            + "number.\nPlease try again.";
    public static final String MESSAGE_INDEX_OUT_OF_RANGE_EXCEPTION = "The index entered is out of range.\n"
            + "Please try again.";
    public static final String MESSAGE_CANT_INIT_STORAGE = "Sorry, the system is unable to initialize storage "
            + "due to IO exception.";
    public static final String MESSAGE_CANT_STORE_TIME = "Sorry, the system is unable to store the time "
            + "due to IO exception.";
    public static final String MESSAGE_CANT_ADD_RECORD = "Sorry, you cannot add record of an unrecognized type.";
    public static final String MESSAGE_CANT_SET_GOAL = "Sorry, you cannot set goal for an unrecognized type.";
    public static final String MESSAGE_CANT_VIEW_LIST = "Sorry, you cannot view a record list "
            + "of an incorrect record type.";
    public static final String MESSAGE_NO_BODY_WEIGHT_RECORD = "You haven't added any body weight record. "
            + "Use add command to track the change of your body weight.";
    public static final String MESSAGE_NO_BODY_WEIGHT_PROGRESS = "You haven't added any body weight record.";
    public static final String MESSAGE_CANT_CHECK_GOAL = "Sorry, you cannot check a goal list "
            + "of an incorrect goal type.";
    public static final String MESSAGE_CANT_CANCEL_GOAL = "Sorry, you cannot cancel a goal from a goal list "
            + "of an incorrect goal type.";
    public static final String MESSAGE_SYSTEM_ERROR = "There is something wrong within the system.";
    public static final String MESSAGE_DOUBLE_FORMAT_ERROR = "A double value is expected for the number field. "
            + "Please verify your input and try again.";
    public static final String MESSAGE_INVALID_INTERVAL_TYPE = "The interval type you entered is invalid.\n"
            + "The interval type can only be 'D' or 'W'. Please try again.";
    public static final String MESSAGE_INVALID_DATE_FORMAT = "The date format is incorrect or the date is invalid. "
            + "Please try again.\n";
    public static final String MESSAGE_INVALID_SLEEP_HOUR = "The duration you entered is invalid.\n"
            + "It should be an positive integer between 0 and 24, with the unit of hour.\nPlease try again.";
    public static final String MESSAGE_INVALID_WORKOUT_MIN = "The duration you entered is invalid.\n"
            + "It should be an positive integer between 0 and 1440, with the unit of minute.\nPlease try again.";
    public static final String MESSAGE_INVALID_WEIGHT = "The weight you entered is invalid.\n"
            + "It should be an positive floating point number, with the unit of kilogram(kg).\nPlease try again.";
    public static final String MESSAGE_INVALID_FOOD_CATEGORY = "The food category you entered is invalid.\n"
            + "The acceptable food category list is:\n";
    public static final String MESSAGE_INVALID_FOOD_AMOUNT = "The amount you entered is invalid.\n"
            + "The acceptable amount of food should be a floating point number, with the unit of gram(g).\n"
            + "Please try again.";
    public static final String MESSAGE_FUTURE_DATE_RECORD = "You are only allowed to add records for current "
            + "or previous days.\nPlease try again.";
    public static final String MESSAGE_INVALID_TARGET_ENERGY = "The target energy you entered is invalid\n"
            + "The acceptable target energy should be a floating point number, with the unit of K cal within"
            + "range 0 - 10000.\nPlease try again.";
    public static final String MESSAGE_INVALID_TARGET_SLEEP_DURATION = "The target duration you entered is invalid\n"
            + "The acceptable target duration should be a floating point number, with the unit of hour within"
            + "range 0 - 24.\nPlease try again.";
    public static final String MESSAGE_INVALID_TARGET_BODY_WEIGHT = "The target weight you entered is invalid\n"
            + "The acceptable target weight should be a floating point number, with the unit of kilogram (kg) within"
            + "range 0 - 400.\nPlease try again.";
    public static final String MESSAGE_INVALID_WORKOUT_CATEGORY = "The workout category you entered is invalid.\n"
            + "The acceptable workout category list is:\n";
    public static final String MESSAGE_INVALID_COMMAND = "Sorry, the command you entered cannot be recognized.\n\n";
    public static final String MESSAGE_INVALID_COMMAND_WORD = "The command word is invalid. "
            + "Enter help to see help messages\n";
    public static final String MESSAGE_INVALID_COMMAND_SYNTAX = "Sorry, "
            + "the syntax of the command entered is incorrect.\n\n";
    public static final String MESSAGE_SYNTAX_ADD_COMMAND = "The syntax for add command is:\n"
            + "1. Add exercise record\n\tadd t/E a/ACTIVITY_NAME d/DURATION [date/DD-MM-YYYY]\n"
            + "   The duration is with unit of minute.\n"
            + "2. Add diet record\n\tadd t/D f/FOOD_TYPE w/WEIGHT [date/DD-MM-YYYY]\n"
            + "   The amount is with unit of gram.\n"
            + "3. Add sleep record\n\tadd t/S d/DURATION [date/DD-MM-YYYY]\n"
            + "   The duration is with unit of hour.\n"
            + "4. Add body weight record\n\tadd t/W w/WEIGHT [date/DD-MM-YYYY]\n"
            + "   The weight is with unit of kilogram.\n"
            + "Please note the type must be in uppercase.";
    public static final String MESSAGE_SYNTAX_VIEW_COMMAND = "The syntax for view command is:\n"
            + "1. View exercise records\n\tview t/E [a/ACTIVITY_NAME] [date/DD-MM-YYYY]\n"
            + "2. View diet records\n\tview t/D [f/FOOD_NAME] [date/DD-MM-YYYY]\n"
            + "3. View sleep records\n\tview t/S [date/DD-MM-YYYY]\n"
            + "4. View body weight records\n\tview t/W [date/DD-MM-YYYY]";
    public static final String MESSAGE_SYNTAX_DELETE_COMMAND = "The syntax for delete command is:\n"
            + "1. Delete exercise records\n\tdelete t/E [a/ACTIVITY_NAME] [date/DD-MM-YYYY]\n"
            + "2. Delete diet records\n\tdelete t/D i/index\n"
            + "3. Delete sleep records\n\tdelete t/S i/index\n"
            + "4. Delete body weight records\n\tdelete t/W i/index";
    public static final String MESSAGE_SYNTAX_SET_COMMAND = "The syntax for set command is:\n"
            + "1. Set exercise goals\n\tset t/E p/INTERVAL_TYPE target/TARGET_ENERGY\n"
            + "2. Set diet goals\n\tset t/D p/INTERVAL_TYPE target/TARGET_ENERGY\n"
            + "3. Set sleep goals\n\tset t/S p/INTERVAL_TYPE target/TARGET_DURATION\n"
            + "4. Set body weight goals\n\tset t/W p/INTERVAL_TYPE target/TARGET_WEIGHT";
    public static final String MESSAGE_SYNTAX_CHECK_COMMAND = "The syntax for check command is:\n"
            + "1. check exercise goals\n\tcheck t/E [p/INTERVAL_TYPE]\n"
            + "2. check diet goals\n\tcheck t/D [p/INTERVAL_TYPE]\n"
            + "3. check sleep goals\n\tcheck t/S [p/INTERVAL_TYPE]\n"
            + "4. check body weight goals\n\tcheck t/W [p/INTERVAL_TYPE]";
    public static final String MESSAGE_SYNTAX_CANCEL_COMMAND = "The syntax for cancel command is:\n"
            + "1. cancel exercise goals\n\tcancel t/E i/INDEX\n"
            + "2. cancel diet goals\n\tcancel t/D i/INDEX\n"
            + "3. cancel sleep goals\n\tcancel t/S i/INDEX\n"
            + "4. cancel body weight goals\n\tcancel t/W i/INDEX";
    public static final String MESSAGE_SYNTAX_EXIT_COMMAND = "The syntax for exit command is:\n"
            + "\texit";
}