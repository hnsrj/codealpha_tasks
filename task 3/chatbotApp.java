import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class chatbotApp extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public chatbotApp() {
        setTitle("ChatBot");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        inputField = new JTextField(25);
        sendButton = new JButton("Send");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = inputField.getText().trim().toLowerCase();
                if (!userInput.isEmpty()) {
                    chatArea.append("You: " + userInput + "\n");
                    inputField.setText("");
                    String response = getResponse(userInput);
                    chatArea.append("ChatBot: " + response + "\n");
                }
            }
        });

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendButton.doClick();
            }
        });

        setVisible(true);
    }

    private String getResponse(String input) {
        switch (input) {
            case "hello":
            case "hi":
                return "Hello! How can I help you today?";
            case "how are you":
                return "I'm fine and what about you";
            case "what is your name":
                return "I am a sam bot created in Java.";
            case "what are you doing":
                return "i'm here to solve your probelms";
            case "exit":
                System.exit(0);
                return "";
            default:
                return "I'm sorry, I don't understand that. Can you please rephrase?";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new chatbotApp();
            }
        });
    }
}




















































































// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.io.IOException;
// import okhttp3.*;

// public class chatbotApp extends JFrame { // Changed class name to ChatBotApp

//     private JTextArea chatArea;
//     private JTextField inputField;
//     private JButton sendButton;
//     private static final String OPENAI_API_KEY = "your_openai_api_key_here"; // Replace with your OpenAI API key
//     private static final String OPENAI_API_URL = "https://api.openai.com/v1/engines/davinci-codex/completions";

//     public ChatBotApp() { // Changed constructor name to ChatBotApp
//         setTitle("Java Chatbot");
//         setSize(400, 400);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);

//         // Initialize components
//         chatArea = new JTextArea();
//         chatArea.setEditable(false);
//         JScrollPane scrollPane = new JScrollPane(chatArea);
//         inputField = new JTextField(20);
//         sendButton = new JButton("Send");

//         // Layout setup
//         setLayout(new BorderLayout());
//         add(scrollPane, BorderLayout.CENTER);

//         JPanel inputPanel = new JPanel();
//         inputPanel.setLayout(new BorderLayout());
//         inputPanel.add(inputField, BorderLayout.CENTER);
//         inputPanel.add(sendButton, BorderLayout.EAST);
//         add(inputPanel, BorderLayout.SOUTH);

//         // Event handling for send button
//         sendButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 String userText = inputField.getText().trim();
//                 if (!userText.isEmpty()) {
//                     appendToChatArea("You: " + userText);
//                     try {
//                         String botResponse = getBotResponse(userText);
//                         appendToChatArea("Bot: " + botResponse);
//                     } catch (IOException ex) {
//                         appendToChatArea("Bot: Sorry, I couldn't process your request.");
//                     }
//                     inputField.setText("");
//                 }
//             }
//         });
//     }

//     private void appendToChatArea(String text) {
//         chatArea.append(text + "\n");
//     }

//     private String getBotResponse(String input) throws IOException {
//         OkHttpClient client = new OkHttpClient();

//         MediaType mediaType = MediaType.parse("application/json");
//         String json = "{\n" +
//                 "  \"prompt\": \"" + input + "\",\n" +
//                 "  \"max_tokens\": 150\n" +
//                 "}";
//         RequestBody body = RequestBody.create(mediaType, json);
//         Request request = new Request.Builder()
//                 .url(OPENAI_API_URL)
//                 .post(body)
//                 .addHeader("Content-Type", "application/json")
//                 .addHeader("Authorization", "Bearer " + OPENAI_API_KEY)
//                 .build();

//         Response response = client.newCall(request).execute();
//         if (!response.isSuccessful()) {
//             throw new IOException("Unexpected code " + response);
//         }

//         String responseBody = response.body().string();
//         // Extract the response text from the JSON response
//         // Assuming the response JSON has a structure like: {"choices":[{"text":"response text"}]}
//         String botResponse = responseBody.split("\"text\":\"")[1].split("\"")[0].trim();
//         return botResponse;
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(new Runnable() {
//             @Override
//             public void run() {
//                 ChatBotApp chatBotApp = new ChatBotApp(); // Changed instantiation to ChatBotApp
//                 chatBotApp.setVisible(true);
//             }
//         });
//     }
// }