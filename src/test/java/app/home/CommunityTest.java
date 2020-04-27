package app.home;

import com.hqb.patshop.PatshopApplication;
import com.hqb.patshop.app.home.dto.TopicPostDTO;
import com.hqb.patshop.app.home.service.CommunityService;
import com.hqb.patshop.mbg.dao.SmsSecTopicDao;
import com.hqb.patshop.mbg.dao.SmsTopicDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {PatshopApplication.class})
public class CommunityTest {

    @Autowired
    private CommunityService communityService;

    @Autowired
    SmsTopicDao smsTopicDao;

    @Autowired
    SmsSecTopicDao smsSecTopicDao;

    @Test
    public void testHotTopic() {
//        CommunityResult communityResult = communityService.hotTopicList(1);
//        System.out.println(communityResult.getTopicList().size());
//        System.out.println(communityResult.getTopicList());
        System.out.println(smsTopicDao.selectAllByHotTopic(1));

    }

    @Test
    public void testPostTopic() {
        TopicPostDTO topicPostDTO = new TopicPostDTO();
        topicPostDTO.setTopicContent("测试测试");
        topicPostDTO.setTopicSecType("我买过的惊喜好物");
        topicPostDTO.setTopicType("游戏手办");
        System.out.println(communityService.postTopic(topicPostDTO));
    }

    @Test
    public void testSelectIdByTopicName() {
        System.out.println("我买过的惊喜好物" + smsSecTopicDao.selectPrimaryKeyBySecTopicName("我买过的惊喜好物"));
    }
}
