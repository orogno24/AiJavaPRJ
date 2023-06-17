package kopo.poly;

import kopo.poly.dto.StudentDTO;
import kopo.poly.service.INlpService;
import kopo.poly.service.IOcrService;
import kopo.poly.service.IStudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor // 2. 여기 빈칸뚫어놓고 쓰라고 합니다
@SpringBootApplication
public class AiJavaPrjApplication implements CommandLineRunner {

   private final IOcrService ocrService;
   private final INlpService nlpService;
   private final IStudentService studentService; //여기도 빈칸뚫어놓음

    public static void main(String[] args) {

        SpringApplication.run(AiJavaPrjApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("자바 프로그래밍 시작!!");

//        String filePath = "image";
//        String fileName = "sample01.jpg";
//
//        OcrDTO pDTO = new OcrDTO();
//
//        pDTO.setFilePath(filePath);
//        pDTO.setFileName(fileName);
//
//        OcrDTO rDTO = ocrService.getReadforImageText(pDTO);
//
//        String result = rDTO.getResult();
//
//        log.info("인식된 문자열");
//        log.info(result);
//
//        log.info("자바 프로그래밍 종료!!");
//
//        log.info("----------------------------------------------------------");
//        NlpDTO nlpDTO = nlpService.getPlainText(result);
//        log.info("형태소별 품사 분석 결과 : " + nlpDTO.getResult());
//
//        //명사 추출 결과
//        nlpDTO = nlpService.getNouns(result);
//
//        List<String> nonus = nlpDTO.getNouns();
//
//        Set<String> distinct = new HashSet<>(nonus);
//
//        log.info("중복 제거 수행 전 단어 수 : " + nonus.size());
//        log.info("중복 제거 수행 후 단어 수 : " + distinct.size());
//
//        Map<String, Integer> rMap = new HashMap<>();
//
//        for (String s : distinct) {
//            int count = Collections.frequency(nonus, s);
//            rMap.put(s, count);
//
//            log.info(s + " : " + count);
//        }
//
//        List<Map.Entry<String, Integer>> sortResult = new LinkedList<>(rMap.entrySet());
//
//        Collections.sort(sortResult, (o1,o2) -> o2.getValue().compareTo(o1.getValue()));
//
//        log.info("가장 많이 사용된 단어는? : " + sortResult);
//
        StudentDTO pDTO; // 학생 등록, 수정, 삭제에 활용될 DTO
        List<StudentDTO> rList; // DB 조회 결과를 표현

        //학생 등록하기
        pDTO = new StudentDTO();

//        pDTO.setUserId("hglee67");
//        pDTO.setUserName("이협건");
//        pDTO.setEmail("hglee67@kopo.ac.kr");
//        pDTO.setAddr("서울");
//
//        rList = studentService.insertStudent(pDTO);
//
//        rList.forEach(dto -> {
//            log.info("DB에 저장된 아이디 : " + dto.getUserId());
//            log.info("DB에 저장된 이름 : " + dto.getUserName());
//            log.info("DB에 저장된 이메일 : " + dto.getEmail());
//            log.info("DB에 저장된 주소 : " + dto.getAddr());
//        });


        List<StudentDTO> pList = new ArrayList<>();

        for(int i = 0; i <= 4; i++){
            pDTO = new StudentDTO();
            pDTO.setUserId("A" + i);
            pDTO.setUserName("B" + i);
            pDTO.setEmail("C" + i);
            pDTO.setAddr( i + " ");
            pList.add(pDTO);
        }

        log.info(pList + "");
        rList = studentService.insertStudentList(pList);



        //학생 수정하기
//        pDTO = new StudentDTO();
//
//        pDTO.setUserId("hglee67");
//        pDTO.setUserName("이협건_수정");
//        pDTO.setEmail("hglee67@kopo.ac.kr_수정");
//        pDTO.setAddr("서울_수정");
//
//        rList = studentService.updateStudent(pDTO);

        rList.forEach(dto -> {
            log.info("DB에 저장된 아이디 : " + dto.getUserId());
            log.info("DB에 저장된 이름 : " + dto.getUserName());
            log.info("DB에 저장된 이메일 : " + dto.getEmail());
            log.info("DB에 저장된 주소 : " + dto.getAddr());
        });


        //학생 삭제하기
        pDTO = new StudentDTO();

        pDTO.setUserId("hglee67");

        rList = studentService.delStudent(pDTO);

        rList.forEach(dto -> {
            log.info("DB에 저장된 아이디 : " + dto.getUserId());
            log.info("DB에 저장된 이름 : " + dto.getUserName());
            log.info("DB에 저장된 이메일 : " + dto.getEmail());
            log.info("DB에 저장된 주소 : " + dto.getAddr());
        });

        log.info("자바 프로그래밍 종료!!");
    }
}

