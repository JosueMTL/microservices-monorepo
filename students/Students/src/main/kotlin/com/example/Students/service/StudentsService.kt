package com.example.Students.service

import com.example.Students.model.Students
import com.example.Students.repository.StudentsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class StudentsService {
    @Autowired
    lateinit var studentsRepository: StudentsRepository

    fun list ():List<Students>{
        return studentsRepository.findAll()
    }

    fun listOne (id: Long): Optional<Students> {
        return studentsRepository.findById(id)
    }

    //PETICIONES POST
    //clase service
    fun save(students: Students): Students{
        try{
            return studentsRepository.save(students)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    //clase service -Petición put
    fun update(students: Students): Students{
        try {
            studentsRepository.findById(students.id)
                ?: throw Exception("ID no existe")

            return studentsRepository.save(students)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    //clase service - Delete by id
    fun delete (id: Long?):Boolean?{
        try{
            val response = studentsRepository.findById(id)
                ?: throw Exception("ID no existe")
            studentsRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}