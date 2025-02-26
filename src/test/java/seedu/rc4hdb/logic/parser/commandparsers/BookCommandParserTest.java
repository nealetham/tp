package seedu.rc4hdb.logic.parser.commandparsers;

import static seedu.rc4hdb.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.rc4hdb.logic.parser.CliSyntax.PREFIX_DAY;
import static seedu.rc4hdb.logic.parser.CliSyntax.PREFIX_TIME_PERIOD;
import static seedu.rc4hdb.logic.parser.CliSyntax.PREFIX_VENUE_NAME;
import static seedu.rc4hdb.logic.parser.ParserUtil.MESSAGE_INVALID_INDEX;
import static seedu.rc4hdb.logic.parser.commandparsers.CommandParserTestUtil.assertParseFailure;
import static seedu.rc4hdb.logic.parser.commandparsers.CommandParserTestUtil.assertParseSuccess;
import static seedu.rc4hdb.testutil.TypicalBookings.HP_5_TO_6PM;
import static seedu.rc4hdb.testutil.TypicalBookings.HP_5_TO_6PM_STRING;
import static seedu.rc4hdb.testutil.TypicalBookings.HP_5_TO_7PM_STRING;
import static seedu.rc4hdb.testutil.TypicalBookings.MONDAY;
import static seedu.rc4hdb.testutil.TypicalBookings.MONDAY_STRING;
import static seedu.rc4hdb.testutil.TypicalBookings.TUESDAY_STRING;
import static seedu.rc4hdb.testutil.TypicalVenues.DISCUSSION_ROOM_STRING;
import static seedu.rc4hdb.testutil.TypicalVenues.HALL_STRING;
import static seedu.rc4hdb.testutil.TypicalVenues.HALL_VENUE_NAME;

import org.junit.jupiter.api.Test;

import seedu.rc4hdb.commons.core.index.Index;
import seedu.rc4hdb.logic.commands.venuecommands.BookCommand;
import seedu.rc4hdb.model.venues.VenueName;
import seedu.rc4hdb.model.venues.booking.BookingDescriptor;
import seedu.rc4hdb.model.venues.booking.fields.Day;
import seedu.rc4hdb.model.venues.booking.fields.HourPeriod;

/**
 * Unit tests for {@link BookCommandParser}.
 */
public class BookCommandParserTest {

    private BookCommandParser parser = new BookCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        BookingDescriptor expectedBookingDescriptor = new BookingDescriptor();
        expectedBookingDescriptor.setVenueName(HALL_VENUE_NAME);
        expectedBookingDescriptor.setHourPeriod(HP_5_TO_6PM);
        expectedBookingDescriptor.setDayOfWeek(MONDAY);
        Index expectedIndex = Index.fromOneBased(1);
        BookCommand expectedBookCommand = new BookCommand(expectedIndex, expectedBookingDescriptor);

        // EP: one of all fields - success
        assertParseSuccess(parser, new StringBuilder().append(1).append(" ")
                .append(PREFIX_VENUE_NAME).append(" ").append(HALL_STRING).append(" ")
                .append(PREFIX_TIME_PERIOD).append(" ").append(HP_5_TO_6PM_STRING).append(" ")
                .append(PREFIX_DAY).append(" ").append(MONDAY_STRING).toString(),
                expectedBookCommand);

        // EP: multiple of all fields
        assertParseSuccess(parser, new StringBuilder().append(1).append(" ")
                .append(PREFIX_VENUE_NAME).append(" ").append(DISCUSSION_ROOM_STRING).append(" ")
                .append(PREFIX_VENUE_NAME).append(" ").append(HALL_STRING).append(" ")
                .append(PREFIX_TIME_PERIOD).append(" ").append(HP_5_TO_7PM_STRING).append(" ")
                .append(PREFIX_TIME_PERIOD).append(" ").append(HP_5_TO_6PM_STRING).append(" ")
                .append(PREFIX_DAY).append(" ").append(TUESDAY_STRING).append(" ")
                .append(PREFIX_DAY).append(" ").append(MONDAY_STRING).toString(),
                expectedBookCommand);
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, BookCommand.MESSAGE_USAGE);

        // EP: Preamble missing
        assertParseFailure(parser, new StringBuilder()
                        .append(PREFIX_VENUE_NAME).append(" ").append(HALL_STRING).append(" ")
                        .append(PREFIX_TIME_PERIOD).append(" ").append(HP_5_TO_6PM_STRING).append(" ")
                        .append(PREFIX_DAY).append(" ").append(MONDAY_STRING).toString(),
                expectedMessage);

        // EP: Venue name missing
        assertParseFailure(parser, new StringBuilder().append(1).append(" ")
                        .append(PREFIX_TIME_PERIOD).append(" ").append(HP_5_TO_6PM_STRING).append(" ")
                        .append(PREFIX_DAY).append(" ").append(MONDAY_STRING).toString(),
                expectedMessage);

        // EP: Time period missing
        assertParseFailure(parser, new StringBuilder().append(1).append(" ")
                        .append(PREFIX_VENUE_NAME).append(" ").append(HALL_STRING).append(" ")
                        .append(PREFIX_DAY).append(" ").append(MONDAY_STRING).toString(),
                expectedMessage);

        // EP: Day missing
        assertParseFailure(parser, new StringBuilder().append(1).append(" ")
                        .append(PREFIX_VENUE_NAME).append(" ").append(HALL_STRING).append(" ")
                        .append(PREFIX_TIME_PERIOD).append(" ").append(HP_5_TO_6PM_STRING).toString(),
                expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        int invalidIndex = -5;
        String invalidVenueName = "Meeting_Room";
        String invalidHourPeriod = "12-11";
        String invalidDay = "Monday";

        // EP: Invalid index - Invalid index message
        assertParseFailure(parser, new StringBuilder().append(invalidIndex).append(" ")
                .append(PREFIX_VENUE_NAME).append(" ").append(HALL_STRING).append(" ")
                .append(PREFIX_TIME_PERIOD).append(" ").append(HP_5_TO_6PM_STRING).append(" ")
                .append(PREFIX_DAY).append(" ").append(MONDAY_STRING).toString(),
                MESSAGE_INVALID_INDEX);

        // EP: Invalid venue name - Invalid venue name message
        assertParseFailure(parser, new StringBuilder().append(1).append(" ")
                .append(PREFIX_VENUE_NAME).append(" ").append(invalidVenueName).append(" ")
                .append(PREFIX_TIME_PERIOD).append(" ").append(HP_5_TO_6PM_STRING).append(" ")
                .append(PREFIX_DAY).append(" ").append(MONDAY_STRING).toString(),
                VenueName.MESSAGE_CONSTRAINTS);

        // EP: Invalid hour period - Invalid hour period message
        assertParseFailure(parser, new StringBuilder().append(1).append(" ")
                .append(PREFIX_VENUE_NAME).append(" ").append(HALL_STRING).append(" ")
                .append(PREFIX_TIME_PERIOD).append(" ").append(invalidHourPeriod).append(" ")
                .append(PREFIX_DAY).append(" ").append(MONDAY_STRING).toString(),
                HourPeriod.MESSAGE_CONSTRAINTS);

        // EP: Invalid day - Invalid day message
        assertParseFailure(parser, new StringBuilder().append(1).append(" ")
                .append(PREFIX_VENUE_NAME).append(" ").append(HALL_STRING).append(" ")
                .append(PREFIX_TIME_PERIOD).append(" ").append(HP_5_TO_6PM_STRING).append(" ")
                .append(PREFIX_DAY).append(" ").append(invalidDay).toString(),
                Day.MESSAGE_CONSTRAINTS);

        // EP: Multiple invalid values - Message in the following order of importance
        // Index < Venue Name < Hour Period < Day
        assertParseFailure(parser, new StringBuilder().append(invalidIndex).append(" ")
                .append(PREFIX_VENUE_NAME).append(" ").append(invalidVenueName).append(" ")
                .append(PREFIX_TIME_PERIOD).append(" ").append(invalidHourPeriod).append(" ")
                .append(PREFIX_DAY).append(" ").append(invalidDay).toString(),
                MESSAGE_INVALID_INDEX);

        assertParseFailure(parser, new StringBuilder().append(1).append(" ")
                .append(PREFIX_VENUE_NAME).append(" ").append(invalidVenueName).append(" ")
                .append(PREFIX_TIME_PERIOD).append(" ").append(invalidHourPeriod).append(" ")
                .append(PREFIX_DAY).append(" ").append(invalidDay).toString(),
                VenueName.MESSAGE_CONSTRAINTS);

        assertParseFailure(parser, new StringBuilder().append(1).append(" ")
                .append(PREFIX_VENUE_NAME).append(" ").append(HALL_STRING).append(" ")
                .append(PREFIX_TIME_PERIOD).append(" ").append(invalidHourPeriod).append(" ")
                .append(PREFIX_DAY).append(" ").append(invalidDay).toString(),
                HourPeriod.MESSAGE_CONSTRAINTS);
    }

}
