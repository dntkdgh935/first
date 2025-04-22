package chatbot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SerpApiClient {
    public List<SearchResult> search(String keyword) {
        // 실제 SerpAPI 검색 호출 및 결과 파싱 (title, link, snippet)
        List<SearchResult> results = new ArrayList<>();
        results.add(new SearchResult(
            "정보처리기사 시험일정 안내 - Q-Net",
            "https://www.q-net.or.kr/crf005.do?id=crf00505&jmCd=1234",
            "한국산업인력공단 자격시험 일정 안내 페이지입니다."
        ));
        results.add(new SearchResult(
            "2025 자격증 시험일정 총정리 - 해커스",
            "https://www.hackers.com/cert/schedule",
            "자격증별 최신 일정표 및 접수기간 모음"
        ));
        return results;
    }
}
