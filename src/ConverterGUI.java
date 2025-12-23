import javax.swing.*;
import java.awt.*;

public class ConverterGUI extends JFrame {
    public final JComboBox<CurrencyType> from = new  JComboBox<>(CurrencyType.values());
    public final JComboBox<CurrencyType> to = new  JComboBox<>(CurrencyType.values());
    private final JTextField amountInput = new JTextField();
    private final JLabel resultLabel =  new JLabel("Amount: ");

    public ConverterGUI() {
        super("Currency Converter");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(460, 240);
        setLocationRelativeTo(null);

        buildUI();
    }

    private void buildUI() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Amount: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(amountInput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("From: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(from, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("To: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(to, gbc);

        JButton converterButton = new JButton("Convert");
        converterButton.addActionListener(e -> Convert());

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(converterButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(resultLabel, gbc);

        /*from.setSelectedItem(CurrencyType.SEK);
        to.setSelectedItem(CurrencyType.USD);*/

        add(panel);

    }

    private void Convert() {
        try {

        CurrencyType fromCurrency = (CurrencyType) from.getSelectedItem();
        CurrencyType toCurrency = (CurrencyType) to.getSelectedItem();

        double amount = Double.parseDouble(amountInput.getText().trim());

        CurrencyConverter converter = ConverterFactory.getConverter(fromCurrency);
        double result = converter.convertTo(amount, toCurrency);

        resultLabel.setText(String.format("Amount: %.2f %s = %.2f %s",  amount, fromCurrency.name(), result,
                toCurrency.name()));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid number.",
                             "Invalid amount",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            }

        }

    }
