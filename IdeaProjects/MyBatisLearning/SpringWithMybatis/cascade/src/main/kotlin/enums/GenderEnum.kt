package enums

enum class GenderEnum(val id:Int, val gender:String) {
    MALE(1,"男"),
    FEMALE(2,"女");

    companion object {
        fun getGender(id: Int): GenderEnum {
            return if (id == MALE.id) MALE else FEMALE
        }
    }


}