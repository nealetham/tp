package seedu.rc4hdb.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.rc4hdb.model.ReadOnlyResidentBook;
import seedu.rc4hdb.model.ReadOnlyVenueBook;
import seedu.rc4hdb.model.ResidentBook;
import seedu.rc4hdb.model.VenueBook;
import seedu.rc4hdb.model.resident.Resident;
import seedu.rc4hdb.model.resident.fields.Email;
import seedu.rc4hdb.model.resident.fields.Gender;
import seedu.rc4hdb.model.resident.fields.House;
import seedu.rc4hdb.model.resident.fields.MatricNumber;
import seedu.rc4hdb.model.resident.fields.Name;
import seedu.rc4hdb.model.resident.fields.Phone;
import seedu.rc4hdb.model.resident.fields.Room;
import seedu.rc4hdb.model.resident.fields.Tag;
import seedu.rc4hdb.model.venues.Venue;
import seedu.rc4hdb.model.venues.VenueName;
import seedu.rc4hdb.model.venues.booking.Booking;
import seedu.rc4hdb.model.venues.booking.RecurrentBooking;
import seedu.rc4hdb.model.venues.booking.fields.Day;
import seedu.rc4hdb.model.venues.booking.fields.HourPeriod;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Resident[] getSampleResidents() {
        return new Resident[] {
            new Resident(
                    new Name("Jon Tan"), new Phone("98113234"), new Email("jontan99@gmail.com"), new Room("03-10"),
                    new Gender("M"), new House("D"), new MatricNumber("A0000000A"), getTagSet("BlockHead")
            ),
            new Resident(
                    new Name("Ng Kai Ling"), new Phone("98841523"), new Email("ngkailing@gmail.com"), new Room("04-05"),
                    new Gender("F"), new House("A"), new MatricNumber("A0000000B"), getTagSet("HouseHead")
            ),
            new Resident(
                    new Name("Kate Lim"), new Phone("90184402"), new Email("katelim@gmail.com"), new Room("02-01"),
                    new Gender("F"), new House("U"), new MatricNumber("A0000000C"), getTagSet("SportsCapt")
            ),
            new Resident(
                    new Name("Ong Kai Wen"), new Phone("95430211"), new Email("kaiwen@gmail.com"), new Room("03-04"),
                    new Gender("M"), new House("U"), new MatricNumber("A0000000C"), getTagSet("Marketing")
            ),
            new Resident(
                    new Name("Lee Wei Ling"), new Phone("98770211"), new Email("weiwen95@gmail.com"), new Room("02-04"),
                    new Gender("F"), new House("L"), new MatricNumber("A0000000D"), getTagSet("RCFellow")
            ),
            new Resident(
                    new Name("Joshua Li"), new Phone("91670290"), new Email("j0shli@gmail.com"), new Room("03-09"),
                    new Gender("M"), new House("N"), new MatricNumber("A0000000E"), getTagSet("PublicityHead")
            ),
        };
    }

    public static Booking[] getSampleHallBookings() {
        return new Booking[] {
                new RecurrentBooking(
                        new VenueName("Hall"), getSampleResidents()[0], new HourPeriod("8-11"),
                        new Day("MON")
                ),
                new RecurrentBooking(
                        new VenueName("Hall"), getSampleResidents()[5], new HourPeriod("13-14"),
                        new Day("MON")
                ),
                new RecurrentBooking(
                        new VenueName("Hall"), getSampleResidents()[4], new HourPeriod("20-21"),
                        new Day("MON")
                ),
                new RecurrentBooking(
                        new VenueName("Hall"), getSampleResidents()[0], new HourPeriod("11-12"),
                        new Day("TUE")
                ),
                new RecurrentBooking(
                        new VenueName("Hall"), getSampleResidents()[1], new HourPeriod("15-18"),
                        new Day("TUE")
                ),
                new RecurrentBooking(
                        new VenueName("Hall"), getSampleResidents()[3], new HourPeriod("9-11"),
                        new Day("WED")
                ),
                new RecurrentBooking(
                        new VenueName("Hall"), getSampleResidents()[0], new HourPeriod("16-19"),
                        new Day("WED")
                ),
                new RecurrentBooking(
                        new VenueName("Hall"), getSampleResidents()[2], new HourPeriod("18-20"),
                        new Day("THU")
                ),
                new RecurrentBooking(
                        new VenueName("Hall"), getSampleResidents()[1], new HourPeriod("9-13"),
                        new Day("THU")
                ),
                new RecurrentBooking(
                        new VenueName("Hall"), getSampleResidents()[4], new HourPeriod("12-15"),
                        new Day("SAT")
                ),
                new RecurrentBooking(
                        new VenueName("Hall"), getSampleResidents()[3], new HourPeriod("8-11"),
                        new Day("SUN")
                ),
                new RecurrentBooking(
                        new VenueName("Hall"), getSampleResidents()[1], new HourPeriod("19-22"),
                        new Day("SUN")
                ),
        };
    }

    public static Booking[] getSampleMeetingBookings() {
        return new Booking[] {
                new RecurrentBooking(
                        new VenueName("Meeting Room"), getSampleResidents()[5], new HourPeriod("13-16"),
                        new Day("MON")
                ),
                new RecurrentBooking(
                        new VenueName("Meeting Room"), getSampleResidents()[4], new HourPeriod("18-21"),
                        new Day("MON")
                ),
                new RecurrentBooking(
                        new VenueName("Meeting Room"), getSampleResidents()[0], new HourPeriod("11-12"),
                        new Day("TUE")
                ),
                new RecurrentBooking(
                        new VenueName("Meeting Room"), getSampleResidents()[1], new HourPeriod("15-18"),
                        new Day("TUE")
                ),
                new RecurrentBooking(
                        new VenueName("Meeting Room"), getSampleResidents()[3], new HourPeriod("9-11"),
                        new Day("WED")
                ),
                new RecurrentBooking(
                        new VenueName("Meeting Room"), getSampleResidents()[0], new HourPeriod("13-16"),
                        new Day("WED")
                ),
                new RecurrentBooking(
                        new VenueName("Meeting Room"), getSampleResidents()[3], new HourPeriod("18-20"),
                        new Day("THU")
                ),
                new RecurrentBooking(
                        new VenueName("Meeting Room"), getSampleResidents()[2], new HourPeriod("11-13"),
                        new Day("THU")
                ),
                new RecurrentBooking(
                        new VenueName("Meeting Room"), getSampleResidents()[5], new HourPeriod("16-20"),
                        new Day("FRI")
                ),
                new RecurrentBooking(
                        new VenueName("Meeting Room"), getSampleResidents()[4], new HourPeriod("12-15"),
                        new Day("SAT")
                ),
                new RecurrentBooking(
                        new VenueName("Meeting Room"), getSampleResidents()[0], new HourPeriod("8-10"),
                        new Day("SUN")
                ),
                new RecurrentBooking(
                        new VenueName("Meeting Room"), getSampleResidents()[1], new HourPeriod("17-22"),
                        new Day("SUN")
                ),
        };
    }

    public static ReadOnlyResidentBook getSampleResidentBook() {
        ResidentBook sampleRb = new ResidentBook();
        for (Resident sampleResident : getSampleResidents()) {
            sampleRb.addResident(sampleResident);
        }
        return sampleRb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    public static Venue[] getSampleVenues() {
        Venue hall = new Venue(new VenueName("Hall"));
        Venue meetingRoom = new Venue(new VenueName("Meeting Room"));
        for (Booking sampleBooking : getSampleHallBookings()) {
            hall.addBooking(sampleBooking);
        }
        for (Booking sampleBooking : getSampleMeetingBookings()) {
            meetingRoom.addBooking(sampleBooking);
        }
        Venue[] sampleVenue = new Venue[] {hall, meetingRoom};
        return sampleVenue;

    }

    public static ReadOnlyVenueBook getSampleVenueBook() {
        VenueBook sampleVb = new VenueBook();
        for (Venue sampleVenue : getSampleVenues()) {
            sampleVb.addVenue(sampleVenue);
        }
        return sampleVb;
    }

}
