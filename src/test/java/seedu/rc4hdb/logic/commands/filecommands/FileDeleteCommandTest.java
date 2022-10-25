package seedu.rc4hdb.logic.commands.filecommands;

import static seedu.rc4hdb.logic.commands.StorageCommandTestUtil.assertCommandFailure;
import static seedu.rc4hdb.logic.commands.StorageCommandTestUtil.assertCommandSuccess;
import static seedu.rc4hdb.logic.commands.StorageCommandTestUtil.assertFileDoesNotExist;
import static seedu.rc4hdb.testutil.Assert.assertThrows;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.rc4hdb.commons.util.FileUtil;
import seedu.rc4hdb.logic.commands.exceptions.CommandException;
import seedu.rc4hdb.storage.DataStorageManager;
import seedu.rc4hdb.storage.Storage;
import seedu.rc4hdb.storage.StorageManager;
import seedu.rc4hdb.storage.StorageStub;
import seedu.rc4hdb.storage.userprefs.JsonUserPrefsStorage;
import seedu.rc4hdb.storage.userprefs.UserPrefsStorage;

/**
 * Unit tests for {@link FileDeleteCommand}.
 */
public class FileDeleteCommandTest {

    @TempDir
    public Path testFolder;

    private Storage storage;

    @BeforeEach
    public void setUp() {
        DataStorageManager dataStorageManager = new DataStorageManager(getTempFilePath("test"));
        JsonUserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(getTempFilePath("testPrefs.json"));
        storage = new StorageManager(dataStorageManager, userPrefsStorage);
    }

    private Path getTempFilePath(String fileName) {
        return testFolder.resolve(fileName);
    }

    @Test
    public void execute_fileExists_fileDeleted() throws Exception {
        DataStorageManager expectedDataStorage = new DataStorageManager(storage.getDataStorageFolderPath());
        UserPrefsStorage expectedUserPrefsStorage = new JsonUserPrefsStorage(storage.getUserPrefsFilePath());
        Storage expectedStorage = new StorageManager(expectedDataStorage, expectedUserPrefsStorage);

        String targetFileName = "AlreadyExists";
        Path targetFilePath = getTempFilePath(targetFileName);
        String expectedMessage = String.format(FileDeleteCommand.MESSAGE_SUCCESS, targetFileName);

        FileDeleteCommand fileDeleteCommand = new FileDeleteCommand(testFolder, targetFileName);
        FileUtil.createDirIfMissing(targetFilePath);

        assertCommandSuccess(fileDeleteCommand, storage, expectedMessage, expectedStorage);
        assertFileDoesNotExist(targetFilePath);
    }

    @Test
    public void execute_currentFile_throwsCommandException() throws Exception {
        String targetFileName = "test";
        Path target = getTempFilePath(targetFileName);

        String expectedMessage = String.format(FileCommand.MESSAGE_TRYING_TO_EXECUTE_ON_CURRENT_FILE, "test");
        FileDeleteCommand fileDeleteCommand = new FileDeleteCommand(testFolder, targetFileName);
        FileUtil.createDirIfMissing(target);

        assertCommandFailure(fileDeleteCommand, storage, expectedMessage);
    }

    @Test
    public void execute_fileDoesNotExist_throwsCommandException() {
        String expectedMessage = String.format(DataStorageManager.MESSAGE_FOLDER_DOES_NOT_EXIST, "DoesNotExist");

        String targetFileName = "DoesNotExist";
        FileDeleteCommand fileDeleteCommand = new FileDeleteCommand(testFolder, targetFileName);

        assertCommandFailure(fileDeleteCommand, storage, expectedMessage);
    }

    @Test
    public void execute_storageThrowsIoException_throwsCommandException() {
        String expectedMessage = String.format(FileDeleteCommand.MESSAGE_FAILED, "deleting");

        String targetFileName = "AlreadyExists";
        FileDeleteCommand fileDeleteCommand = new FileDeleteCommand(testFolder, targetFileName);
        storage = new StorageStubThrowsIoException();

        assertThrows(CommandException.class, expectedMessage, () -> fileDeleteCommand.execute(storage));
    }

    /**
     * A storage stub class that throws an {@code IOException} when the
     * @see #deleteResidentBookFile(Path) method is invoked.
     */
    private static class StorageStubThrowsIoException extends StorageStub {
        public static final IOException DUMMY_IO_EXCEPTION = new IOException("dummy exception");

        @Override
        public void deleteDataFile(Path folderPath) throws IOException {
            throw DUMMY_IO_EXCEPTION;
        }

        @Override
        public Path getDataStorageFolderPath() {
            return null;
        }
    }
}
