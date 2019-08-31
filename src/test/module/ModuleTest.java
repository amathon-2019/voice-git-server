package module;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.common.util.RandomMo;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = { "classpath*:springmvc/root-context.xml"    , 
					  "classpath*:spring/context-properties.xml" ,
					  "classpath*:spring/context-datasource.xml" ,
					  "classpath*:spring/context-mybatis.xml"    })
public class ModuleTest {
	
	/**
	 * <pre>
	 *   JWT 생성 테스트 
	 *   다음 프로젝트에서는 스프링 시큐리티로..쓰자 꼭
	 * </pre>
	 * @author Dong-Min-Seol
	 * @since  2019. 6. 30.
	 */
	@Ignore
	@Test
	public void randomTest() throws Exception {
		
		long start = System.currentTimeMillis();
		
		String result = RandomMo.getRandomString(10);
		
		long end = System.currentTimeMillis();
		System.out.println(result);
		System.out.println(end-start);
	}
}