import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Author: ChengXiaoXiao
 * @Date: 2020/6/23 20:21
 */
public class ImageTest {


	@Test
	public void test01() throws IOException {

		URL resource = this.getClass().getResource("/");
		System.out.println(resource);

	}
}
