package mapper

import model.StudentSelfcardModel

interface StudentSelfcardMapper {
    fun findStudentSelfcardByStudentId(id:Int):StudentSelfcardModel
}