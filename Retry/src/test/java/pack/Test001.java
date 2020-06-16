package pack;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test001 {

	@Test(priority=1)
	public void Test1()
	{
		Assert.assertEquals(true, false);
		//Assert.assertTrue(false);
	}

	@Test(priority=2)
	public void Test2()
	{
		Assert.assertTrue(false);
	}
}