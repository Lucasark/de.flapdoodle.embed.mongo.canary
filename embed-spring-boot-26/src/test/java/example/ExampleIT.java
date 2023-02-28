package example;

import com.mongodb.assertions.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureMockMvc
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
@ExtendWith(SpringExtension.class)
class ExampleIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void example(@Autowired final MongoTemplate mongoTemplate) throws Exception {
        Assertions.assertThat(mongoTemplate.getDb()).isNotNull();
        mockMvc.perform(MockMvcRequestBuilders.get("https://www.google.com.br")).andDo(print());
    }
}
