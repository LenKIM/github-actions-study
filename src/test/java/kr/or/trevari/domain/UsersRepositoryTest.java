package kr.or.trevari.domain;


import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import kr.or.trevari.DataJdbcConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import static io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseType.POSTGRES;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;
import static org.springframework.test.context.jdbc.SqlMergeMode.MergeMode.MERGE;

@Transactional
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
@AutoConfigureEmbeddedDatabase(type = POSTGRES )
@SpringJUnitConfig(value = { DataJdbcConfig.class , SpringDataJdbcConfig.class} )
@Sql(scripts = "classpath:schema.sql")
class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    @Rollback
    @SqlMergeMode(MERGE)
    @Sql(statements = {
            "INSERT INTO \"users\" (\"id\",\"user_name\") VALUES (999,'AAAA');",
            "INSERT INTO \"users\" (\"id\",\"user_name\") VALUES (998,'BBBB');",
            "INSERT INTO \"users\" (\"id\",\"user_name\") VALUES (997,'CCCC');"
    })
    void saveAndFind() {

        Users users = Users.of("kim");
        Users save = usersRepository.save(users);
        Users found = usersRepository.findById(save.getId()).get();

        Assertions.assertThat(found.getUserName()).isEqualTo(users.getUserName());
    }

    @Test
    @Rollback
    @SqlMergeMode(MERGE)
    @Sql(statements = {
            "INSERT INTO \"users\" (\"id\",\"user_name\") VALUES (999,'AAAA');",
            "INSERT INTO \"users\" (\"id\",\"user_name\") VALUES (998,'BBBB');",
            "INSERT INTO \"users\" (\"id\",\"user_name\") VALUES (997,'CCCC');"
    })
    void saveAndFind2() {

        Users users = Users.of("kim");
        Users save = usersRepository.save(users);
        Users found = usersRepository.findById(save.getId()).get();

        Assertions.assertThat(found.getUserName()).isEqualTo(users.getUserName());
    }
}
