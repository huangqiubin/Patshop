package app.home;

import com.hqb.patshop.PatshopApplication;
import com.hqb.patshop.app.home.service.impl.HomeServiceImpl;
import com.hqb.patshop.app.login.service.impl.LoginServiceImpl;
import com.hqb.patshop.common.api.CommonResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {PatshopApplication.class})
public class HomeControllerTest {

    @Autowired
    private HomeServiceImpl homeService;

    @Autowired
    private LoginServiceImpl loginService;

    @Test
    public void testContent() {
        System.out.println(homeService.content());
    }

    @Test
    public void testHomeBidProduct() {
        System.out.println(homeService.homeBidProduct("生活百货"));
    }

    @Test
    public void testProductDetail() {
        System.out.println(homeService.productDetail(28));
    }

    @Test
    public void testHomeHotBid() {
        System.out.println(homeService.homeHotProduct());
    }

    @Test
    public void testLogin(){
        System.out.println(loginService.login(190));
    }
}
