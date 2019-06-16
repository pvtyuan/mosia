package io.mosia.service;

import io.mosia.entity.Realm;
import io.mosia.repository.RealmRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RealmServiceTest {

    @MockBean
    private RealmRepository realmRepository;

    @BeforeEach
    public void setup() {
        Realm realm = new Realm();
        realm.setName("a");

        Mockito.when(realmRepository.findByName(realm.getName())).thenReturn(realm);
    }

    @Test
    public void test() {
        String name = "b";
        Realm realm = realmRepository.findByName(name);

        Assertions.assertNotNull(realm);
        Assertions.assertEquals(name, realm.getName());
    }

}
