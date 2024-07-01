package com.example.Students.controller

import com.example.Students.model.Students
import com.example.Students.service.StudentsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
@RestController
@RequestMapping("/students")
class StudentsController {
    @Autowired
    lateinit var studentsService: StudentsService
    @GetMapping
    fun list ():List <Students>{
        return studentsService.list()
    }

    @GetMapping("/{id}")
    fun listOne (@PathVariable id: Long) : Optional<Students> {
        return studentsService.listOne(id)
    }

    //Peticiones post - Clase controller
    @PostMapping
    fun save (@RequestBody students: Students): ResponseEntity<Students> {
        return ResponseEntity(studentsService.save(students), HttpStatus.OK)
    }

    //clase controller - Petición Put
    @PutMapping
    fun update (@RequestBody students: Students): ResponseEntity<Students> {
        return ResponseEntity(studentsService.update(students), HttpStatus.OK)
    }

    //clase  controller-Petiicon Patch
    @PatchMapping
    fun updateName (@RequestBody students: Students): ResponseEntity<Students> {
        return ResponseEntity(studentsService.update(students), HttpStatus.OK)
    }

    //clase  controller - Petición Delete
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return studentsService.delete(id)
    }
}