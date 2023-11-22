package com.bamdoliro.teampage.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {
    @Query(value = "SELECT position, GROUP_CONCAT(DISTINCT generation ORDER BY generation SEPARATOR ',') AS generations FROM member GROUP BY position ORDER BY position", nativeQuery = true)
    List<Object[]> getPositionGenerations();
}
