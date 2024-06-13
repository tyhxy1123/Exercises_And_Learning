import mapper.LectureMapper
import mapper.StudentLectureMapper
import mapper.StudentMapper
import model.StudentModel
import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSession
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.junit.Test
import java.util.*

class StudentMapperTest {
    private val sessionFactory: SqlSessionFactory = SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("config/mybatis-config.xml"))
    @Test
    fun getStudent(){
        val session:SqlSession = sessionFactory.openSession(true)
        val mapper:StudentMapper = session.getMapper(StudentMapper::class.java)
        val student:StudentModel = mapper.getStudent(1)
        println(student)
    }

    @Test
    fun getLecture(){
        val session:SqlSession = sessionFactory.openSession(true)
        val mapper:LectureMapper = session.getMapper(LectureMapper::class.java)
        println(mapper.getLecture(1))
    }

    @Test
    fun getStudentLecture(){
        val mapper:StudentLectureMapper = sessionFactory.openSession(true).getMapper(StudentLectureMapper::class.java)
        println(mapper.findStudentLectureByStuId(1))
    }

}