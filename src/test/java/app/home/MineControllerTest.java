package app.home;

import com.hqb.patshop.PatshopApplication;
import com.hqb.patshop.app.home.service.impl.MineServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {PatshopApplication.class})
public class MineControllerTest {

    @Autowired
    private MineServiceImpl mineService;

    @Test
    public void testBidSale() {
        System.out.println(mineService.bidSaleContent("984133573"));
    }

}
