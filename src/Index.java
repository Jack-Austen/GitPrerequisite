
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Index {
	public Index()
	{
		
	}
	
	public void initialize()
	{
		try {
	         File empty = new File("index.txt");
	         empty.createNewFile();
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
		
		File theDir = new File("/path/objects");
		if (!theDir.exists())
		{
		    theDir.mkdirs();
		}
	}
	
	
	public void addBlobs(String fileName) throws FileNotFoundException, NoSuchAlgorithmException, IOException
	{
		Blob blobby = new Blob (fileName); //THINK THIS IS WRONG GO TO THEISS
	}
	
	public static void main (String [] args)
	{
		Index test1 = new Index();
		
	}
}
