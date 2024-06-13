package model

class FemaleStudentModel(var femaleStudentList:List<MaleStudentHealthModel> = ArrayList()):StudentModel() {
    override fun toString(): String {
        return "FemaleStudentModel(femaleStudentList=$femaleStudentList)"
    }
}