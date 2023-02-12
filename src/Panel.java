import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Panel extends JPanel implements ActionListener{

    JTextField campoTexto = new JTextField("");
    JButton botão = new JButton("Converter");
    static JLabel labelErro = new JLabel("");

    public Panel(int largura, int altura){

        setSize(largura,altura);
        setLayout(null);

        campoTexto.addActionListener(this);
        campoTexto.setBounds(40,50,220,40);

        botão.addActionListener(this);
        botão.setBounds(100,110,100,30);

        labelErro.setForeground(Color.RED);
        labelErro.setBounds(30,155,240,20);

        add(campoTexto);
        add(botão);
        add(labelErro);
    }

    public void setCampoTexto(String texto, String cor){
        if(cor == "black"){
            campoTexto.setForeground(Color.BLACK);
        }else if(cor == "gray"){
            campoTexto.setForeground(Color.GRAY);
        }else if(cor == "green"){
            campoTexto.setForeground(Color.GREEN);
        }

        campoTexto.setText(texto);
        botão.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        labelErro.setText("");

        String ctTexto = campoTexto.getText().replace(",",".");

        try{
            setCampoTexto(new NotaçãoCientifica().getNotaçãoCientifica(ctTexto), "green");
        }catch(Exception error){
            labelErro.setText("*Não é possivel converter esse número!*");
        }            
    }

}
