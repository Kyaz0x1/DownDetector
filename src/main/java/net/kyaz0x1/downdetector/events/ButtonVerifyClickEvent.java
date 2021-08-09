package net.kyaz0x1.downdetector.events;

import net.kyaz0x1.downdetector.service.WebService;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ButtonVerifyClickEvent implements ActionListener {

    private final JTextField txtLink;
    private final WebService service;

    public ButtonVerifyClickEvent(JTextField txtLink){
        this.txtLink = txtLink;
        this.service = WebService.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final String link = txtLink.getText();

        if(link.isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe a url!", "DownDetector", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!link.startsWith("http://") && !link.startsWith("https://")){
            JOptionPane.showMessageDialog(null, "A url informada é inválida!", "DownDetector", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            final int responseCode = service.getResponseCode(link);
            final List<String> messageList = Arrays.asList(
                    "DownDetector v1.0.0",
                    "",
                    "• Site: " + link,
                    "• Response code: " + responseCode,
                    "",
                    responseCode == HttpURLConnection.HTTP_OK ?
                            "O site em especifico está funcionando perfeitamente!" :
                            "Parece que o site em especifico está fora do ar!"
            );

            final String message = messageList.stream()
                    .collect(Collectors.joining("\n"));

            JOptionPane.showMessageDialog(null, message, "DownDetector",
                    responseCode == HttpURLConnection.HTTP_OK ?
                            JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao verificar o site, certifique-se de que você digitou o site corretamente!", "DownDetector", JOptionPane.ERROR_MESSAGE);
        }
    }

}