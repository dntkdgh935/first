package chatbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatbotService {
	@Autowired
	private ChatbotDao chatbotDao;
	
	public void insertChatMsg(ChatMsg msg) {
		chatbotDao.insertChatMsg(msg);
	}
}
