package com.example.kotlin.dao

import com.example.kotlin.domain.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerDao: JpaRepository<Customer, Long>