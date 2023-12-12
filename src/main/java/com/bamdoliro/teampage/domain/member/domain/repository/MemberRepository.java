package com.bamdoliro.teampage.domain.member.domain.repository;

import com.bamdoliro.teampage.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {
    @Query(value = "SELECT position, GROUP_CONCAT(DISTINCT generation ORDER BY generation SEPARATOR ',') AS generations FROM member GROUP BY position ORDER BY position", nativeQuery = true)
    List<Object[]> getPositionGenerations();

    @Query("SELECt m FROM Member m ORDER BY m.generation ASC")
    List<Member> findAllAsc();

    @Transactional
    @Modifying
    @Query(value = "truncate Member", nativeQuery = true)
    void cleanTable();
}
