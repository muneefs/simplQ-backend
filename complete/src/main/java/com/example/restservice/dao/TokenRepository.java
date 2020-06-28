package com.example.restservice.dao;

import com.example.restservice.constants.TokenStatus;
import java.util.stream.Stream;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface TokenRepository extends CrudRepository<Token, String> {

  @Modifying
  @Query("update Token t set t.status = :status where t.tokenId = :tokenId")
  void setUserStatusById(@Param("status") TokenStatus status, @Param("tokenId") String tokenId);

  Stream<Token> findByOwnerId(String ownerId);
}
