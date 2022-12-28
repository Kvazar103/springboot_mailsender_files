package com.example.springboot_mailsender_files.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@Configuration // ця анотац каже що цей клас буде слідкувати за різноманітними методами
// в інших класах в яких є анотація  @Scheduled
public class SchedulerConfig { // конфігураційний клас
}
