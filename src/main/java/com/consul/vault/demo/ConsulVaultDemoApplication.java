package com.consul.vault.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableConfigurationProperties({ConsulConfiguration.class, VaultConfiguration.class})
public class ConsulVaultDemoApplication {

	@Autowired
	private ConsulConfiguration consulConfig;
	
	@Autowired
	private VaultConfiguration vaultConfig;
	
	public static void main(String[] args) {
		SpringApplication.run(ConsulVaultDemoApplication.class, args);
	}
	
	@GetMapping("/getConsulConfig")
	public ConsulConfiguration getConsulConfiguration() {
		return consulConfig;
	}
	
	@GetMapping("/getVaultConfig")
	public VaultConfiguration getVaultConfiguration() {
		return vaultConfig;
	}

}
