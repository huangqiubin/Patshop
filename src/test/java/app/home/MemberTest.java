package app.home;

import com.hqb.patshop.PatshopApplication;
import com.hqb.patshop.mbg.dao.UmsMemberMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {PatshopApplication.class})
public class MemberTest {

    @Autowired
    private UmsMemberMapper memberMapper;

    @Test
    public void testMemberInfo() {
        System.out.println(memberMapper.selectMember(12));
    }
}
