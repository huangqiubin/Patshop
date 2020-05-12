package app.home;

import com.hqb.patshop.PatshopApplication;
import com.hqb.patshop.app.home.service.ActivityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {PatshopApplication.class})
public class ActivityTest {

    @Autowired
    ActivityService activityService;

    @Test
    public void testActivityContent(){
        System.out.println(activityService.getSignInModel("18378583473"));
    }

    @Test
    public void testSignIn(){
        System.out.println(activityService.getSignInModel("18378583473"));
    }
}
