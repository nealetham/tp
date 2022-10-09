package seedu.rc4hdb.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.rc4hdb.model.resident.Resident;
import seedu.rc4hdb.model.resident.ResidentDescriptor;
import seedu.rc4hdb.model.resident.fields.Email;
import seedu.rc4hdb.model.resident.fields.Gender;
import seedu.rc4hdb.model.resident.fields.House;
import seedu.rc4hdb.model.resident.fields.MatricNumber;
import seedu.rc4hdb.model.resident.fields.Name;
import seedu.rc4hdb.model.resident.fields.Phone;
import seedu.rc4hdb.model.resident.fields.Room;
import seedu.rc4hdb.model.tag.Tag;

/**
 * A utility class to help with building ResidentDescriptor objects.
 */
public class ResidentDescriptorBuilder {

    private ResidentDescriptor descriptor;

    public ResidentDescriptorBuilder() {
        descriptor = new ResidentDescriptor();
    }

    public ResidentDescriptorBuilder(ResidentDescriptor descriptor) {
        this.descriptor = new ResidentDescriptor(descriptor);
    }

    /**
     * Returns an {@code ResidentDescriptor} with fields containing {@code resident}'s details
     */
    public ResidentDescriptorBuilder(Resident resident) {
        descriptor = new ResidentDescriptor();
        descriptor.setName(resident.getName());
        descriptor.setPhone(resident.getPhone());
        descriptor.setEmail(resident.getEmail());
        descriptor.setRoom(resident.getRoom());
        descriptor.setGender(resident.getGender());
        descriptor.setHouse(resident.getHouse());
        descriptor.setMatricNumber(resident.getMatricNumber());
        descriptor.setTags(resident.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code ResidentDescriptor} that we are building.
     */
    public ResidentDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code ResidentDescriptor} that we are building.
     */
    public ResidentDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code ResidentDescriptor} that we are building.
     */
    public ResidentDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Room} of the {@code ResidentDescriptor} that we are building.
     */
    public ResidentDescriptorBuilder withRoom(String room) {
        descriptor.setRoom(new Room(room));
        return this;
    }

    /**
     * Sets the {@code Gender} of the {@code ResidentDescriptor} that we are building.
     */
    public ResidentDescriptorBuilder withGender(String gender) {
        descriptor.setGender(new Gender(gender));
        return this;
    }

    /**
     * Sets the {@code House} of the {@code ResidentDescriptor} that we are building.
     */
    public ResidentDescriptorBuilder withHouse(String house) {
        descriptor.setHouse(new House(house));
        return this;
    }

    /**
     * Sets the {@code MatricNumber} of the {@code ResidentDescriptor} that we are building.
     */
    public ResidentDescriptorBuilder withMatricNumber(String matricNumber) {
        descriptor.setMatricNumber(new MatricNumber(matricNumber));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public ResidentDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public ResidentDescriptor build() {
        return descriptor;
    }
}
