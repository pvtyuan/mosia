package io.mosia.service;

import io.mosia.entity.Realm;
import io.mosia.repository.RealmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealmService {

    private final RealmRepository realmRepository;

    @Autowired
    public RealmService(RealmRepository realmRepository) {
        this.realmRepository = realmRepository;
    }

    public void add(String name) {
        Realm realm = new Realm();
        realm.setName(name);
        realmRepository.save(realm);
    }

    public Realm get(String name) {
        return realmRepository.findByName(name);
    }
}
