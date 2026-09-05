import java.util.Locale;

public class Duke {

    private String commandType = "";

    public static void main(String[] args) {
        System.out.println("Hello!");
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        commandType = getCommandTypeFor(input);
        return "Duke heard: " + input;
    }

    public String getCommandType() {
        return commandType;
    }

    /**
     * Classifies the command prefixes used by the tutorial's dynamic styles.
     */
    private String getCommandTypeFor(String input) {
        String trimmedInput = input.strip();
        if (trimmedInput.isEmpty()) {
            return "";
        }

        String commandWord = trimmedInput.split("\\s+", 2)[0].toLowerCase(Locale.ROOT);
        return switch (commandWord) {
        case "todo", "deadline", "event" -> "AddCommand";
        case "mark" -> "ChangeMarkCommand";
        case "delete" -> "DeleteCommand";
        default -> "";
        };
    }
}
