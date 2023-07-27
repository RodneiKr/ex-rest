package org.kr.exrest.festa;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FestaRepository extends MongoRepository<FestaDocument, String> {
}
