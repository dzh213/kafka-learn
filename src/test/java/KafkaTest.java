import com.dh.kafka.KafkaLearnMain;
import com.dh.kafka.service.KafkaProduct;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by donghao on 2019/12/15.
 */
@SpringBootTest(classes = KafkaLearnMain.class)
@RunWith(SpringRunner.class)
@Slf4j
public class KafkaTest {

    @Autowired
    private KafkaProduct kafkaProduct;

    @Test
    public void testKafka() {
        kafkaProduct.sendMessage();
    }
}
