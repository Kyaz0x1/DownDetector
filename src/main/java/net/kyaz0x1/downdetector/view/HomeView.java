package net.kyaz0x1.downdetector.view;

import com.formdev.flatlaf.FlatLightLaf;
import net.kyaz0x1.downdetector.events.ButtonVerifyClickEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HomeView extends JFrame {

    private final JLabel lblEnterLink;
    private final JTextField txtLink;
    private final JButton btnVerify;

    public HomeView(){
        super("DownDetector v1.0.0");
        setSize(300, 120);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        FlatLightLaf.setup();

        this.lblEnterLink = new JLabel("Informe o link do site:");
        lblEnterLink.setBounds(85, 5, 130, 20);

        add(lblEnterLink);

        this.txtLink = new JTextField();
        txtLink.setBounds(10, 27, 265, 25);
        txtLink.putClientProperty("JTextField.placeholderText", "Digite a url...");

        add(txtLink);

        this.btnVerify = new JButton("Verificar");
        btnVerify.setBounds(90, 55, 100, 20);
        btnVerify.addActionListener(new ButtonVerifyClickEvent(txtLink));

        add(btnVerify);
    }

}