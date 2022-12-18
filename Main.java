import javax.swing.*;

public class Main {

	static double FirstQuarterScore, SecondQuarterScore, ThirdQuarterScore, FourthQuarterScore;

	static double FirstSummativeScore, SecondSummativeScore, ThirdSummativeScore, FourthSummativeScore;
	
	static double quiz1Score, quiz2Score, quiz3Score, quiz4Score, quiz5Score, quiz6Score, quiz7Score, quiz8Score;

	static String sstudentID ,sfirstName, slastName,subject,mario;
	
	public static String capitalizeEachName(String name) {
		String firstLetter = name.substring(0, 1);
	    	String remainingLetters = name.substring(1, name.length());
	    	firstLetter = firstLetter.toUpperCase();
	    	remainingLetters = remainingLetters.toLowerCase();
	    	name = firstLetter + remainingLetters;
	    	return name;
	}

	public static double CalculateQuarterExam(double FirstQuarterScore, double SecondQuarterScore, double ThirdQuarterScore,double FourthQuarterScore) {
		double total1 = (FirstQuarterScore  / 100) * 20;
		double total2 = (SecondQuarterScore / 100) * 20;
		double total3 = (ThirdQuarterScore  / 100) * 20;
		double total4 = (FourthQuarterScore / 100) * 40;
		return (total1 + total2 + total3 + total4);
	}

	public static double CalculateSummativeExam(double FirstSummativeScore, double SecondSummativeScore,double ThirdSummativeScore, double FourthSummativeScore) {
		double total1 = (FirstSummativeScore  / 50) * 20;
		double total2 = (SecondSummativeScore / 50) * 20;
		double total3 = (ThirdSummativeScore  / 50) * 20;
		double total4 = (FourthSummativeScore / 50) * 40;
		return (total1 + total2 + total3 + total4);
	}
	
	public static double CalculateQuiz(double quiz1Score, double quiz2Score,double quiz3Score, double quiz4Score, double quiz5Score, double quiz6Score,double quiz7Score, double quiz8Score) {
		double total1 = (quiz1Score / 20) * 10;
		double total2 = (quiz2Score / 20) * 10;
		double total3 = (quiz3Score / 20) * 10;
		double total4 = (quiz4Score / 20) * 20;
		double total5 = (quiz5Score / 20) * 10;
		double total6 = (quiz6Score / 20) * 10;
		double total7 = (quiz7Score / 20) * 10;
		double total8 = (quiz8Score / 20) * 20;
		return (total1 + total2 + total3 + total4 + total5 + total6 + total7 + total8);
	}

	public static void totalGrade() {
		
		double totalQuizScore = CalculateQuiz(quiz1Score, quiz2Score, quiz3Score, quiz4Score, quiz5Score, quiz6Score, quiz7Score, quiz8Score);

		double totalQuarterExamScore = CalculateQuarterExam(FirstQuarterScore, SecondQuarterScore, ThirdQuarterScore, FourthQuarterScore);

		double totalSummativeExamScore = CalculateSummativeExam(FirstSummativeScore, SecondSummativeScore, ThirdSummativeScore, FourthSummativeScore);
		
		String outputDialogBody = 
			"Student's ID: " + sstudentID + "\n" +
			"Student's Name: " + capitalizeEachName(sfirstName) + " " + capitalizeEachName(slastName)+ "\n" + 
			"Subject: " + subject + "\n" + 
			"\nAverage Grade on Quizes: " + String.format("%.2f",totalQuizScore) + "\n" +
			"Average Grade on Quarterly Exams: " + String.format("%.2f", totalQuarterExamScore) + "\n" + 
			"Average Grade on Summative Exams: " + String.format("%.2f", totalSummativeExamScore) + "\n" + 
			"\nOverall Total Grade: " + (String.format("%.2f", ((totalQuarterExamScore * .50) + (totalSummativeExamScore * .30) + (totalQuizScore * .20)))) + "\n \n";
		JOptionPane.showMessageDialog(null, outputDialogBody, capitalizeEachName(sfirstName) + "'s " + subject + " Subject Final Grade", JOptionPane.PLAIN_MESSAGE);
	}

	public static void summativeExam() {
		JTextField FirstSummative = new JTextField();
		JTextField SecondSummative = new JTextField();
		JTextField ThirdSummative = new JTextField();
		JTextField FourthSummative = new JTextField();

		Object[] SummativeExam = { 
				"Maximum score for each Summative Exam is 50. \n \n First Summative Exam:",FirstSummative, 
				"Second Summative Exam:", SecondSummative, 
				"Third Summative Exam:", ThirdSummative,
				"Fourth Summative Exam:", FourthSummative };

		while (true) {
			int input = JOptionPane.showConfirmDialog(null, SummativeExam, "Enter Student's Summative Exam Scores",
					JOptionPane.OK_CANCEL_OPTION);
			;
			if (input == JOptionPane.OK_OPTION) {
				try {
					FirstSummativeScore = Double.parseDouble(FirstSummative.getText());
					SecondSummativeScore = Double.parseDouble(SecondSummative.getText());
					ThirdSummativeScore = Double.parseDouble(ThirdSummative.getText());
					FourthSummativeScore = Double.parseDouble(FourthSummative.getText());
					if (FirstSummativeScore > 50 || SecondSummativeScore > 50 || ThirdSummativeScore > 50 || FourthSummativeScore > 50) {
						JOptionPane.showMessageDialog(null, "The maximum score for summative exam is 50.");
						continue;
					}
					break;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Please enter student's summative exam score.");
					continue;
				}
			} else {
				System.exit(0);
			}
		}
	}

	public static void quarterExam() {
		JTextField FirstQuarter = new JTextField();
		JTextField SecondQuarter = new JTextField();
		JTextField ThirdQuarter = new JTextField();
		JTextField FourthQuarter = new JTextField();

		Object[] firstQuarterExam = { 
				"Maximum score for each Quarterly Exam is 100. \n \n First Quarter Exam:", FirstQuarter, 
				"Second Quarter Exam:", SecondQuarter, 
				"Third Quarter Exam:", ThirdQuarter, 
				"Fourth Quarter Exam:", FourthQuarter };

		while (true) {
			int input = JOptionPane.showConfirmDialog(null, firstQuarterExam, "Enter Student's Quarter Exam Scores",
					JOptionPane.OK_CANCEL_OPTION);
			;
			if (input == JOptionPane.OK_OPTION) {
				try {
					FirstQuarterScore = Double.parseDouble(FirstQuarter.getText());
					SecondQuarterScore = Double.parseDouble(SecondQuarter.getText());
					ThirdQuarterScore = Double.parseDouble(ThirdQuarter.getText());
					FourthQuarterScore = Double.parseDouble(FourthQuarter.getText());
					if (FirstQuarterScore > 100 || SecondQuarterScore > 100 || ThirdQuarterScore > 100 || FourthQuarterScore > 100) {
						JOptionPane.showMessageDialog(null, "The maximum score for quarter exam is 100.");
						continue;
					}
					break;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Please enter student's quarter exam score.");

				}
			} else {
				System.exit(0);
			}
		}
	}
	
	public static void quizes() {

		JTextField quiz1 = new JTextField();
		JTextField quiz2 = new JTextField();
		JTextField quiz3 = new JTextField();
		JTextField quiz4 = new JTextField();
		JTextField quiz5 = new JTextField();
		JTextField quiz6 = new JTextField();
		JTextField quiz7 = new JTextField();
		JTextField quiz8 = new JTextField();

		Object[] SummativeExam = { 
				 "Maximum score for each quizes is 20. \n \n " +
				 "First Quiz:",quiz1, 
				 "Second Quiz:",quiz2, 
				 "Third Quiz:",quiz3, 
				 "Fourth Quiz:",quiz4, 
				 "Fifth Quiz:",quiz5, 
				 "Sixth Quiz:",quiz6, 
				 "Seventh Quiz:",quiz7, 
				 "Final Quiz:",quiz8 
				};

		while (true) {
			int input = JOptionPane.showConfirmDialog(null, SummativeExam, "Enter Student's Quizes Scores",
					JOptionPane.OK_CANCEL_OPTION);
			;
			if (input == JOptionPane.OK_OPTION) {
				try {
					quiz1Score = Double.parseDouble(quiz1.getText());
					quiz2Score = Double.parseDouble(quiz2.getText());
					quiz3Score = Double.parseDouble(quiz3.getText());
					quiz4Score = Double.parseDouble(quiz4.getText());
					quiz5Score = Double.parseDouble(quiz5.getText());
					quiz6Score = Double.parseDouble(quiz6.getText());
					quiz7Score = Double.parseDouble(quiz7.getText());
					quiz8Score = Double.parseDouble(quiz8.getText());
					if (quiz1Score > 20 || quiz2Score > 20 || quiz3Score > 20 || quiz4Score > 20 || quiz5Score > 20 || quiz6Score > 20 || quiz7Score > 20 || quiz8Score > 20) {
						JOptionPane.showMessageDialog(null, "The maximum score for quiz exam is 20.");
						continue;
					}
					break;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Please enter student's quizes scores.");
					continue;
				}
			} else {
				System.exit(0);
			}
		}
	}

	public static void studentInfo() {
		JTextField firstName = new JTextField();
		JTextField lastName = new JTextField();
		JTextField studentID = new JTextField();
		String[] choices = { "","Mathematics", "English","Filipino", "History", "Science", "Physical", "Education", "Arts" };
		JComboBox comboBox = new JComboBox(choices);
		Object[] fullName = { "Student's ID:",studentID, "\nStudent's First Name:", firstName, "\nStudent's Last Name:", lastName, "\n Select a Subject:", comboBox,"\n"};
		
		while (true) {
			int input = JOptionPane.showConfirmDialog(null, fullName, "Enter Student's Information",JOptionPane.OK_CANCEL_OPTION);
			if(input == JOptionPane.OK_OPTION) {
				if(studentID.getText().equals("") ) {
					JOptionPane.showMessageDialog(null, "Please enter Student's ID");
					continue;
				} else if(!studentID.getText().matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Invalid Student's ID.");
					continue;	
				} else if (firstName.getText().equals("") && lastName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter Student's First Name and Last Name.");
					continue;
				} else if (firstName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter Student's First Name.");
					continue;
				} else if (lastName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter Student's Last Name.");
					continue;
				} else if(firstName.getText().matches(".*\\d.*") && lastName.getText().matches(".*\\d.*") ) {
					JOptionPane.showMessageDialog(null, "Invalid name. Please enter Student's Name properly.");
					continue;
				} else if (firstName.getText().matches(".*\\d.*")) {
				 	JOptionPane.showMessageDialog(null, "Invalid name. Please enter Student's First Name properly.");
					continue;
				} else if (lastName.getText().matches(".*\\d.*")) {
					JOptionPane.showMessageDialog(null, "Invalid name. Please enter Student's Last Name properly.");
					continue;
				} else if (comboBox.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(null, "Please select a Subject.");
					continue;
				}
				
				sstudentID = studentID.getText();
				sfirstName = firstName.getText();
				slastName = lastName.getText();
				subject = (String)comboBox.getSelectedItem();
			} else {
				System.exit(0);
			}
			break;
		}
	}

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Welcome to Subject Final Grade Calculator");
		while(true){
			studentInfo();
			quizes();
			summativeExam();
			quarterExam();	
			totalGrade();
			int input = JOptionPane.showConfirmDialog(null, "Do you want to calculate grade for another student?", "Final Grade Calculator",JOptionPane.YES_NO_OPTION);
			if(input == JOptionPane.YES_OPTION) {
				continue;
			} else {
				System.exit(0);
			}
			
		}

	}
}
