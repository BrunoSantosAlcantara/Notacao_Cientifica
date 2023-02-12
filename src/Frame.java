import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Frame extends JFrame implements MouseListener{
    
    Panel painel;

    public Frame(){

        setTitle("Notação Científica");
        setSize(315,235);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        addMouseListener(this);

        painel = new Panel(getWidth(),getHeight());
        painel.campoTexto.addMouseListener(this);
        add(painel);

        setVisible(true);

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == painel.campoTexto){
            painel.setCampoTexto("", "black");
        }else{
            painel.setCampoTexto("Insira o número ou notação aqui!", "gray");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}
