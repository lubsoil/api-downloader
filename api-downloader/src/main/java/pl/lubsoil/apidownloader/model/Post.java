package pl.lubsoil.apidownloader.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public record Post(int id, int userId, String title, String body) {
}
