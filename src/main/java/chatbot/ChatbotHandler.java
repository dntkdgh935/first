package chatbot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ChatbotHandler {
	@Autowired
	private ChatbotUtil chatbotUtil;
	@Autowired
    private ApiClient apiClient;
    @Autowired
    private SerpApiClient serpApiClient;

    public String sendChatbotRequest(ChatMsg userMsg, String convTopic, String convSubTopic, String userSpecStr) {
        String sysMsg = chatbotUtil.buildSystemMsg(convTopic, convSubTopic, userSpecStr);
        String convContext = chatbotUtil.buildUserMsg(userMsg.getMsgContent(), new ArrayList<>());
        return apiClient.callGpt(sysMsg, convContext);
    }

    public List<SearchResult> handleScheduleWithSerpApi(String gptResponse) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(gptResponse);
            String keyword = root.path("search_keyword").asText();
            return serpApiClient.search(keyword);
        } catch (Exception e) {
            e.printStackTrace();
            return List.of(new SearchResult("일정 검색 실패", "", "GPT 응답 처리 중 오류 발생"));
        }
    }

}
