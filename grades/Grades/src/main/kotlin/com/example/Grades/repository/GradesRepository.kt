package com.example.Grades.repository

import com.example.Grades.model.Grades
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GradesRepository : JpaRepository<Grades, Long?> {
    fun findById(id: Long?): Grades?
}