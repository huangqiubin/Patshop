package app.home;

import com.hqb.patshop.PatshopApplication;
import com.hqb.patshop.app.home.service.impl.HomeServiceImpl;
import com.hqb.patshop.app.login.service.impl.LoginServiceImpl;
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
        System.out.println(homeService.productDetail(28).getPmsProductModel());
    }

    @Test
    public void testHomeHotBid() {
        System.out.println(homeService.homeHotProduct());
    }

    @Test
    public void testLogin() {
        System.out.println(loginService.login(190));
    }

    @Test
    public void testBid() {
        System.out.println("bid result " + homeService.bidProduct(28, 15.0, "18378583474"));
    }

}
