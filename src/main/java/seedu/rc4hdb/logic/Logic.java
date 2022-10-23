package seedu.rc4hdb.logic;

import java.nio.file.Path;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import seedu.rc4hdb.commons.core.GuiSettings;
import seedu.rc4hdb.logic.commands.CommandResult;
import seedu.rc4hdb.logic.commands.exceptions.CommandException;
import seedu.rc4hdb.logic.parser.exceptions.ParseException;
import seedu.rc4hdb.model.ReadOnlyResidentBook;
import seedu.rc4hdb.model.resident.Resident;
import seedu.rc4hdb.model.venues.Venue;
import seedu.rc4hdb.model.venues.booking.Booking;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the ResidentBook.
     *
     * @see seedu.rc4hdb.model.Model#getResidentBook()
     */
    ReadOnlyResidentBook getResidentBook();

    /** Returns an unmodifiable view of the filtered list of residents */
    ObservableList<Resident> getFilteredResidentList();

    /**
     * Returns the user prefs' resident book file path.
     */
    Path getUserPrefsResidentBookFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the list of observable resident fields in the model.
     */
    ObservableList<String> getObservableFields();

    /**
     * Returns the current data file path of the storage's ResidentBookStorage.
     */
    ObservableValue<Path> getObservableResidentBookFilePath();

    /**
     * Returns the list of observable venues in the model.
     */
    ObservableList<Venue> getObservableVenues();

    ObservableList<Booking> getObservableBookings();
}
