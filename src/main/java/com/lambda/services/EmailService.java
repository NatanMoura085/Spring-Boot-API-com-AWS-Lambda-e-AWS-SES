        package com.lambda.services;

        import com.lambda.model.EmailTemplate;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.stereotype.Service;
        import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
        import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
        import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
        import software.amazon.awssdk.regions.Region;
        import software.amazon.awssdk.services.ses.SesClient;
        import software.amazon.awssdk.services.ses.model.*;

        import java.util.HashMap;
        import java.util.Map;

        @Service
        public class EmailService {
            private final SesClient sesClient;
            @Value("${aws.ses.sender}")
            private String remetente;

            public EmailService(@Value("${aws.access-key}") String accessKey,
                                      @Value("${aws.secret-key}") String secretKey,
                                      @Value("${aws.region}") String region) {
                this.sesClient = SesClient.builder()
                        .region(Region.of(region))
                        .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey)))
                        .build();
            }


            public void sendEmail(String to, String subject, Map<String, Object> templateModel) {
                String htmlBody = generateHtml(templateModel);

                SendEmailRequest emailRequest = SendEmailRequest.builder()
                        .destination(Destination.builder().toAddresses(to).build())
                        .message(Message.builder()
                                .subject(Content.builder().data(subject).build())
                                .body(Body.builder()
                                        .html(Content.builder().data(htmlBody).build())
                                        .build())
                                .build())
                        .source(remetente)
                        .build();

                sesClient.sendEmail(emailRequest);
            }

            private String generateHtml(Map<String, Object> templateModel) {
                return "<html><body>" +
                        "<h1>Olá, " + templateModel.getOrDefault("nome", "Cliente") + "!</h1>" +
                        "<p>Valor: " + templateModel.getOrDefault("valor", "N/A") + "</p>" +
                        "<p>Data: " + templateModel.getOrDefault("data", "Indefinida") + "</p>" +
                        "<img src='https://imagenstatic.s3.us-east-1.amazonaws.com/picpayIMG.png' width='200'/>" +
                        "</body></html>";
            }

            public Map<String, Object> populateTemplate(EmailTemplate emailTemplate) {
                Map<String, Object> templateData = new HashMap<>();
                templateData.put("nome", emailTemplate.getNome());
                templateData.put("valor", emailTemplate.getValor());
                templateData.put("data", emailTemplate.getData());
                return templateData;
            }
        }
