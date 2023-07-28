package org.kr.exrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
  libtcnative-2.so
  https://tomcat.apache.org/tomcat-8.5-doc/apr.html
  https://tomcat.apache.org/download-native.cgi
 */
@SpringBootApplication
public class ExRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExRestApplication.class, args);
	}

}
