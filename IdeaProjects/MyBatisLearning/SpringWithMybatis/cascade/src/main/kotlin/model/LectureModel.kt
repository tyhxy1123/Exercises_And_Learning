package model

class LectureModel {
    private var id:Int?=null
    private var lectureName:String?=null
    private var note:String? = null
    override fun toString(): String {
        return "LectureModel(id=$id, lectureName=$lectureName, note=$note)"
    }

}