package FileManager;

/**
 * Enum for ElementReader class for identifying source
 * @see Commands.ElementReader
 */
public enum ReaderMode {
    /**
     * Use this if working with System.in source.
     */
    CONSOLE,
    /**
     * Use this if working with script executing.
     * @see Commands.Interactive.ExecuteScript
     */
    SCRIPT,
    /**
     * Use this if working with reading collection.
     * @see CollectionReader
     */
    FILE,
    /**
     * Use this if working with remove_greater command
     * @see Commands.Interactive.RemoveGreaterCommand
     */
    GREATER
}
