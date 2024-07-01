package com.example.Grades.service

import com.example.Grades.model.Grades
import com.example.Grades.repository.GradesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class GradesService {
    @Autowired
    lateinit var gradesRepository: GradesRepository

    fun list ():List<Grades>{
        return gradesRepository.findAll()
    }

    fun listOne (id: Long): Optional<Grades> {
        return gradesRepository.findById(id)
    }

    //PETICIONES POST
    //clase service
    fun save(grades: Grades): Grades{
        try{
            return gradesRepository.save(grades)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    //clase service -Petición put
    fun update(grades: Grades): Grades{
        try {
            gradesRepository.findById(grades.id)
                ?: throw Exception("ID no existe")

            return gradesRepository.save(grades)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    //clase service - Delete by id
    fun delete (id: Long?):Boolean?{
        try{
            val response = gradesRepository.findById(id)
                ?: throw Exception("ID no existe")
            gradesRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}