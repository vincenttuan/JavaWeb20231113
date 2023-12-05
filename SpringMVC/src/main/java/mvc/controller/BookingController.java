package mvc.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 會議室預訂系統(Web API)
 * 假設您正在為一家公司開發一個會議室預訂系統。您需要實現一個控制器，該控制器可以處理會議室的預訂請求、取消請求以及查詢當前預訂狀態。
 * 
 * 功能要求：
 * -----------------------------------------------------------------------------------------------
 * 1.預訂會議室：
 * 路徑：/booking/bookRoom
 * 參數：會議室ID (roomId), 使用者名稱 (name), 預訂日期 (date)
 * 返回：預訂成功(會得到預約號碼 bookingId)或失敗的消息
 * -----------------------------------------------------------------------------------------------
 * 範例：http://localhost:8080/SpringMVC/mvc/booking/bookRoom?roomId=101&name=Tom&date=2023-12-04
 * 範例：http://localhost:8080/SpringMVC/mvc/booking/bookRoom?roomId=102&name=Mary&date=2023-12-05
 * 範例：http://localhost:8080/SpringMVC/mvc/booking/bookRoom?roomId=201&name=Jack&date=2023-12-06
 * 範例：http://localhost:8080/SpringMVC/mvc/booking/bookRoom?roomId=403&name=Rose&date=2023-12-06
 * 
 * -----------------------------------------------------------------------------------------------
 * 2.取消預訂：
 * 路徑：/booking/cancelBooking/{bookingId}
 * 參數：預訂ID (bookingId)
 * 返回：取消成功或失敗的消息
 * -----------------------------------------------------------------------------------------------
 * 範例：http://localhost:8080/SpringMVC/mvc/booking/cancelBooking/1
 * 
 * -----------------------------------------------------------------------------------------------
 * 3.查看所有預訂：
 * 路徑：/booking/viewBookings
 * 返回：當前所有預訂的列表（可以簡單地返回字符串格式的預訂詳情）
 * -----------------------------------------------------------------------------------------------
 * 範例：http://localhost:8080/SpringMVC/mvc/booking/viewBookings
 * */

public class BookingController {
	/**
	 * 預約紀錄
	 +-----------+--------+-------+------------+
	 | bookingId | roomId | name  |    date    |
	 +-----------+--------+-------+------------+
	 |     1     |  101   |  Tom  | 2023-12-04 |
	 |     2     |  102   |  Mary | 2023-12-05 |
	 +-----------+--------+-------+------------+
	*/
	private static List<Map<String, Object>> bookings = new CopyOnWriteArrayList<>();
	
	// 預約號碼: 每次可用 bookingIdCount.incrementAndGet() 來取得
	private AtomicInteger bookingIdCount = new AtomicInteger(0);
	
}
