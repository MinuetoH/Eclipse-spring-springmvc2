package dao.mapper;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import logic.User;

public interface UserMapper {

	@Insert("insert into useraccount "
				+ " (userid, password, username, phoneno, postcode,"
				+ " address, email, birthday)"
				+ " values(#{userid}, #{password}, #{username}, #{phoneno}, #{postcode},"
				+ " #{address}, #{email}, #{birthday})")
	void insert(User user);

	@Select("select * from useraccount where userid=#{userid}")
	User selectOne(Map<String, Object> param);

	@Update("update useraccount set username=#{username}, "
				+ "birthday=#{birthday}, phoneno=#{phoneno}, postcode=#{postcode}, "
				+ "address=#{address}, email=#{email} where userid=3{userid}")
	void update(@Valid User user);

	@Delete("delete from useraccount where userid=#{userid}")
	void delete(Map<String, Object> param);

	@Update("update useraccount set password=#{password} where userid=#{userid}")
	void chgpass(Map<String, Object> param);

	@Select({"<script>",
		"select ${col} from useraccount "
		+ " where email=#{email} and phoneno=#{phoneno}",
		"<if test='userid != null'> and userid=#{userid}</if>",
		"</script>"})
	String search(Map<String, Object> param);

	@Select("select * from useraccount")
	List<User> list();
	
	

}
