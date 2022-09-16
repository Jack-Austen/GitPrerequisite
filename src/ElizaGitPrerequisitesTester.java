import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.StandardCharsets;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ElizaGitPrerequisitesTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Path p = Paths.get("TestInput.txt");
		Files.writeString(p,"abc",StandardCharsets.ISO_8859_1);
		
		Path p2 = Paths.get("TestInput2.txt");
		Files.writeString(p2,"abc",StandardCharsets.ISO_8859_1);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		File f = new File("TestInput.txt");
		f.delete();
		
		File f2 = new File("TestInput2.txt");
		f2.delete();
	}

	@Test
	void test() throws FileNotFoundException, NoSuchAlgorithmException, IOException {
		Blob bob = new Blob ("TestInput.txt");//makes the blob
		File file1 = new File ("./objects/a9993e364706816aba3e25717850c26c9cd0d89d");
		assertTrue(file1.exists());
		
		Index i = new Index();
		i.initialize();
		File file2 = new File ("index.txt");
		assertTrue(file2.exists());
		
		i.addBlobs("TestInput2.txt");
		File file3 = new File ("./objects/a9993e364706816aba3e25717850c26c9cd0d89d");
		assertTrue (file3.exists());
		
		i.removeBlobs("TestInput2.txt");
		assertFalse (file3.exists());
	}

}
