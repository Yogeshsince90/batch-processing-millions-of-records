package com.yogesh.batchprocessing.sequentialprocessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.andreinc.mockneat.MockNeat;

@RestController
public class WriteToCSV {
	private final String FILE_NAME = "src/main/resources/employeeData.csv";

	@GetMapping(path = "/getCSVFile")
	public String writeToFile() {
		MockNeat m = MockNeat.threadLocal();
		final Path path = Paths.get(FILE_NAME);

		m.fmt("#{id},#{first},#{last},#{email},#{salary}").param("id", m.longSeq()).param("first", m.names().first())
				.param("last", m.names().last()).param("email", m.emails())
				.param("salary", m.doubles().range(2000, 15000)).list(1000000).consume(list -> {
					try {
						Files.write(path, list, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
					} catch (IOException e) {
						e.printStackTrace();
					}
				});

		return "success";

	}
	
}
