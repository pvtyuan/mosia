package io.mosia.controller;

import io.mosia.entity.Realm;
import io.mosia.service.RealmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final RealmService realmService;

    public AuthenticationController(RealmService realmService) {
        this.realmService = realmService;
    }

    @GetMapping("test")
    public Realm test(@RequestParam String name) {
        Realm realm = realmService.get(name);
        return realm;
    }
}
