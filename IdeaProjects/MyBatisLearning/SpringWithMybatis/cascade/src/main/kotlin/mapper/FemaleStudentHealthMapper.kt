package mapper

import model.FemaleStudentHealthModel

interface FemaleStudentHealthMapper {
    fun findFemaleStudentHealthById(id: Int): FemaleStudentHealthModel
}