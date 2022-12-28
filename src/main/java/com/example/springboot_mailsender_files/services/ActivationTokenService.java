package com.example.springboot_mailsender_files.services;
import com.example.springboot_mailsender_files.dao.ActivationTokenDAO;
import com.example.springboot_mailsender_files.models.ActivationToken;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ActivationTokenService {
    private ActivationTokenDAO activationTokenDAO;

    @Scheduled(fixedDelay = 2000)  // кожні 2 секунди запускає цей метод
    public void deleteTokenIfExpired(){
      System.out.println("*");
      List<ActivationToken> tokenList= activationTokenDAO.findAll();
      tokenList.forEach(token -> {
          if(LocalDateTime.now().isAfter(token.getExpire())){
              activationTokenDAO.deleteById(token.getId());
          }
      });
    }

}
