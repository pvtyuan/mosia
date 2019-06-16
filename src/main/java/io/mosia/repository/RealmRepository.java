package io.mosia.repository;

import io.mosia.entity.Realm;
import org.springframework.data.repository.CrudRepository;

public interface RealmRepository extends CrudRepository<Realm, String> {

    Realm findByName(String name);
}
