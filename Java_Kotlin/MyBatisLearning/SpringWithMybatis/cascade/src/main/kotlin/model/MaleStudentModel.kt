package model

class MaleStudentModel(var maleStudentHealthList:List<MaleStudentHealthModel> = ArrayList()):StudentModel() {
    override fun toString(): String {
        return "MaleStudentModel(maleStudentHealthList=$maleStudentHealthList)"
    }
}