package mapper

import model.MaleStudentHealthModel

interface MaleStudentHealthMapper {
    fun findMaleStudentHealthById(id: Int): MaleStudentHealthModel
}