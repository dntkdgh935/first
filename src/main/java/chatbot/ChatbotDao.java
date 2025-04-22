package chatbot;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatbotDao {
	void insertChatMsg(ChatMsg msg);
}
