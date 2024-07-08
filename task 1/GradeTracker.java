import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GradeTracker extends JFrame {
    private ArrayList<Student> students;
    private JTextField studentNameField;
    private JTextField gradeField;
    private JTextArea displayArea;
    private JComboBox<String> studentComboBox;

    public GradeTracker() {
        students = new ArrayList<>();
        createGUI();
    }

    private void createGUI() {
        setTitle("Student Grade Tracker");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel studentNameLabel = new JLabel("Student Name:");
        studentNameField = new JTextField();
        panel.add(studentNameLabel);
        panel.add(studentNameField);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeField = new JTextField();
        panel.add(gradeLabel);
        panel.add(gradeField);

        JButton addStudentButton = new JButton("Add Student");
        JButton addGradeButton = new JButton("Add Grade");
        JButton displayInfoButton = new JButton("Display Student Info");
        JButton exitButton = new JButton("Exit");

        panel.add(addStudentButton);
        panel.add(addGradeButton);
        panel.add(displayInfoButton);
        panel.add(exitButton);

        studentComboBox = new JComboBox<>();
        panel.add(new JLabel("Select Student:"));
        panel.add(studentComboBox);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        addGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addGrade();
            }
        });

        displayInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStudentInfo();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void addStudent() {
        String name = studentNameField.getText();
        if (!name.isEmpty()) {
            students.add(new Student(name));
            studentComboBox.addItem(name);
            displayArea.append("Student added: " + name + "\n");
            studentNameField.setText("");
        } else {
            displayArea.append("Please enter a student name.\n");
        }
    }

    private void addGrade() {
        String selectedStudent = (String) studentComboBox.getSelectedItem();
        String gradeText = gradeField.getText();
        if (selectedStudent != null && !gradeText.isEmpty()) {
            try {
                int grade = Integer.parseInt(gradeText);
                Student student = findStudentByName(selectedStudent);
                if (student != null) {
                    student.addGrade(grade);
                    displayArea.append("Grade added for " + selectedStudent + ": " + grade + "\n");
                    gradeField.setText("");
                } else {
                    displayArea.append("Student not found.\n");
                }
            } catch (NumberFormatException e) {
                displayArea.append("Please enter a valid grade.\n");
            }
        } else {
            displayArea.append("Please select a student and enter a grade.\n");
        }
    }

    private void displayStudentInfo() {
        String selectedStudent = (String) studentComboBox.getSelectedItem();
        if (selectedStudent != null) {
            Student student = findStudentByName(selectedStudent);
            if (student != null) {
                displayArea.append("Student Name: " + student.getName() + "\n");
                displayArea.append("Grades: " + student.getGrades() + "\n");
                displayArea.append("Average Grade: " + student.getAverageGrade() + "\n");
                displayArea.append("Highest Grade: " + student.getHighestGrade() + "\n");
                displayArea.append("Lowest Grade: " + student.getLowestGrade() + "\n");
            } else {
                displayArea.append("Student not found.\n");
            }
        } else {
            displayArea.append("Please select a student.\n");
        }
    }

    private Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GradeTracker().setVisible(true);
            }
        });
    }
}
