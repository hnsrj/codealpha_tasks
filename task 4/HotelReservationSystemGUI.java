import java.awt.*;
import java.time.LocalDate;
import javax.swing.*;

public class HotelReservationSystemGUI extends JFrame {
    // Components
    private JTextField checkInDateField;
    private JTextField checkOutDateField;
    private JComboBox<String> roomTypeComboBox;
    private JTextArea resultArea;

    public HotelReservationSystemGUI() {
        setTitle("Hotel Reservation System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel checkInLabel = new JLabel("Check-In Date:");
        checkInDateField = new JTextField();
        panel.add(checkInLabel);
        panel.add(checkInDateField);

        JLabel checkOutLabel = new JLabel("Check-Out Date:");
        checkOutDateField = new JTextField();
        panel.add(checkOutLabel);
        panel.add(checkOutDateField);

        JLabel roomTypeLabel = new JLabel("Room Type:");
        roomTypeComboBox = new JComboBox<>();
        roomTypeComboBox.addItem("Single");
        roomTypeComboBox.addItem("Double");
        roomTypeComboBox.addItem("Suite");
        panel.add(roomTypeLabel);
        panel.add(roomTypeComboBox);

        JButton searchButton = new JButton("Search Rooms");
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        searchButton.addActionListener(e -> searchRooms());
        panel.add(searchButton);
        panel.add(scrollPane);

        add(panel);
    }

    private void searchRooms() {
        LocalDate checkInDate = LocalDate.parse(checkInDateField.getText());
        LocalDate checkOutDate = LocalDate.parse(checkOutDateField.getText());
        String roomType = (String) roomTypeComboBox.getSelectedItem();

        // Implement room search logic here

        // Example result display
        resultArea.setText("Available Rooms:\n");
        resultArea.append("Room ID: 101, Type: " + roomType + ", Price: $100\n");
        resultArea.append("Room ID: 102, Type: " + roomType + ", Price: $120\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HotelReservationSystemGUI().setVisible(true);
        });
    }
}
    