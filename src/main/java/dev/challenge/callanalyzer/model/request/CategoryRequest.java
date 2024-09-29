package dev.challenge.callanalyzer.model.request;

import java.util.List;

public record CategoryRequest(String title, List<String> points) {
}
