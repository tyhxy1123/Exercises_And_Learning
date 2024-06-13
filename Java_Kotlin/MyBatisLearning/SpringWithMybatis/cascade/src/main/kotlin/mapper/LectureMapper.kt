package mapper

import model.LectureModel

interface LectureMapper {
    fun getLecture(id: Int): LectureModel
}