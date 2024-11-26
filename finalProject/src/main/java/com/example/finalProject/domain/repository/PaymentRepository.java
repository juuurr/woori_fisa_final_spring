package com.example.finalProject.domain.repository;

import com.example.finalProject.domain.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentEntity, String> {
    // 특정 날짜 범위의 결제 내역 조회
    @Query("SELECT p FROM PaymentEntity p WHERE p.datetime >= :start AND p.datetime < :end")
    List<PaymentEntity> findByDatetime(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}