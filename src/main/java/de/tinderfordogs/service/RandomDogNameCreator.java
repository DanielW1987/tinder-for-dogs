package de.tinderfordogs.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.Random;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class RandomDogNameCreator {

  private final ResourceLoader resourceLoader;
  private final ObjectMapper objectMapper;
  private final Random random;

  public RandomDogNameCreator(ResourceLoader resourceLoader, ObjectMapper objectMapper) {
    this.resourceLoader = resourceLoader;
    this.objectMapper = objectMapper;
    random = new Random();
  }

  public String randomDogName() {
    Resource resource = resourceLoader.getResource("classpath:dog-names.json");
    try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
      List<String> names = objectMapper.readValue(reader, new TypeReference<>() {});
      return names.get(random.nextInt(names.size()));
    }
    catch (IOException ioe) {
      throw new UncheckedIOException(ioe);
    }
  }
}
