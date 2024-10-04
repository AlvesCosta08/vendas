package com.vendas.vendas.repository;

import com.vendas.vendas.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {

    Optional<UserInfo> findByUsername(String username);

    boolean existsByUsername(String username);
}
