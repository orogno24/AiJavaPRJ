package kopo.poly;

import kopo.poly.dto.NlpDTO;
import kopo.poly.dto.OcrDTO;
import kopo.poly.service.INlpService;
import kopo.poly.service.IOcrService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class AiJavaPrjApplication implements CommandLineRunner {

   private final IOcrService ocrService;
   private final INlpService nlpService;

    public static void main(String[] args) {

        SpringApplication.run(AiJavaPrjApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("자바 프로그래밍 시작!!");

        String filePath = "image";
        String fileName = "sample01.jpg";

        OcrDTO pDTO = new OcrDTO();

        pDTO.setFilePath(filePath);
        pDTO.setFileName(fileName);

        OcrDTO rDTO = ocrService.getReadforImageText(pDTO);

        String result = rDTO.getResult();

        log.info("인식된 문자열");
        log.info(result);

        log.info("자바 프로그래밍 종료!!");

        log.info("----------------------------------------------------------");
        NlpDTO nlpDTO = nlpService.getPlainText(result);
        log.info("형태소별 품사 분석 결과 : " + nlpDTO.getResult());

        //명사 추출 결과
        nlpDTO = nlpService.getNouns(result);

        List<String> nonus = nlpDTO.getNouns();

        Set<String> distinct = new HashSet<>(nonus);

        log.info("중복 제거 수행 전 단어 수 : " + nonus.size());
        log.info("중복 제거 수행 후 단어 수 : " + distinct.size());

        Map<String, Integer> rMap = new HashMap<>();

        for (String s : distinct) {
            int count = Collections.frequency(nonus, s);
            rMap.put(s, count);

            log.info(s + " : " + count);
        }

        List<Map.Entry<String, Integer>> sortResult = new LinkedList<>(rMap.entrySet());

        Collections.sort(sortResult, (o1,o2) -> o2.getValue().compareTo(o1.getValue()));

        log.info("가장 많이 사용된 단어는? : " + sortResult);

        log.info("자바 프로그래밍 종료!!");
    }
}

