package chatbot;


import org.springframework.stereotype.Component;

@Component
public class ApiClient {
	public String callGpt(String sysMsg, String userMsg) {
		 // 실제 GPT API 호출 시 사용될 JSON 포맷 구성 및 응답 수신 로직 필요
        return "{\"search_keyword\": \"정보처리기사 시험 일정 site:q-net.or.kr\"}";
	}
}



