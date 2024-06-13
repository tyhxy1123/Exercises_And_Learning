package mapper

import model.StudentLectureModel

interface StudentLectureMapper {
    fun findStudentLectureByStuId(id:Int):StudentLectureModel
}