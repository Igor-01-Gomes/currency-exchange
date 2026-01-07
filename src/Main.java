import javax.swing.SwingUtilities;

void main() {
    // CURRENCY EXCHANGE RATE ARE FROM 7/1 - 2026
    SwingUtilities.invokeLater(() -> {
        ConverterGUI gui = new ConverterGUI();
        gui.setVisible(true);
    });
}


