package model

import java.math.BigDecimal

class StudentLectureModel {
    private var id:Int?=null
    private var studentId:Int?=null
    private var lecture:LectureModel? = null
    private var grade:BigDecimal?=null
    private var note:String?=null
    override fun toString(): String {
        return "StudentLectureModel(id=$id, studentId=$studentId, lecture=$lecture, grade=$grade, note=$note)"
    }

}