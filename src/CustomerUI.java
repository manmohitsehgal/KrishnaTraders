import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustomerUI extends JPanel {

	public static void main(String[] args) {
		final JFrame mainFrame = new JFrame("Krishna Traders");
		mainFrame.setSize(700, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JPanel mainPanel = new JPanel(new BorderLayout());
		mainFrame.add(mainPanel);
		// placeComponents(mainPanel);
		mainPanel.setLayout(null);

		JLabel dateLabel = new JLabel("Date:");
		dateLabel.setBounds(10, 10, 160, 25);
		mainPanel.add(dateLabel);

		final JTextField todaysDate = new JTextField(10);
		todaysDate.setBounds(135, 10, 160, 25);
		mainPanel.add(todaysDate);

		JLabel receivedFromLabel = new JLabel("Received From:");
		receivedFromLabel.setBounds(10, 40, 200, 25);
		mainPanel.add(receivedFromLabel);

		final JTextField receivedFrom = new JTextField(50);
		receivedFrom.setBounds(135, 40, 200, 25);
		mainPanel.add(receivedFrom);

		JLabel descriptionLabel = new JLabel("Description:");
		descriptionLabel.setBounds(10, 70, 200, 25);
		mainPanel.add(descriptionLabel);

		final JTextField description = new JTextField(50);
		description.setBounds(135, 70, 200, 80);
		mainPanel.add(description);

		JLabel weightLabel = new JLabel("Weight:");
		weightLabel.setBounds(10, 160, 200, 25);
		mainPanel.add(weightLabel);

		final JTextField weight = new JTextField(50);
		weight.setBounds(135, 160, 200, 25);
		mainPanel.add(weight);

		JLabel chalanLabel = new JLabel("Chalan number:");
		chalanLabel.setBounds(10, 190, 200, 25);
		mainPanel.add(chalanLabel);

		final JTextField chalanNumber = new JTextField(50);
		chalanNumber.setBounds(135, 190, 200, 25);
		mainPanel.add(chalanNumber);

		JLabel quantityLabel = new JLabel("Quantity (meter):");
		quantityLabel.setBounds(10, 220, 200, 25);
		mainPanel.add(quantityLabel);

		final JTextField quantity = new JTextField(50);
		quantity.setBounds(135, 220, 200, 25);
		mainPanel.add(quantity);

		JLabel totalShawlsLabel = new JLabel("No. of shawls:");
		totalShawlsLabel.setBounds(10, 250, 200, 25);
		mainPanel.add(totalShawlsLabel);

		final JTextField totalShawls = new JTextField(50);
		totalShawls.setBounds(135, 250, 200, 25);
		mainPanel.add(totalShawls);

		JLabel qualityLabel = new JLabel("Quality:");
		qualityLabel.setBounds(10, 280, 200, 25);
		mainPanel.add(qualityLabel);

		final JTextField quality = new JTextField(50);
		quality.setBounds(135, 280, 200, 25);
		mainPanel.add(quality);

		JLabel deliveredLabel = new JLabel("Delivered to:");
		deliveredLabel.setBounds(10, 310, 200, 25);
		mainPanel.add(deliveredLabel);

		final JTextField deliveredTo = new JTextField(50);
		deliveredTo.setBounds(135, 310, 200, 25);
		mainPanel.add(deliveredTo);
		// Buttons
		/*
		 * ADD CHALAN
		 */
		JButton addCustomer = new JButton(new AbstractAction("Add Chalan") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JFrame addCustomerFrame = new JFrame("Add New Customer");
				addCustomerFrame.setSize(700, 500);
				addCustomerFrame
						.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				JPanel addCustomerPanel = new JPanel(new BorderLayout());

				JLabel chalanNumberLabel = new JLabel("Chalan No.:");
				chalanNumberLabel.setBounds(10, 10, 160, 25);
				addCustomerPanel.add(chalanNumberLabel);

				final JTextField chalanNo = new JTextField(50);
				chalanNo.setBounds(125, 10, 160, 25);
				addCustomerPanel.add(chalanNo);

				JLabel companyNameLabel = new JLabel("Company Name:");
				companyNameLabel.setBounds(10, 40, 160, 25);
				addCustomerPanel.add(companyNameLabel);

				final JTextField comapnyName = new JTextField(50);
				comapnyName.setBounds(125, 40, 160, 25);
				addCustomerPanel.add(comapnyName);

				JLabel dateLabel = new JLabel("Date:");
				dateLabel.setBounds(10, 70, 160, 25);
				addCustomerPanel.add(dateLabel);

				final JTextField dateField = new JTextField(50);
				dateField.setBounds(125, 70, 160, 25);
				addCustomerPanel.add(dateField);

				Date todaysDateIs = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(todaysDateIs);
				String formatedTodaysDate = cal.get(Calendar.DATE) + "/"
						+ (cal.get(Calendar.MONTH) + 1) + "/"
						+ cal.get(Calendar.YEAR);
				dateField.setText(formatedTodaysDate);

				JLabel deliveredToLabel = new JLabel("Delivered To:");
				deliveredToLabel.setBounds(10, 100, 160, 25);
				addCustomerPanel.add(deliveredToLabel);

				final JTextField deliveredTo = new JTextField(50);
				deliveredTo.setBounds(125, 100, 160, 25);
				addCustomerPanel.add(deliveredTo);

				JLabel quantityLabel = new JLabel("Quantity:");
				quantityLabel.setBounds(10, 130, 160, 25);
				addCustomerPanel.add(quantityLabel);

				final JTextField quantity = new JTextField(50);
				quantity.setBounds(125, 130, 160, 25);
				addCustomerPanel.add(quantity);

				JLabel rateLabel = new JLabel("Rate:");
				rateLabel.setBounds(10, 160, 160, 25);
				addCustomerPanel.add(rateLabel);

				final JTextField rate = new JTextField(50);
				rate.setBounds(125, 160, 160, 25);
				addCustomerPanel.add(rate);

				JLabel amountLabel = new JLabel("Amount:");
				amountLabel.setBounds(10, 190, 160, 25);
				addCustomerPanel.add(amountLabel);

				final JTextField amount = new JTextField(50);
				amount.setBounds(125, 190, 160, 25);
				addCustomerPanel.add(amount);

				JLabel descriptionLabel = new JLabel("Description:");
				descriptionLabel.setBounds(10, 220, 160, 25);
				addCustomerPanel.add(descriptionLabel);

				final JTextField description = new JTextField(50);
				description.setBounds(125, 220, 200, 80);
				addCustomerPanel.add(description);

				addCustomerFrame.add(addCustomerPanel);
				addCustomerPanel.setLayout(null);

				JButton addCustomerToDatabase = new JButton(new AbstractAction(
						"Add Customer to databse") {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Customers customer = new Customers();

						Date todaysDate = new Date();
						Calendar cal = Calendar.getInstance();
						cal.setTime(todaysDate);
						String formatedDate = cal.get(Calendar.DATE) + "/"
								+ (cal.get(Calendar.MONTH) + 1) + "/"
								+ cal.get(Calendar.YEAR);
						System.out.println("formatedDate : " + formatedDate);
						customer.addCustomer(chalanNo.getText(),
								comapnyName.getText(), formatedDate,
								deliveredTo.getText(), quantity.getText(),
								rate.getText(), amount.getText(),
								description.getText());
					}
				});

				addCustomerToDatabase.setBounds(110, 300, 300, 70);
				addCustomerPanel.add(addCustomerToDatabase);
				addCustomerFrame.setVisible(true);
			}
		});

		addCustomer.setBounds(10, 360, 150, 70);
		mainPanel.add(addCustomer);

		/*
		 * DYING INFORMATION: 1. Specifies what company are goods sent for dying
		 * 2. On What date 3. What the chalan number is ( primary key and look
		 * up key ) 4. What Quantity (weight) 5. How much is sent ( in meters)
		 * 6. No of shawls that were sent
		 */
		JButton addDyingInformation = new JButton(new AbstractAction(
				"Add Dying Information") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JFrame addDyingFrame = new JFrame("Add Dying Information");
				addDyingFrame.setSize(700, 500);
				addDyingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				JPanel addDyingPanel  = new JPanel(new BorderLayout());

				JLabel sentToDyingLabel = new JLabel("Sent to:");
				sentToDyingLabel.setBounds(10, 10, 160, 25);
				addDyingPanel.add(sentToDyingLabel);

				final JTextField sentToDying = new JTextField(50);
				sentToDying.setBounds(140, 10, 160, 25);
				addDyingPanel.add(sentToDying);

				JLabel dyingDateFieldLabel = new JLabel("Date:");
				dyingDateFieldLabel.setBounds(10, 40, 160, 25);
				addDyingPanel.add(dyingDateFieldLabel);

				final JTextField dyingDateField = new JTextField(50);
				dyingDateField.setBounds(140, 40, 160, 25);
				addDyingPanel.add(dyingDateField);

				Date todaysDateIs = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(todaysDateIs);
				String formatedTodaysDate = cal.get(Calendar.DATE) + "/"
						+ (cal.get(Calendar.MONTH) + 1) + "/"
						+ cal.get(Calendar.YEAR);
				dyingDateField.setText(formatedTodaysDate);

				JLabel dyingChalanNoLabel = new JLabel("Chalan no. :");
				dyingChalanNoLabel.setBounds(10, 70, 160, 25);
				addDyingPanel.add(dyingChalanNoLabel);

				final JTextField dyingChalanNumber = new JTextField(50);
				dyingChalanNumber.setBounds(140, 70, 160, 25);
				addDyingPanel.add(dyingChalanNumber);

				JLabel quantityInWeightLabel = new JLabel("Quantity (weight):");
				quantityInWeightLabel.setBounds(10, 100, 160, 25);
				addDyingPanel.add(quantityInWeightLabel);

				final JTextField quantityInWeight = new JTextField(50);
				quantityInWeight.setBounds(140, 100, 160, 25);
				addDyingPanel.add(quantityInWeight);

				JLabel lengthInMetersLabel = new JLabel("Meters:");
				lengthInMetersLabel.setBounds(10, 130, 160, 25);
				addDyingPanel.add(lengthInMetersLabel);

				final JTextField lengthInMeter = new JTextField(50);
				lengthInMeter.setBounds(140, 130, 160, 25);
				addDyingPanel.add(lengthInMeter);

				JLabel totalShawlsLabel = new JLabel("No. of shawls:");
				totalShawlsLabel.setBounds(10, 160, 160, 25);
				addDyingPanel.add(totalShawlsLabel);

				final JTextField totalShawls = new JTextField(50);
				totalShawls.setBounds(140, 160, 160, 25);
				addDyingPanel.add(totalShawls);

				addDyingFrame.add(addDyingPanel);
				addDyingPanel.setLayout(null);

				JButton addDyingInformationToDatabase = new JButton(
						new AbstractAction("Add dying information to database") {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								Customers customer = new Customers();

								Date todaysDate_2 = new Date();
								Calendar cal = Calendar.getInstance();
								cal.setTime(todaysDate_2);
								String formatedDate_2 = cal.get(Calendar.DATE)
										+ "/" + (cal.get(Calendar.MONTH) + 1)
										+ "/" + cal.get(Calendar.YEAR);
								System.out.println("formatedDate : "
										+ formatedDate_2);
								customer.addDyingInformation(sentToDying.getText(),
										formatedDate_2,
										dyingChalanNumber.getText(),
										quantityInWeight.getText(),
										lengthInMeter.getText(),
										totalShawls.getText());
							}

						});

				addDyingInformationToDatabase.setBounds(110, 300, 300, 70);
				addDyingPanel.add(addDyingInformationToDatabase);
				addDyingFrame.setVisible(true);

			}

		});

		addDyingInformation.setBounds(200, 360, 200, 70);
		mainPanel.add(addDyingInformation);

		
		/*****************************************************************************************************/
		
		JButton addFinishingInformation = new JButton(new AbstractAction(
				"Add Finishing Information") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JFrame addFinishingFrame = new JFrame("Add Finishing Information");
				addFinishingFrame.setSize(700, 500);
				addFinishingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				JPanel addFinishingPanel  = new JPanel(new BorderLayout());

				JLabel sentToDyingLabel = new JLabel("Sent to:");
				sentToDyingLabel.setBounds(10, 10, 160, 25);
				addFinishingPanel.add(sentToDyingLabel);

				final JTextField sentToDying = new JTextField(50);
				sentToDying.setBounds(140, 10, 160, 25);
				addFinishingPanel.add(sentToDying);

				JLabel dyingDateFieldLabel = new JLabel("Date:");
				dyingDateFieldLabel.setBounds(10, 40, 160, 25);
				addFinishingPanel.add(dyingDateFieldLabel);

				final JTextField dyingDateField = new JTextField(50);
				dyingDateField.setBounds(140, 40, 160, 25);
				addFinishingPanel.add(dyingDateField);

				Date todaysDateIs = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(todaysDateIs);
				String formatedTodaysDate = cal.get(Calendar.DATE) + "/"
						+ (cal.get(Calendar.MONTH) + 1) + "/"
						+ cal.get(Calendar.YEAR);
				dyingDateField.setText(formatedTodaysDate);

				JLabel dyingChalanNoLabel = new JLabel("Chalan no. :");
				dyingChalanNoLabel.setBounds(10, 70, 160, 25);
				addFinishingPanel.add(dyingChalanNoLabel);

				final JTextField dyingChalanNumber = new JTextField(50);
				dyingChalanNumber.setBounds(140, 70, 160, 25);
				addFinishingPanel.add(dyingChalanNumber);

				JLabel quantityInWeightLabel = new JLabel("Quantity (weight):");
				quantityInWeightLabel.setBounds(10, 100, 160, 25);
				addFinishingPanel.add(quantityInWeightLabel);

				final JTextField quantityInWeight = new JTextField(50);
				quantityInWeight.setBounds(140, 100, 160, 25);
				addFinishingPanel.add(quantityInWeight);

				JLabel lengthInMetersLabel = new JLabel("Meters:");
				lengthInMetersLabel.setBounds(10, 130, 160, 25);
				addFinishingPanel.add(lengthInMetersLabel);

				final JTextField lengthInMeter = new JTextField(50);
				lengthInMeter.setBounds(140, 130, 160, 25);
				addFinishingPanel.add(lengthInMeter);

				JLabel totalShawlsLabel = new JLabel("No. of shawls:");
				totalShawlsLabel.setBounds(10, 160, 160, 25);
				addFinishingPanel.add(totalShawlsLabel);

				final JTextField totalShawls = new JTextField(50);
				totalShawls.setBounds(140, 160, 160, 25);
				addFinishingPanel.add(totalShawls);

				addFinishingFrame.add(addFinishingPanel);
				addFinishingPanel.setLayout(null);

				JButton addFinishingInformationToDatabase = new JButton(
						new AbstractAction("Add Finishing information to database") {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								Customers customer = new Customers();

								Date todaysDate_2 = new Date();
								Calendar cal = Calendar.getInstance();
								cal.setTime(todaysDate_2);
								String formatedDate_2 = cal.get(Calendar.DATE)
										+ "/" + (cal.get(Calendar.MONTH) + 1)
										+ "/" + cal.get(Calendar.YEAR);
								System.out.println("formatedDate : "
										+ formatedDate_2);
								customer.addDyingInformation(sentToDying.getText(),
										formatedDate_2,
										dyingChalanNumber.getText(),
										quantityInWeight.getText(),
										lengthInMeter.getText(),
										totalShawls.getText());
							}

						});

				addFinishingInformationToDatabase.setBounds(110, 300, 300, 70);
				addFinishingPanel.add(addFinishingInformationToDatabase);
				addFinishingFrame.setVisible(true);

			}

		});

		addFinishingInformation.setBounds(450, 360, 240, 70);
		mainPanel.add(addFinishingInformation);
		
		
		

		/*
		 * JButton delCustomer = new JButton(new AbstractAction("Del") {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO
		 * Auto-generated method stub
		 * 
		 * Customers customer = new Customers(); int cIdToDelete =
		 * Integer.parseInt(customerId.getText()); boolean value =
		 * customer.deleteCustomer(cIdToDelete); if (value == true) {
		 * customerId.setText(""); firstName.setText(""); lastName.setText("");
		 * System.out.println("customer id with : " + cIdToDelete + " deleted");
		 * } else { JOptionPane.showMessageDialog(mainFrame,
		 * "Customer Id not found.", "Inane error", JOptionPane.ERROR_MESSAGE);
		 * } } });
		 * 
		 * delCustomer.setBounds(130, 130, 120, 70); mainPanel.add(delCustomer);
		 * 
		 * JButton updateCustomer = new JButton(new AbstractAction("Update") {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO
		 * Auto-generated method stub Customers customer = new Customers(); int
		 * cId = Integer.parseInt(customerId.getText()); String updatedFirstName
		 * = firstName.getText(); String updatedLastName = lastName.getText();
		 * customer.updateCustomer(cId, updatedFirstName, updatedLastName);
		 * 
		 * } });
		 * 
		 * updateCustomer.setBounds(220, 130, 120, 70);
		 * mainPanel.add(updateCustomer);
		 * 
		 * JButton getCustomer = new JButton(new AbstractAction("Retreive") { //
		 * customerId
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO
		 * Auto-generated method stub Customers customer = new Customers(); int
		 * cId = Integer.parseInt(customerId.getText());
		 * 
		 * List<String> value = customer.getCustomerUsingId(cId); if (value ==
		 * null) { JOptionPane.showMessageDialog(mainFrame,
		 * "Customer Id not found.", "Krishna Traders",
		 * JOptionPane.ERROR_MESSAGE); } else { firstName.setText(value.get(0));
		 * lastName.setText(value.get(1)); } } });
		 * 
		 * getCustomer.setBounds(310, 130, 100, 70); mainPanel.add(getCustomer);
		 */

		mainFrame.setVisible(true);
	}

}