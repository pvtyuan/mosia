package io.mosia.controller;

import io.mosia.entity.Realm;
import io.mosia.repository.RealmRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@AutoConfigureMockMvc
@SpringBootTest
public class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RealmRepository realmRepository;

    @BeforeEach
    public void setup() {
        Realm realm = new Realm();
        realm.setName("a");

        Mockito.when(realmRepository.findByName("a")).thenReturn(realm);
    }

    @Test
    void test() throws Exception {
        mockMvc.perform(get("/test").param("name", "a")).andExpect(content().json("{\"name\":\"a\",\"id\":null}"));
    }
}
