package chatbot;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ChatbotUtil {
	public String buildSystemMsg(String convTopic, String convSubTopic, String userSpecStr) {
        if ("Schedule".equalsIgnoreCase(convSubTopic)) {
            return "당신은 진로 상담 AI입니다. 사용자가 자격증/시험 일정에 대해 질문할 경우, " +
                   "자격증명과 관련된 검색 키워드를 생성하고, 가능한 경우 공식 사이트 URL도 함께 반환하세요.";
        }
        return "";
        
	}
	
	 public String buildUserMsg(String userMsg, List<ChatMsg> convHistory) {
	        StringBuilder sb = new StringBuilder();
	        for (ChatMsg msg : convHistory) {
	            sb.append("User: ").append(msg.getMsgContent()).append("\n");
	        }
	        sb.append("User: ").append(userMsg);
	        return sb.toString();
	    }
}