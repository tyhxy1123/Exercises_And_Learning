package typeHandler

import enums.GenderEnum
import org.apache.ibatis.type.JdbcType
import org.apache.ibatis.type.TypeHandler
import java.sql.CallableStatement
import java.sql.PreparedStatement
import java.sql.ResultSet

class GenderTypeHandler:TypeHandler<GenderEnum>{
    override fun setParameter(ps: PreparedStatement?, index: Int, genderEnum: GenderEnum?, jdbcType: JdbcType?) {
        ps!!.setInt(index, genderEnum!!.id)
    }

    override fun getResult(rs: ResultSet?, name: String?): GenderEnum {
        val id:Int = rs!!.getInt(name)
        return GenderEnum.getGender(id)
    }

    override fun getResult(rs: ResultSet?, index: Int): GenderEnum {
        val id:Int = rs!!.getInt(index)
        return GenderEnum.getGender(id)
    }

    override fun getResult(cs: CallableStatement?, index: Int): GenderEnum {
        val id:Int = cs!!.getInt(index)
        return GenderEnum.getGender(id)
    }
}