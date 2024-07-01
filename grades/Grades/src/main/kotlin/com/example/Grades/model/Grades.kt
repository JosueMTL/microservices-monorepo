package com.example.Grades.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "grades")
class Grades {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long? = null

    @Column(name = "course_name")
    var courseName: String? = null

    var grade: BigDecimal? = null
}