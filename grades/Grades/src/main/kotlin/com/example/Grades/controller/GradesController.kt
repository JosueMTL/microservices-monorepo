package com.example.Grades.controller

import com.example.Grades.model.Grades
import com.example.Grades.service.GradesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
@RestController
@RequestMapping("/grades")
class GradesController {
    @Autowired
    lateinit var gradesService: GradesService
    @GetMapping
    fun list ():List <Grades>{
        return gradesService.list()
    }

    @GetMapping("/{id}")
    fun listOne (@PathVariable id: Long) : Optional<Grades> {
        return gradesService.listOne(id)
    }

    //Peticiones post - Clase controller
    @PostMapping
    fun save (@RequestBody grades: Grades): ResponseEntity<Grades> {
        return ResponseEntity(gradesService.save(grades), HttpStatus.OK)
    }

    //clase controller - Petición Put
    @PutMapping
    fun update (@RequestBody grades: Grades): ResponseEntity<Grades> {
        return ResponseEntity(gradesService.update(grades), HttpStatus.OK)
    }

    //clase  controller-Petiicon Patch
    @PatchMapping
    fun updateName (@RequestBody grades: Grades): ResponseEntity<Grades> {
        return ResponseEntity(gradesService.update(grades), HttpStatus.OK)
    }

    //clase  controller - Petición Delete
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return gradesService.delete(id)
    }
}