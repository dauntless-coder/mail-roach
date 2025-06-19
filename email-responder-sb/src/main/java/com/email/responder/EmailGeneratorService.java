package com.email.responder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmailGeneratorService {

    @Value("${gemini.api.url}")
    private String geminiAPIUrl;
    @Value("${gemini.api.key}")
    private String geminiAPIKey;

    public String generateEmailReply(EmailRequest emailRequest){
        //Build the prompt

        String prompt = buildPrompt(emailRequest);

        //Craft a request
        Map<String, Object> requestBody = Map.of(
                "contents" , new Object[] {
                        Map.of("parts", new Object[]{
                                Map.of(
                                        "text", prompt
                                )
                        })
                }
        );
        //Do request and get response


        //Return Response
        return ""; // Placeholder return to fix missing return error

    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a professional email reply based on the following email content. Please don't  generate a subject line ");
        if (emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()) {
            prompt.append("Use a : ").append(emailRequest.getTone()).append("tone. ");

        }
        prompt.append("\n Original Email: \n").append(emailRequest.getEmailContent());

        return prompt.toString();
    }
}
