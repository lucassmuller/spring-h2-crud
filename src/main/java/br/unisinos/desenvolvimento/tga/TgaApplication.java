package br.unisinos.desenvolvimento.tga;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TgaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TgaApplication.class, args);
	}

}
