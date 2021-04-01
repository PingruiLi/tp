package seedu.duke.command;

import seedu.duke.account.FitCenter;
import seedu.duke.common.Messages;

/**
 * Represents a command of displaying help message.
 */
public class HelpCommand extends Command {
    public HelpCommand() {
        feedback = Messages.MESSAGE_HELP_GREETINGS + "\n"
                + Messages.MESSAGE_SYNTAX_ADD_COMMAND + "\n\n"
                + Messages.MESSAGE_SYNTAX_VIEW_COMMAND + "\n\n"
                + Messages.MESSAGE_SYNTAX_DELETE_COMMAND + "\n\n"
                + Messages.MESSAGE_SYNTAX_SET_COMMAND + "\n\n"
                + Messages.MESSAGE_SYNTAX_CHECK_COMMAND + "\n\n"
                + Messages.MESSAGE_SYNTAX_CANCEL_COMMAND + "\n\n"
                + Messages.MESSAGE_SYNTAX_EXIT_COMMAND;
    }

    /**
     * Gets help messages.
     *
     * @param fitCenter the fitCenter interface for current user.
     * @return the help messages.
     */
    @Override
    public CommandResult execute(FitCenter fitCenter) {
        return new CommandResult(feedback);
    }
}
