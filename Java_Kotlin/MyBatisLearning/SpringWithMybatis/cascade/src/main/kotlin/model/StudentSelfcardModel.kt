package model

import java.sql.Date

class StudentSelfcardModel {
    private var id:Int? = null
    private var studentId:Int? = null
    private var native:String? = null
    private var issueDate:Date? = null
    private var endDate:Date? = null
    private var note:String? = null
    override fun toString(): String {
        return "StudentSelfcardModel(id=$id, studentId=$studentId, native=$native, issueDate=$issueDate, endDate=$endDate, note=$note)"
    }


}