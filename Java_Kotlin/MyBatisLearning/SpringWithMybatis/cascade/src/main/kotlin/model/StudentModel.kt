package model

import enums.GenderEnum

open class StudentModel {
    private var id:Int? = null
    private var name:String? = null
    private var gender:GenderEnum? = null
    private var cardId:Int? = null
    private var note:String? = null
    private var studentSelfcard:StudentSelfcardModel? = null
    private var studentLectureList:List<StudentLectureModel>? = null
    override fun toString(): String {
        return "StudentModel(id=$id, name=$name, gender=$gender, cardId=$cardId, note=$note, studentSelfcard=$studentSelfcard, studentLectureList=$studentLectureList)"
    }

}