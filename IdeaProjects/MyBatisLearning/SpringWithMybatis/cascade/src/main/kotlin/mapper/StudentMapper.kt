package mapper

import model.StudentModel

interface StudentMapper {
    fun getStudent(id:Int):StudentModel
}