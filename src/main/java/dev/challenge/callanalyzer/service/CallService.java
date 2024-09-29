package dev.challenge.callanalyzer.service;

import dev.challenge.callanalyzer.repository.CallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CallService {
    private final CallRepository callRepository;
}
