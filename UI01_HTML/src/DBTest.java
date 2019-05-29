import java.util.List;

import com.biz.EmpBiz;
import com.biz.EmpBizImpl;
import com.dto.EmpDto;

public class DBTest {
	public static void main(String[] args) {
		EmpBiz biz = new EmpBizImpl();
		List<EmpDto> selectList = biz.selectList();
		for(EmpDto dto : selectList) {
			System.out.println(dto);
		}
	}
}
