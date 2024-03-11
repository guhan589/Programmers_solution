//package com.gpt;
//
//
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class GptTest {
//
//    private static String callChatGPT(String prompt) {
//        try {
//            URL url = new URL("https://api.openai.com/v1/completions");
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            httpURLConnection.setRequestMethod("POST");
//            httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
//            httpURLConnection.setRequestProperty("Authorization", "Bearer " + System.getenv("OPENAI_API_KEY"));
//            httpURLConnection.setDoOutput(true);
//
//            String input = "{\"model\": \"text-davinci-003\", \"prompt\": \"" + prompt + "\",\"max_tokens\" : 1024}";
//
//            try (OutputStream os = httpURLConnection.getOutputStream()) {
//                byte[] inputBytes = input.getBytes("utf-8");
//                os.write(inputBytes, 0, inputBytes.length);
//            }
//
//            int resCode = httpURLConnection.getResponseCode();
//            System.out.println("resCode:" + resCode);
//
//            try (BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"))) {
//                StringBuilder res = new StringBuilder();
//                String resLine = null;
//
//                while ((resLine = br.readLine()) != null) {
//                    res.append(resLine.trim());
//                }
//
//                return (res.toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "";
//    }
//
//    public static void main(String[] args) {
//        String prompt = "What is Seoul?";
//
//        String res = callChatGPT(prompt);
//
//        JSONParser jsonParser = new JSONParser();
//
//        try {
//            Object obj = jsonParser.parse(res);
//            JSONObject jsonObject = (JSONObject) obj;
//            System.out.println(res);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
