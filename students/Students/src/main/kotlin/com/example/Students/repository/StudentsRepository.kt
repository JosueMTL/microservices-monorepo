package com.example.Students.repository

import com.example.Students.model.Students
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentsRepository : JpaRepository<Students, Long?> {
    fun findById(id: Long?): Students?
}