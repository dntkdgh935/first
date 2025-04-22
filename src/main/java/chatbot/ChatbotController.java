package chatbot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatbot")
public class ChatbotController {

	@Autowired
	private ChatbotService chatbotService;
	@Autowired
	private ChatbotHandler chatbotHandler;
	
	 @PostMapping("/ask")
	    public ResponseEntity<List<SearchResult>> ask(@RequestBody ChatMsg userMsg) {
	        // 1. GPT 호출 및 응답 수신
	        String gptResponse = chatbotHandler.sendChatbotRequest(
	            userMsg, userMsg.getConvTopic(), userMsg.getConvSubTopic(), "");

	        // 2. 일정 관련 SerpAPI 호출 및 결과 정리
	        List<SearchResult> results = chatbotHandler.handleScheduleWithSerpApi(gptResponse);

	        // 3. 대화 이력 저장
	        chatbotService.insertChatMsg(userMsg);

	        return ResponseEntity.ok(results);
	    }

}
