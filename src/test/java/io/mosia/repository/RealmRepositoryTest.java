package io.mosia.repository;

import io.mosia.entity.Realm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class RealmRepositoryTest {

    @Autowired
    private RealmRepository realmRepository;

    @Test
    public void test() {
        Realm realm = new Realm();
        realm.setName("a");
        realmRepository.save(realm);

        Realm realm1 = realmRepository.findByName("a");

        Assertions.assertEquals("a", realm1.getName());
    }
}
